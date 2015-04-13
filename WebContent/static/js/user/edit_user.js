var editUserModel = function() {
  var $form;
  
  function editPassword() {
    $form.find(':password').removeAttr('readonly');
    $form.remove("span");
  }
  
  function updateUser() {
    var options = {
      beforeSubmit : validateFormData,
      success : submitSuccess,
      error : submitError,
      url : 'user/updateUser',
      type : 'POST'
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
    // TODO 更新user成功
    alert('success');
  }
  
  function submitError() {
    // TODO 更新user失败
  }
  
  function bindActions() {
    $form.on('click', 'button', updateUser);
    $form.on('click', 'span', editPassword);
  }
  
  return {
    init : function() {
      $form = $('.registerForm');
      bindActions();
    }
  };
}();

$(function() {
  editUserModel.init();
});