$(function() {
  var ctx = $('#taskChart').get(0).getContext('2d');
  var labelStr = $('.taskChartLabels').val();
  labelStr = labelStr.substring(1, labelStr.length - 1);
  var dataStr = $('.taskChartData').val();
  dataStr = dataStr.substring(1, dataStr.length - 1);
  var dataArray = dataStr.split(', ');
  var data = new Array(7);
  for (var i = 0; i < dataArray.length; i++) {
    data[i] = dataArray[i];
  }
  var data = {
    labels: labelStr.split(','),
    datasets: [
      {
        fillColor: "rgba(220,220,220,0.5)",
        strokeColor: "rgba(220,220,220,1)",
        pointColor: "rgba(220,220,220,1)",
        pointStrokeColor: "#fff",
        data: data
      }
    ]
  };
  var myNewChart = new Chart(ctx).Bar(data);

  $('.update-project').on('click', function() {
    $form = $('.updateProjectForm');
    var options = {
      success: function(data) {
        if (data.validate != null && data.validate == false) {
          var message = data.exceptionMessage;
          $text = $('.form-group .project-name');
          $text.css('border-color', '#a94442');
          $text.attr('placeholder', message);
        } else {
          location.reload();
        }
      },
      error: function(data) {
        alert(data)
      },
      url: BASE_PATH + '/project/updateProject',
      type: 'POST'
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  });

  $('.statistic-today-tasks').on('mouseover', function() {
    if ($('.statistic-today-tasks button').length != 0) {
      $('.statistic-today-tasks button').css('display', 'inline');
      $('.statistic-count.left-time').css('display', 'none');
    }
  });

  $('.statistic-today-tasks').mouseleave(function() {
    if ($('.statistic-today-tasks button').length != 0) {
      $('.statistic-today-tasks button').css('display', 'none');
      $('.statistic-count.left-time').css('display', 'inline');
    }
  });

  $('.statistic-today-tasks button').on('click', function() {
    var sprintId = $('.currentSprintId').val();
    $.ajax({
      url: BASE_PATH + '/sprint/updateSprintEndDate',
      data: {
        'sprintId': sprintId
      },
      type: 'POST',
      success: function(data) {
        $('.statistic-count.left-time').html('1天');
      }
    });
  });

  $('.new-task').on('click', function() {
    var projectId = $('#projectId').val();
    var sprintId = $('.currentSprintId').val();
    $.ajax({
      type: 'GET',
      data: {
        'projectId': projectId,
        'sprintId': sprintId
      },
      url: BASE_PATH + '/task/initCreateTask',
      success: function(data) {
        $.initCreateTask(data, null);
      }
    });
  });

  $('.new-ticket').on('click', function() {
    var projectId = $('#projectId').val();
    var sprintId = $('.currentSprintId').val();

    $.ajax({
      type: 'GET',
      url: BASE_PATH + '/ticket/initCreateTicket',
      data: {
        'projectId': projectId
      },
      success: function(data) {
        $.initCreateTicket(data, sprintId);
      }
    });
  });

  $('.save-task-button').on('click', function() {
    $form = $('.save-task-form');
    var projectId = $('#projectId').val();
    var options = {
      url: BASE_PATH + '/task/saveTask',
      type: 'POST',
      success: function(data) {
        var taskDTO = data;
        operationMsg('TA' + taskDTO.serialNumber + ': ' + taskDTO.name + '创建成功');
      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  });

  $('.save-ticket-button').on('click', function() {
    $form = $('.save-ticket-form');
    var projectId = $('#projectId').val();
    var options = {
      url: BASE_PATH + '/ticket/saveTicket',
      type: 'POST',
      success: function(data) {
        var ticketDTO = data;
        operationMsg(ticketDTO.type + ticketDTO.serialNumber + ': ' + ticketDTO.name + '创建成功');
      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  });

  $('.save-sprint-button').on('click', function() {
    $form = $('.save-sprint-form');
    var options = {
      url: BASE_PATH + '/sprint/saveSprint',
      type: 'POST',
      success: function(data) {
        var sprintDTO = data;
        operationMsg('SP' + sprintDTO.serialNumber + ': ' + sprintDTO.name + '创建成功');
      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  });

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

  $('#datetimepicker1').datetimepicker();
  $('#datetimepicker2').datetimepicker();
  $('#datetimepicker3').datetimepicker();
  $('#datetimepicker4').datetimepicker();
});