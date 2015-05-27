var editUserModel = function() {
  var $form;

  function editPassword() {
    $form.find(':password').removeAttr('readonly');
    $form.remove("span");
  }

  function updateUser() {
    var options = {
      beforeSubmit: validateFormData,
      success: submitSuccess,
      error: submitError,
      url: BASE_PATH + '/user/updateUser',
      type: 'POST'
    };
    $form.ajaxSubmit(options).submit(function() {
      return false;
    });
  }

  function validateFormData() {
    var $inputDiv = $form.find('.form-group:input');
    if ($inputDiv.attr('type') == 'password' && $inputDiv.val() == '') {
      return false;
    }
  }

  function submitSuccess() {
    var $message = $('<span style="padding-left: 20px;">更新用户信息成功!&nbsp;</span>')
    var $href = $('<a href="' + BASE_PATH + '/project/showProjectList" style="padding-left: 20px;" class="alert-link">返回主页面</a>');
    var $alert = $('<div class="alert alert-warning alert-model"></div>');
    $alert.append($('<button type="button" class="close" data-dismiss="alert">&times;</button>')).append($message).append($href);
    $('body').append($alert);
  }

  function submitError() {
    // TODO 更新user失败
  }

  function bindActions() {
    $form.on('click', 'button', updateUser);
    $form.on('click', 'a', editPassword);
  }

  return {
    init: function() {
      $form = $('.registerForm');
      bindActions();
    }
  };
}();

$(function() {
  editUserModel.init();
});