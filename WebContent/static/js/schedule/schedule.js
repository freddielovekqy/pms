$(function() {
  var initEditSchedule = function() {
    var scheduleId = $(this).parents('.schedule').find('.scheduleId').html();
    $.ajax({
      url: BASE_PATH + '/schedule/initEditSchedule?scheduleId=' + scheduleId,
      type: 'GET',
      success: function(data) {
        var scheduleDTO = data;
        $('[name="id"]').val(scheduleDTO.id);
        $('[name="name"]').val(scheduleDTO.name);
        $('[name="description"]').html(scheduleDTO.description);
        $('[name="place"]').val(scheduleDTO.place);
        $('[name="startTime"]').val(scheduleDTO.longStartTimeStr);
        $('[name="time"]').val(scheduleDTO.time);
      }
    });
  };

  var updateSchedule = function() {
    $form = $('.update-schedule-form');
    var options = {
      url: BASE_PATH + '/schedule/updateSchedule',
      type: 'POST',
      success: function(data) {
        var scheduleDTO = data;
        var $scheduleTr = $('.schedule.' + scheduleDTO.id);
        $scheduleTr.find('.scheduleName').html(scheduleDTO.name);
        $scheduleTr.find('.scheduleDescription').html(scheduleDTO.description);
        $scheduleTr.find('.schedulePlace').html(scheduleDTO.place);
        $scheduleTr.find('.scheduleStartTimeStr').html(scheduleDTO.startTimeStr);
        $scheduleTr.find('.scheduleTime').html(scheduleDTO.time);
        operationMsg('日程 "' + scheduleDTO.name + '" 更新成功！');
      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  };

  $('.save-schedule-button').on('click', function() {
    $form = $('.save-schedule-form');
    var options = {
      url: BASE_PATH + '/schedule/saveSchedule',
      type: 'POST',
      success: function(data) {
        var scheduleDTO = data;
        operationMsg('新日程: "' + scheduleDTO.name + '"创建成功');
      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  });

  var deleteSchedule = function() {
    var $scheduleTr = $(this).parents('.schedule');
    var scheduleId = $scheduleTr.find('.scheduleId').html();
    $.ajax({
      url: BASE_PATH + '/schedule/deleteSchedule',
      type: 'POST',
      data: {
        'scheduleId': scheduleId
      },
      success: function(data) {
        var scheduleDTO = data;
        $scheduleTr.remove();
        operationMsg('日程 "' + scheduleDTO.name + '" 删除成功！');
      }
    });
  };

  $('.glyphicon-pencil').on('click', initEditSchedule);
  $('.glyphicon-trash').on('click', deleteSchedule);
  $('.update-schedule-button').on('click', updateSchedule);
  $('#datetimepicker3').datetimepicker();
  $('#datetimepicker4').datetimepicker();
});