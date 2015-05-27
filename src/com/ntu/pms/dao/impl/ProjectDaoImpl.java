package com.ntu.pms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.ProjectDao;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.model.Project;

@Repository("projectDao")
public class ProjectDaoImpl extends BaseDaoImpl<Project, Integer> implements ProjectDao {

    private static final String SQL_ID_FIND_PROJECT_DTO_BY_USER = ".findProjectDTOByUser";
    private static final String SQL_ID_FIND_FILED_PROJECT_DTO_BY_USER = ".findFiledProjectDTOByUser";
    private static final String SQL_ID_UPDATE_PROJECT_URL = ".updateProjectUrl";
    private static final String SQL_ID_GET_PROJECT_BY_URL = ".getProjectByUrl";
    private static final String SQL_ID_GET_DTO_BY_ID = ".getDTOById";
    private static final String SQL_ID_FIND_ALL_PROJECT = ".findAllProject";

    @Override
    public List<ProjectDTO> findProjectDTOByUser(int userId) {
        return getSqlSession().selectList(Project.class.getName() + SQL_ID_FIND_PROJECT_DTO_BY_USER, userId);
    }

    @Override
    public List<ProjectDTO> findFiledProjectDTOByUser(int userId) {
        return getSqlSession().selectList(Project.class.getName() + SQL_ID_FIND_FILED_PROJECT_DTO_BY_USER, userId);
    }

    @Override
    public ProjectDTO getDTOById(int projectId) {
        return getSqlSession().selectOne(Project.class.getName() + SQL_ID_GET_DTO_BY_ID, projectId);
    }

    @Override
    public void updateProjectUrl(int projectId, String newUrl) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put("addMemberUrl", newUrl);
        getSqlSession().update(Project.class.getName() + SQL_ID_UPDATE_PROJECT_URL, map);
    }

    @Override
    public ProjectDTO getProjectByUrl(String url) {
        return getSqlSession().selectOne(Project.class.getName() + SQL_ID_GET_PROJECT_BY_URL, url);
    }

    @Override
    public List<Project> findAllProject() {
        return getSqlSession().selectList(Project.class.getName() + SQL_ID_FIND_ALL_PROJECT);
    }

}
