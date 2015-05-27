$(function() {
  $.initEditTicket = function(objects) {
    var ticketDTO = objects.ticketDTO;
    var projectUserDTOs = objects.projectUserDTOs;
    var sprintDTOs = objects.sprintDTOs;

    $('[name="id"]').val(ticketDTO.id);
    $('[name="name"]').val(ticketDTO.name);
    $('[name="description"]').html(ticketDTO.description);
    $('[name="planEst"]').val(ticketDTO.planEst);

    if (ticketDTO.state == '创建') {
      $('.state1').attr('selected', 'selected');
    } else if (ticketDTO.state == '正在工作') {
      $('.state2').attr('selected', 'selected');
    } else {
      $('.state3').attr('selected', 'selected');
    }

    $('[name="ownerId"]').empty();
    $.each(projectUserDTOs, function(i, projectUserDTO) {
      if (projectUserDTO.userId == ticketDTO.ownerId) {
        $user = $('<option selected="selected" value="' + projectUserDTO.userId + '">' + projectUserDTO.userName
            + '</option>');
        $('[name="ownerId"]').append($user);
      } else {
        $user = $('<option value="' + projectUserDTO.userId + '">' + projectUserDTO.userName + '</option>');
        $('[name="ownerId"]').append($user);
      }
    });

    $('[name="sprintId"]').empty();
    $.each(sprintDTOs, function(i, sprintDTO) {
      var $sprintDTO;
      if (sprintDTO.id == ticketDTO.sprintId) {
        $sprintDTO = $('<option value="' + sprintDTO.id + '" selected="selected">' + sprintDTO.name + '</option>');
      } else {
        $sprintDTO = $('<option value="' + sprintDTO.id + '">' + sprintDTO.name + '</option>');
      }
      $('[name="sprintId"]').append($sprintDTO);
    });
  };

  $.updateTicket = function() {
    $form = $('.update-ticket-form');
    var projectId = $('#projectId').val();
    var options = {
      url: BASE_PATH + '/ticket/updateTicket',
      type: 'POST',
      success: function() {
        location.href = BASE_PATH + "/task/showTaskListPage?projectId=" + projectId
      }
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  };

  $.initCreateTicket = function(objects, currentSprintId) {
    var projectUserDTOs = objects.projectUserDTOs;
    var sprintDTOs = objects.sprintDTOs;

    $('[name="ownerId"]').empty();
    $.each(projectUserDTOs, function(i, projectUserDTO) {
      $user = $('<option value="' + projectUserDTO.userId + '">' + projectUserDTO.userName + '</option>');
      $('[name="ownerId"]').append($user);
    });

    $('[name="sprintId"]').empty();
    $.each(sprintDTOs, function(i, sprintDTO) {
      var $sprintDTO;
      if (sprintDTO.id == currentSprintId) {
        $sprintDTO = $('<option value="' + sprintDTO.id + '" selected="selected">' + sprintDTO.name + '</option>');
      } else {
        $sprintDTO = $('<option value="' + sprintDTO.id + '">' + sprintDTO.name + '</option>');
      }
      $('[name="sprintId"]').append($sprintDTO);
    });
  };
});