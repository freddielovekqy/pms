package com.ntu.pms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.FolderDao;
import com.ntu.pms.dto.FolderDTO;
import com.ntu.pms.model.Folder;

@Repository("folderDao")
public class FolderDaoImpl extends BaseDaoImpl<Folder, Integer> implements FolderDao {

    private static final String SQL_ID_GET_DTO_BY_PROJECT_ID = ".getDTOByProjectId";
    private static final String SQL_ID_GET_DTO_BY_ID = ".getDTOById";
    private static final String SQL_ID_GET_FOLDER_BY_FOLDER_NAME = ".getFolderByFolderName";
    private static final String SQL_ID_UPDATE_FOLDER_FILE_SIZE = ".updateFolderFileSize";

    @Override
    public List<FolderDTO> getDTOByProjectId(int projectId) {
        return getSqlSession().selectList(Folder.class.getName() + SQL_ID_GET_DTO_BY_PROJECT_ID, projectId);
    }

    @Override
    public FolderDTO getDTOById(int id) {
        return getSqlSession().selectOne(Folder.class.getName() + SQL_ID_GET_DTO_BY_ID, id);
    }

    @Override
    public Folder getFolderByFolderName(int projectId, String folderName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.FOLDER_NAME, folderName);
        return getSqlSession().selectOne(Folder.class.getName() + SQL_ID_GET_FOLDER_BY_FOLDER_NAME, map);
    }

    @Override
    public void updateFolderFileSize(int folderId) {
        getSqlSession().update(Folder.class.getName() + SQL_ID_UPDATE_FOLDER_FILE_SIZE, folderId);
    }
}
