package com.ntu.pms.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dao.AttachmentDao;
import com.ntu.pms.dao.FolderDao;
import com.ntu.pms.dto.FolderDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.model.Folder;
import com.ntu.pms.service.FolderService;
import com.ntu.pms.utils.FileUtils;

@Service("folderService")
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderDao folderDao;
    @Autowired
    private AttachmentDao attachmentDao;

    @Override
    public void addFolderWhenCreateProject(int projectId, UserDTO userDTO) {
        Date date = new Date();
        this.createBaseProjectFolder(projectId);
        Folder attachment = new Folder(projectId, userDTO.getId(), date, date);
        attachment.setName(OtherConstants.FOLDER_DOCUMENT);
        folderDao.add(attachment);
        attachment.setName(OtherConstants.FOLDER_MUSIC);
        folderDao.add(attachment);
        attachment.setName(OtherConstants.FOLDER_VEDIO);
        folderDao.add(attachment);
        attachment.setName(OtherConstants.FOLDER_PICTURE);
        folderDao.add(attachment);
        this.createBaseProjectFolder(projectId);
    }

    private void createBaseProjectFolder(int projectId) {
        File file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId);
        file.mkdirs();
        file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId + "\\" + OtherConstants.FOLDER_DOCUMENT);
        file.mkdir();
        file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId + "\\" + OtherConstants.FOLDER_MUSIC);
        file.mkdir();
        file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId + "\\" + OtherConstants.FOLDER_VEDIO);
        file.mkdir();
        file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId + "\\" + OtherConstants.FOLDER_PICTURE);
        file.mkdir();
    }

    @Override
    public List<FolderDTO> getDTOsByProject(int projectId) {
        return folderDao.getDTOByProjectId(projectId);
    }

    @Override
    public FolderDTO addFolder(int projectId, String folderName, UserDTO userDTO) {
        Date date = new Date();
        Folder attachment = new Folder(projectId, userDTO.getId(), date, date);
        attachment.setName(folderName);
        folderDao.add(attachment);
        File file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + projectId + "\\" + folderName);
        file.mkdir();
        FolderDTO attachmentDTO = folderDao.getDTOById(attachment.getId());
        return attachmentDTO;
    }

    @Override
    public FolderDTO removeFolder(int folderId) {
        FolderDTO attachmentDTO = folderDao.getDTOById(folderId);
        folderDao.delete(folderId);
        File file = new File(OtherConstants.BASE_PROJECT_FOLDER + "\\" + attachmentDTO.getProjectId() + "\\"
                + attachmentDTO.getName());
        FileUtils.deleteAllFile(file);
        file.delete();
        attachmentDao.deleteAttachmentByFolder(folderId);
        return attachmentDTO;
    }

    @Override
    public FolderDTO updateFolder(int folderId, String folderName) {
        Folder attachment = folderDao.getById(folderId);
        attachment.setName(folderName);
        attachment.setUpdateTime(new Date());
        folderDao.update(attachment);
        FolderDTO attachmentDTO = folderDao.getDTOById(folderId);
        return attachmentDTO;
    }
}
