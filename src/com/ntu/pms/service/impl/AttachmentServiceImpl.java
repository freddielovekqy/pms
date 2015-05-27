package com.ntu.pms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dao.AttachmentDao;
import com.ntu.pms.dao.FolderDao;
import com.ntu.pms.dto.AttachmentDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.model.Attachment;
import com.ntu.pms.model.Folder;
import com.ntu.pms.service.AttachmentService;

@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private FolderDao folderDao;
    @Autowired
    private AttachmentDao attachmentDao;

    @Override
    public AttachmentDTO uploadAttachment(int projectId, String folderName, MultipartFile file, UserDTO userDTO)
            throws IOException {
        Folder folder = folderDao.getFolderByFolderName(projectId, folderName);
        String fileFolder = OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId;
        if (!OtherConstants.JSNull.equals(folderName) && StringUtils.isNotEmpty(folderName)) {
            fileFolder = fileFolder + "\\" + folderName;
        }
        String fileName = file.getOriginalFilename();
        File targetFile = new File(fileFolder, fileName);
        file.transferTo(targetFile);
        targetFile.createNewFile();
        Attachment attachment = new Attachment(fileName, targetFile.length(), userDTO.getId(), new Date(),
                folder.getId());
        attachmentDao.add(attachment);
        folderDao.updateFolderFileSize(folder.getId());
        AttachmentDTO attachmentDTO = attachmentDao.getDTOById(attachment.getId());
        return attachmentDTO;
    }

    @Override
    public List<AttachmentDTO> findAttachmentDTOByFolder(int projectId, String folderName) {
        Folder folder = folderDao.getFolderByFolderName(projectId, folderName);
        return attachmentDao.findAttachmentDTOByFolder(folder.getId());
    }

    @Override
    public AttachmentDTO deleteAttachment(int projectId, int attachmentId) {
        AttachmentDTO attachmentDTO = attachmentDao.getDTOById(attachmentId);
        attachmentDao.delete(attachmentId);
        String filePath = OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId + "\\" + attachmentDTO.getFolderName()
                + "\\" + attachmentDTO.getName();
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        return attachmentDTO;
    }

    @Override
    public File downloadAttachment(int projectId, int attachmentId) {
        AttachmentDTO attachmentDTO = attachmentDao.getDTOById(attachmentId);
        String filePath = OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId + "\\" + attachmentDTO.getFolderName()
                + "\\" + attachmentDTO.getName();
        File file = new File(filePath);
        return file;
    }

    @Override
    public AttachmentDTO getDTOById(int attachmentId) throws BussinessException {
        AttachmentDTO attachmentDTO = attachmentDao.getDTOById(attachmentId);
        if (attachmentDTO == null || !attachmentDTO.getIsActive()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(EntityConstants.OBJECT_TYPE, EntityConstants.ATTACHMENT);
            map.put(EntityConstants.OBJECT_ID, attachmentId);
            throw new BussinessException("文件不存在.", map);
        }
        return attachmentDTO;
    }
}
