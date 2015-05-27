$(function() {
  $('.upload-file').click(function() {
    $('[name="file"]').click();
  });

  var uploadAttachment = function() {
    var baseFolderName = $('.baseFolderName').html();
    var projectId = $('#projectId').val();
    var data = {
      'projectId': projectId,
      'baseFolderName': baseFolderName
    };
    operationMsg('文件上传成功！');
    $.ajaxFileUpload({
      url: BASE_PATH + '/attachment/uploadAttachment',
      type: 'POST',
      data: data,
      fileElementId: 'uploadBtn',
      secureuri: false,
      dataType: 'json',
      success: function(data) {
        operationMsg('文件上传成功！');
      }
    });
  }

  document.getElementById("uploadBtn").onchange = function() {
    document.getElementById("uploadFile").innerHTML = this.value;
    $('.fileUpload').css('display', 'none');
    $uploadButton = $('<button type="button" class="btn btn-primary uploadButton" style="margin-left: 15px;"><span class="glyphicon glyphicon-cloud-upload"></span>上传</button>');
    $('#uploadFile').after($uploadButton);
    $('.library-header-handler').css('margin-top', '-3px');
    $('.uploadButton').on('click', uploadAttachment);
  };

  $('.library-info-name').on(
      'click',
      function() {
        var folderName = $(this).find('.folderName').html();
        var projectId = $('#projectId').val();
        $('.library-title').html(
            '<a href="../attachment/showFolderList?projectId=' + projectId + '">文件库</a> / <span class="baseFolderName">' + folderName + "</span>");
        $('.library-info').remove();

        $.ajax({
          url: BASE_PATH + '/attachment/findAttachmentDTOByFolder',
          type: 'GET',
          data: {
            'projectId': projectId,
            'folderName': folderName
          },
          success: function(data) {
            var attachmentDTOs = data;
            $.each(attachmentDTOs, function(i, attachmentDTO) {
              var $attachmentDiv = $('<div class="library-info library-handler-set"></div>');
              var $infoName = $('<a class="library-info-name download-attachment"></a>');
              $infoName.append($('<span class="glyphicon glyphicon-file icon-big-size"></span>')).append(
                  $('<span class="attachmentName" style="margin-left: 13px;">' + attachmentDTO.name + '</span>'));
              $attachmentDiv.append(
                  $('<input type="hidden" class="attachmentId" id="attachment' + attachmentDTO.id + '" value="' + attachmentDTO.id + '">')).append(
                  $infoName).append($('<span class="library-info-size">' + attachmentDTO.size + '</span>')).append(
                  $('<span class="library-info-author">' + attachmentDTO.creatorName + '</span>')).append(
                  $('<span class="library-info-update">' + attachmentDTO.createTime + '</span>')).append(
                  $('<a href="" class="glyphicon glyphicon-trash remove-folder-icon delete-attachment" style="margin-left: 80px;"></a>'));
              $('.folders').append($attachmentDiv);
              $('.delete-attachment').on('click', deleteAttachment);
              $('.download-attachment').on('click', downloadAttachment);
            });
          }
        });
      });

  $('.new-folder-button').on(
      'click',
      function() {
        var folderName = $('#newFolderName').val();
        var projectId = $('#projectId').val();

        $.ajax({
          url: BASE_PATH + '/attachment/addFolder',
          data: {
            'projectId': projectId,
            'folderName': folderName
          },
          type: 'POST',
          success: function(data) {
            var folderDTO = data;
            var $folderDiv = $('<div class="library-info library-handler-set"></div>');
            var $infoName = $('<a class="library-info-name"></a>');
            $infoName.append($('<span class="glyphicon glyphicon-folder-open icon-big-size"></span>')).append(
                $('<span class="folderName" style="margin-left: 13px;">' + folderDTO.name + '</span>'));
            $folderDiv.append($('<input type="hidden" class="folderId" id="folder' + folderDTO.id + '" value="' + folderDTO.id + '">')).append(
                $infoName).append($('<span class="library-info-size">' + folderDTO.fileSize + '</span>')).append(
                $('<span class="library-info-author">' + folderDTO.creatorName + '</span>')).append(
                $('<span class="library-info-update">' + folderDTO.createTime + '</span>')).append(
                $('<a style="margin-left: 140px;" class="glyphicon glyphicon-pencil edit-folder-icon"></a>')).append(
                $('<a href="" class="glyphicon glyphicon-trash remove-folder-icon"></a>'));
            $('.folders').append($folderDiv);
            $('.remove-folder-icon').on('click', removeFolder);
            $('.edit-folder-icon').on('click', initEditFolder);
          }
        });
      });

  $('.update-folder-name-button').on('click', function() {
    var newFolderName = $('#editFolderName').val();
    var folderId = $('#editFolderId').val();

    $.ajax({
      url: BASE_PATH + '/attachment/updateFolder',
      type: 'POST',
      data: {
        'folderId': folderId,
        'folderName': newFolderName
      },
      success: function(data) {
        operationMsg('更新文件夹名称成功！');
        var folderDTO = data;
        var folderIdStr = 'folder' + folderDTO.id;
        var $infoDiv = $('#' + folderIdStr).parent('.library-info');
        $infoDiv.find('.folderName').html(folderDTO.name);
      }
    });
  });

  var downloadAttachment = function() {
    var attachmentId = $(this).parent('.library-info').find('.attachmentId').val();
    var projectId = $('#projectId').val();
    location.href = BASE_PATH + '/attachment/downloadAttachment?projectId=' + projectId + '&attachmentId=' + attachmentId;
  }

  var deleteAttachment = function() {
    var result = confirm('确认删除文件？');
    if (!result) {
      return;
    }
    var attachmentId = $(this).parent('.library-info').find('.attachmentId').val();
    var projectId = $('#projectId').val();
    $.ajax({
      url: BASE_PATH + '/attachment/deleteAttachment',
      type: 'POST',
      data: {
        'attachmentId': attachmentId,
        'projectId': projectId
      },
      success: function(data) {
        var attachmentDTO = data;
        operationMsg('文件"' + attachmentDTO.name + '"删除成功');
      }
    });
  }

  var removeFolder = function() {
    var result = confirm('将删除文件夹下所有文件，确认删除？');
    if (!result) {
      return;
    }
    var folderId = $(this).parent('.library-info').find('.folderId').val();
    $.ajax({
      url: BASE_PATH + '/attachment/removeFolder?folderId=' + folderId,
      type: 'POST',
      success: function(data) {
        var folderDTO = data;
        var folderIdStr = 'folder' + folderDTO.id;
        $('#' + folderIdStr).parent('.library-info').remove();
      }
    });
  }

  var initEditFolder = function() {
    var $parentDiv = $(this).parent('.library-info');
    var folderName = $parentDiv.find('.folderName').html();
    var folderId = $parentDiv.find('.folderId').val();
    $('#editFolderName').val(folderName);
    $('#editFolderId').val(folderId);
  }

  var editFolder = function() {

  };

  $('.remove-folder-icon').on('click', removeFolder);
  $('.edit-folder-icon').on('click', initEditFolder);
});