var BASE_PATH = '';
if (/\d+\.\d+\.\d+\.\d+/.test(location.host)) {
  BASE_PATH = location.protocol + '//' + location.host + location.pathname.substring(0, location.pathname.substring(1).indexOf('/') + 1) + '/PMS';
} else {
  BASE_PATH = location.protocol + '//' + location.host + '/PMS';
}

var operationMsg = function(message) {
  var $header = $('.navbar');
  var $message = $('<span>' + message + '</span>')
  var $alert = $('<div class="alert alert-warning alert-model"></div>');
  $alert.append($('<button type="button" class="close" data-dismiss="alert">&times;</button>')).append($message);
  $('body header:first').append($alert);
}

$(function() {
  $(".nav-handler").mouseover(function() {
    $(this).find("a").css("color", "#03a9f4");
  });

  $(".nav-handler").mouseleave(function() {
    $(this).find("a").css("color", "#383838");
  });

  $('.save-project-button').on('click', function() {
    $form = $('.saveProjectForm');
    var options = {
      success: function(data) {
        if (data.validate != null && data.validate == false) {
          var message = data.exceptionMessage;
          $text = $('.form-group .project-name');
          $text.css('border-color', '#a94442');
          $text.attr('placeholder', message);
        } else {
          var projectId = data.id;
          location.href = BASE_PATH + "/project/showProjectMainPage?projectId=" + projectId
        }
      },
      error: function(data) {
        alert(data)
      },
      url: BASE_PATH + '/project/createProject',
      type: 'POST'
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  });

  $('.add-member').on('click', function() {
    var projectId = $('#projectId').val();
    $.ajax({
      url: BASE_PATH + '/projectUser/validateManager',
      type: 'GET',
      data: {
        'projectId': projectId
      },
      success: function(data) {
        var projectUserDTO = data;
        if (!projectUserDTO.isManager) {
          $('.member-button-div').remove();
          $('.refresh-url').remove();
        }
      }
    });
  });

  $('.update-member-privilege-button').on('click', function() {
    var projectUserId = $(this).parents('.member-mamager-li').find('[name="projectUserId"]').val();
    var data = {};
    if ($(this).html() == '设为管理员') {
      data = {
        'projectUserId': projectUserId,
        'isManager': true
      };
    } else {
      data = {
        'projectUserId': projectUserId,
        'isManager': false
      };
    }
    var $this = $(this);
    $.ajax({
      url: BASE_PATH + '/projectUser/updateMemberPrivilege',
      type: 'POST',
      data: data,
      success: function(data) {
        var projectUserDTO = data;
        if (projectUserDTO.isManager) {
          operationMsg('用户' + projectUserDTO.userName + '已被设置为管理员');
          $('.member-email').html('管理员');
          $this.html('取消管理员');
        } else {
          operationMsg('用户' + projectUserDTO.userName + '已被取消管理员');
          $('.member-email').html('成员');
          $this.html('设为管理员');
        }
      }
    });
  });

  $('.remove-member-button').on('click', function() {
    var projectUserId = $(this).parents('.member-mamager-li').find('[name="projectUserId"]').val();
    var $this = $(this);
    $.ajax({
      url: BASE_PATH + '/projectUser/removeProjectMember',
      type: 'POST',
      data: {
        'projectUserId': projectUserId
      },
      success: function(data) {
        var projectUserDTO = data;
        operationMsg('用户' + projectUserDTO.userName + '已被移除');
        $this.parents('.member-mamager-li').remove();
      }
    });

  });
})