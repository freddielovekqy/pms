$(function() {
  $('#showMoreMemberInfo').on('click', function() {
    var $tag = $(this).find('span');
    if ($tag.hasClass('glyphicon-chevron-left')) {
      $tag.removeClass('glyphicon-chevron-left').addClass('glyphicon-chevron-right');
      $('.member-bar').css('right', '0px');
    } else {
      $tag.removeClass('glyphicon-chevron-right').addClass('glyphicon-chevron-left');
      $('.member-bar').css('right', '-200px');
    }
  });

  $('.copy-sign').on('click', function() {
    $('#add-member-url-input').css('display', 'inline');
    $('.glyphicon-remove-sign').css('display', 'inline');
    $("#add-member-url").css('display', 'none');
  });

  $('.glyphicon-remove-sign').on('click', function() {
    $('#add-member-url-input').css('display', 'none');
    $('.glyphicon-remove-sign').css('display', 'none');
    $("#add-member-url").css('display', 'inline');
  });

  $('.refresh-url').on('click', function() {
    var projectId = $('#projectId').val();
    $.ajax({
      type: 'POST',
      data: {
        'projectId': projectId
      },
      url: BASE_PATH + '/project/updateProjectUrl',
      success: function(data) {
        var projectDTO = data;
        $('#add-member-url').val(projectDTO.addMemberUrl);
        $('.add-member-url').val(projectDTO.addMemberUrl);
        $('#add-member-url-input').val(projectDTO.addMemberUrl);
      }
    });
  });
});