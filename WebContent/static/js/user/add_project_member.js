$(function() {
  $('#joinInProject').on('click', function() {
    var projectId = $('#projectId').val();
    $.ajax({
      url: BASE_PATH + '/projectUser/joinInProject',
      type: 'POST',
      data: {
        'projectId': projectId
      },
      success: function(data) {
        location.href = BASE_PATH + "/project/showProjectMainPage?projectId=" + projectId;
      }
    });
  });
});