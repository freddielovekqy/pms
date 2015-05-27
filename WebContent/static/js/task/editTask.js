$(function() {
  $.initEditTask = function(objects) {
    var taskDTO = objects.taskDTO;
    var projectUserDTOs = objects.projectUserDTOs;
    var ticketDTOs = objects.ticketDTOs;
    var ticketId = taskDTO.ticketId;

    $('[name="name"]').val(taskDTO.name);
    $('[name="description"]').html(taskDTO.description);
    $('[name="estimate"]').val(taskDTO.estimate);
    $('[name="todo"]').val(taskDTO.todo);
    $('[name="id"]').val(taskDTO.id);

    if (taskDTO.degree == 1) {
      $('.degree1').attr('selected', 'selected');
    } else if (taskDTO.degree == 2) {
      $('.degree2').attr('selected', 'selected');
    } else {
      $('.degree3').attr('selected', 'selected');
    }

    if (taskDTO.state == '创建') {
      $('.state1').attr('selected', 'selected');
    } else if (taskDTO.state == '正在工作') {
      $('.state2').attr('selected', 'selected');
    } else {
      $('.state3').attr('selected', 'selected');
    }

    if (taskDTO.blocked == 1) {
      $('#blocked1').attr('checked', 'checked');
    } else {
      $('#blocked2').attr('checked', 'checked');
    }

    $('[name="owner"]').empty();
    $.each(projectUserDTOs, function(i, projectUserDTO) {
      if (projectUserDTO.userId == taskDTO.ownerId) {
        $user = $('<option selected="selected" value="' + projectUserDTO.userId + '">' + projectUserDTO.userName
            + '</option>');
        $('[name="owner"]').append($user);
      } else {
        $user = $('<option value="' + projectUserDTO.userId + '">' + projectUserDTO.userName + '</option>');
        $('[name="owner"]').append($user);
      }
    });

    $('[name="ticketId"]').empty();
    $.each(ticketDTOs, function(i, ticketDTO) {
      var $ticketDTO;
      if (ticketDTO.id == ticketId) {
        $ticketDTO = $('<option value="' + ticketDTO.id + '" selected="selected">' + ticketDTO.serialStr + ':'
            + ticketDTO.name + '</option>');
      } else {
        $ticketDTO = $('<option value="' + ticketDTO.id + '">' + ticketDTO.serialStr + ':' + ticketDTO.name
            + '</option>');
      }
      $('[name="ticketId"]').append($ticketDTO);
    });
  };

  $.updateTask = function() {
    $form = $('.update-task-form');
    var projectId = $('#projectId').val();
    var options = {
      url: BASE_PATH + '/task/updateTask',
      type: 'POST',
      success: function() {
        location.href = BASE_PATH + "/task/showTaskListPage?projectId=" + projectId
      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  };

  $.initCreateTask = function(objects, ticketId) {
    var projectUserDTOs = objects.projectUserDTOs;
    var ticketDTOs = objects.ticketDTOs;

    $('[name="owner"]').empty();
    $.each(projectUserDTOs, function(i, projectUserDTO) {
      $user = $('<option value="' + projectUserDTO.userId + '">' + projectUserDTO.userName + '</option>');
      $('[name="owner"]').append($user);
    });

    $('[name="ticketId"]').empty();
    $.each(ticketDTOs, function(i, ticketDTO) {
      var $ticketDTO;
      if (ticketDTO.id == ticketId) {
        $ticketDTO = $('<option value="' + ticketDTO.id + '" selected="selected">' + ticketDTO.serialStr + ':'
            + ticketDTO.name + '</option>');
      } else {
        $ticketDTO = $('<option value="' + ticketDTO.id + '">' + ticketDTO.serialStr + ':' + ticketDTO.name
            + '</option>');
      }
      $('[name="ticketId"]').append($ticketDTO);
    });
  };

});