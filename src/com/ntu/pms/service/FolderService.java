package com.ntu.pms.service;

import java.util.List;

import com.ntu.pms.dto.FolderDTO;
import com.ntu.pms.dto.UserDTO;

public interface FolderService {

    void addFolderWhenCreateProject(int projectId, UserDTO userDTO);

    List<FolderDTO> getDTOsByProject(int projectId);

    FolderDTO addFolder(int projectId, String folderName, UserDTO userDTO);

    FolderDTO removeFolder(int folderId);

    FolderDTO updateFolder(int folderId, String folderName);
}
