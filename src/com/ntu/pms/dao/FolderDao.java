package com.ntu.pms.dao;

import java.util.List;

import com.ntu.pms.dto.FolderDTO;
import com.ntu.pms.model.Folder;

public interface FolderDao extends BaseDao<Folder, Integer> {

    List<FolderDTO> getDTOByProjectId(int projectId);

    FolderDTO getDTOById(int id);

    Folder getFolderByFolderName(int projectId, String folderName);

    void updateFolderFileSize(int folderId);
}
