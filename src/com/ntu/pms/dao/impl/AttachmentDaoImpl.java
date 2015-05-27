package com.ntu.pms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ntu.pms.dao.AttachmentDao;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dto.AttachmentDTO;
import com.ntu.pms.model.Attachment;

@Repository("attachmentDao")
public class AttachmentDaoImpl extends BaseDaoImpl<Attachment, Integer> implements AttachmentDao {

    private static final String SQL_ID_GET_DTO_BY_ID = ".getDTOById";
    private static final String SQL_ID_FIND_ATTACHMENT_DTO_BY_FOLDER = ".findAttachmentDTOByFolder";
    private static final String SQL_ID_DELETE_ATTACHMENT_BY_FOLDER = ".deleteAttachmentByFolder";

    @Override
    public AttachmentDTO getDTOById(int attachmentId) {
        return getSqlSession().selectOne(Attachment.class.getName() + SQL_ID_GET_DTO_BY_ID, attachmentId);
    }

    @Override
    public List<AttachmentDTO> findAttachmentDTOByFolder(int folderId) {
        return getSqlSession().selectList(Attachment.class.getName() + SQL_ID_FIND_ATTACHMENT_DTO_BY_FOLDER, folderId);
    }

    @Override
    public void deleteAttachmentByFolder(int folderId) {
        getSqlSession().update(Attachment.class.getName() + SQL_ID_DELETE_ATTACHMENT_BY_FOLDER, folderId);
    }

}
