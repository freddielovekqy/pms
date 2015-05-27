$(function() {
  var showTask = function() {
    var $this = $(this);
    if ($this.hasClass('glyphicon-plus')) {
      var ticketId = $(this).next().val();
      var projectId = $('#projectId').val();

      $
          .ajax({
            type: 'GET',
            data: {
              'projectId': projectId,
              'ticketId': ticketId
            },
            url: BASE_PATH + '/task/showTaskByTicket',
            success: function(data) {
              $oldTr = $this.parents('tr');
              var taskClassName = $oldTr.attr('class') + '-task';

              var taskDTOs = data;
              $
                  .each(
                      taskDTOs,
                      function(i, taskDTO) {
                        var $tr = $('<tr class="' + taskClassName + '"></tr>');
                        $tr.append(
                            $('<td class="no-content"><input type="hidden" class="task" value="' + taskDTO.id
                                + '"></td>')).append($('<td>' + taskDTO.serialNumber + '</td>')).append(
                            $('<td>TA' + taskDTO.serialNumber + '：' + taskDTO.name + '</td>')).append(
                            $('<td>' + taskDTO.state + '</td>')).append($('<td></td>')).append(
                            $('<td>' + taskDTO.estimate + '</td>'));
                        if (taskDTO.blocked) {
                          $tr.append($('<td>' + taskDTO.todo
                              + '<img src="http://localhost:8080/PMS/data/lock.png" class="lock"></td>'));
                        } else {
                          $tr.append($('<td>' + taskDTO.todo + '</td>'));
                        }
                        $tr.append($('<td>' + taskDTO.ownerName + '</td>'));
                        $operation = $('<td></td>');
                        $operation
                            .append(
                                $('<a><span class="glyphicon glyphicon-pencil"  data-toggle="modal" data-target="#editTask"></span></a>&nbsp;'))
                            .append($('<a class="operation-icon"><span class="glyphicon glyphicon-trash"></span> </a>'));
                        $tr.append($operation);
                        $oldTr.after($tr);
                        $this.removeClass('glyphicon-plus');
                        $this.addClass('glyphicon-minus');
                        $('.glyphicon-trash').on('click', remove);
                        $('.glyphicon-pencil').on('click', editObject);
                      });
            }
          });
    } else if ($this.hasClass('glyphicon-minus')) {
      $oldTr = $this.parents('tr');
      var taskClassName = $oldTr.attr('class') + '-task';
      $('.' + taskClassName).remove();

      $this.removeClass('glyphicon-minus');
      $this.addClass('glyphicon-plus');
    }
  };

  var showTicket = function(ticketDTOs) {
    var $thead = $('thead');
    $
        .each(
            ticketDTOs,
            function(i, ticketDTO) {
              $tr = $('<tr class="' + ticketDTO.serialStr + '-data"></tr>');
              if (ticketDTO.taskCount > 0) {
                $tr.append($('<td><span class="glyphicon glyphicon-plus show-more-task" title="展示任务"></span>'
                    + '<input type="hidden" class="ticket" value="' + ticketDTO.id + '"> </td>'));
              } else {
                $tr.append($('<td><input type="hidden" class="ticket" value="' + ticketDTO.id + '"> </td> </td>'));
              }
              $tr.append($('<td>' + ticketDTO.serialNumber + '</td>')).append(
                  $('<td title="' + ticketDTO.serialStr + '：' + ticketDTO.name + '">' + ticketDTO.serialStr + '：'
                      + ticketDTO.name + '</td>')).append($('<td>' + ticketDTO.state + '</td>')).append(
                  $('<td>' + ticketDTO.planEst + '</td>')).append($('<td>' + ticketDTO.taskEst + '</td>'));
              if (ticketDTO.blocked) {
                $tr.append($('<td>' + ticketDTO.todo
                    + '<img src="http://localhost:8080/PMS/data/lock.png" class="lock">' + '</td>'));
              } else {
                $tr.append($('<td>' + ticketDTO.todo + '</td>'));
              }
              $tr
                  .append($('<td>' + ticketDTO.ownerName + '</td>'))
                  .append(
                      $('<td><a><span class="glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editTicket"></span></a>'
                          + '<a class="operation-icon"><span class="glyphicon glyphicon-trash"></span> </a>'
                          + '<a class="operation-icon"><span title="添加任务" class="glyphicon glyphicon-plus-sign" data-toggle="modal" data-target="#newTask"></span></a></td>'));
              $thead.after($tr);
            });
    $('.show-more-task').on('click', showTask);
    $('.glyphicon-pencil').on('click', editObject);
    $('.glyphicon-plus-sign').on('click', initCreateTask);
  };

  var remove = function() {
    $this = $(this);
    var $input = $this.parents('tr').find('input');
    var objectType = $input.attr('class');
    var objectId = $input.val();
    var sprintId = $('.sprint-list').val();
    var projectId = $('#projectId').val();

    if (objectType == 'ticket') {
      var isCascade = confirm("是否删除订单下的所有任务?");
      $.ajax({
        type: 'POST',
        data: {
          'projectId': projectId,
          'sprintId': sprintId,
          'ticketId': objectId,
          'isCascade': isCascade
        },
        url: BASE_PATH + '/ticket/deleteTicket',
        success: function(data) {
          var ticketDTO = data;
          operationMsg(ticketDTO.type + ticketDTO.serialNumber + ': ' + ticketDTO.name + ' 删除成功');
          $('.' + ticketDTO.serialStr + '-data').remove();
          $('.' + ticketDTO.serialStr + '-data-task').remove();
        },
        error: function(data) {
          alert('123');
        }
      });
    } else if (objectType == 'task') {
      var result = confirm("确认删除？");
      if (result) {
        $.ajax({
          type: 'POST',
          url: BASE_PATH + '/task/deleteTask',
          data: {
            'taskId': objectId
          },
          success: function(data) {
            var taskDTO = data;
            operationMsg('TA' + taskDTO.serialNumber + ': ' + taskDTO.name + ' 删除成功');
            $this.parents('tr').remove();
          }
        });
      }
    }
  };

  var editObject = function() {
    var $input = $(this).parents('tr').find('input');
    var objectType = $input.attr('class');
    var objectId = $input.val();
    var sprintId = $('.sprint-list').val();
    var projectId = $('#projectId').val();

    if (objectType == 'task') {
      $.ajax({
        type: 'GET',
        data: {
          'projectId': projectId,
          'sprintId': sprintId,
          'taskId': objectId
        },
        url: BASE_PATH + '/task/initEditTask',
        success: function(data) {
          $.initEditTask(data);
        }
      });
    } else if (objectType == 'ticket') {
      $.ajax({
        type: 'GET',
        data: {
          'projectId': projectId,
          'ticketId': objectId
        },
        url: BASE_PATH + '/ticket/initEditTicket',
        success: function(data) {
          $.initEditTicket(data);
        }
      });
    }
  }

  var initCreateTask = function() {
    var projectId = $('#projectId').val();
    var sprintId = $('.sprint-list').val();
    var ticketId = $(this).parents('tr').find('input').val();
    $.ajax({
      type: 'GET',
      data: {
        'projectId': projectId,
        'sprintId': sprintId
      },
      url: BASE_PATH + '/task/initCreateTask',
      success: function(data) {
        $.initCreateTask(data, ticketId);
      }
    });
  };

  var getTaskDTOs = function(projectId, ticketId) {
    $.ajax({
      url: BASE_PATH + '/task/showTaskByTicket',
      type: 'GET',
      data: {
        'projectId': projectId,
        'ticketId': ticketId
      },
      success: function(data) {
        var taskDTOs = data;
        return taskDTOs;
      }
    });
  }

  var saveTask = function() {
    var projectId = $('#projectId').val();
    var ticketId = $('[name="ticketId"]').val();
    var taskDTOs;
    $.ajax({
      url: BASE_PATH + '/task/showTaskByTicket',
      type: 'GET',
      data: {
        'projectId': projectId,
        'ticketId': ticketId
      },
      async: false,
      success: function(data) {
        taskDTOs = data;
      }
    });

    $form = $('.save-task-form');
    var options = {
      url: BASE_PATH + '/task/saveTask',
      type: 'POST',
      success: function(data) {
        var taskDTO = data;
        operationMsg('TA' + taskDTO.serialNumber + ': ' + taskDTO.name + ' 创建成功');

        taskDTOs.push(taskDTO);
        var className = 'US' + ticketId + '-data';
        var $ticketTr = $('.' + className);
        var taskClassName = $ticketTr.attr('class') + '-task';
        $('.' + taskClassName).remove();

        $
            .each(
                taskDTOs,
                function(i, taskDTO) {
                  var $tr = $('<tr class="' + taskClassName + '"></tr>');
                  $tr.append(
                      $('<td class="no-content"><input type="hidden" class="task" value="' + taskDTO.id + '"></td>'))
                      .append($('<td>' + taskDTO.serialNumber + '</td>')).append(
                          $('<td>TA' + taskDTO.serialNumber + '：' + taskDTO.name + '</td>')).append(
                          $('<td>' + taskDTO.state + '</td>')).append($('<td></td>')).append(
                          $('<td>' + taskDTO.estimate + '</td>'));
                  if (taskDTO.blocked) {
                    $tr.append($('<td>' + taskDTO.todo
                        + '<img src="http://localhost:8080/PMS/data/lock.png" class="lock"></td>'));
                  } else {
                    $tr.append($('<td>' + taskDTO.todo + '</td>'));
                  }
                  $tr.append($('<td>' + taskDTO.ownerName + '</td>'));
                  $operation = $('<td></td>');
                  $operation
                      .append(
                          $('<a><span class="glyphicon glyphicon-pencil"  data-toggle="modal" data-target="#editTask"></span></a>&nbsp;'))
                      .append($('<a class="operation-icon"><span class="glyphicon glyphicon-trash"></span> </a>'));
                  $tr.append($operation);
                  $ticketTr.after($tr);

                  $('.glyphicon-trash').on('click', remove);
                  $('.glyphicon-pencil').on('click', editObject);
                });
        var $span = $ticketTr.find('.show-more-task');
        if ($span != null) {
          if ($span.hasClass('glyphicon-plus')) {
            $span.removeClass('glyphicon-plus');
          }
          $span.addClass('glyphicon-minus');
        } else {
          $span = $('<span class="glyphicon glyphicon-minus show-more-task" title="展示任务"> </span>')
          $ticketTr.find('ticket').before($span);
        }

      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  };

  $('.sprint-list').on('change', function() {
    var sprintId = $(this).val();
    var projectId = $('#projectId').val();
    $.ajax({
      type: 'GET',
      data: {
        'sprintId': sprintId,
        'projectId': projectId,
        'pageIndex': 1
      },
      url: BASE_PATH + '/ticket/showTicketListBySprint',
      success: function(data) {
        $('tr:gt(0)').remove();
        var ticketDTOs = data.list;
        showTicket(ticketDTOs);
      }
    });
  });

  $('.pagination').on('click', function() {
    var sprintId = $('.sprint-list').val();
    var projectId = $('#projectId').val();
    var pageIndex = $(this).find('.sr-only').html();

    $.ajax({
      type: 'GET',
      data: {
        'sprintId': sprintId,
        'projectId': projectId,
        'pageIndex': pageIndex
      },
      url: BASE_PATH + '/ticket/showTicketListBySprint',
      success: function(data) {
        $('tr:gt(0)').remove();
        var ticketDTOs = data.list;
        showTicket(ticketDTOs);
        $('.pagination.page li').removeClass('active');
        $('.pageCount' + pageIndex).parent('li').addClass('active');
      }
    });
    return false;
  });

  $('.show-more-task').on('click', showTask);
  $('.glyphicon-trash').on('click', remove);
  $('.glyphicon-pencil').on('click', editObject);
  $('.glyphicon-plus-sign').on('click', initCreateTask);
  $('.update-task-button').on('click', $.updateTask);
  $('.save-task-button').on('click', saveTask);
  $('.update-ticket-button').on('click', $.updateTicket);
});