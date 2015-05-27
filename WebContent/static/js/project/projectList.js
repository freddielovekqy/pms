$(function() {
  $('.project').on('click', function() {
    var projectId = $(this).find('.projectId').val();
    location.href = BASE_PATH + "/project/showProjectMainPage?projectId=" + projectId;
  })
});