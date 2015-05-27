package com.ntu.pms.dao;

import java.util.List;

import com.ntu.pms.dto.AttachmentDTO;
import com.ntu.pms.model.Attachment;

public interface AttachmentDao extends BaseDao<Attachment, Integer> {

    AttachmentDTO getDTOById(int attachmentId);

    List<AttachmentDTO> findAttachmentDTOByFolder(int folderId);

    void deleteAttachmentByFolder(int folderId);
}
