package com.ntu.pms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.ProjectUserDao;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.model.ProjectUser;

@Repository("projectUserDao")
public class ProjectUserDaoImpl extends BaseDaoImpl<ProjectUser, Integer> implements ProjectUserDao {

    private static final String SQL_ID_GET_PROJECT_USER_DTOS_BY_PROJECT_ID = ".getProjectUserDTOsByProjectId";
    private static final String SQL_ID_GET_DTO_BY_ID = ".getDTOById";
    private static final String SQL_ID_UPDATE_MEMBER_PRIVILEGE = ".updateMemberPrivilege";
    private static final String SQL_ID_GET_PROJECT_USER_DTO = ".getProjectUserDTO";
    private static final String SQL_ID_FIND_ALL_PROJECT_USER = ".findAllProjectUser";
    private static final String SQL_ID_FIND_PROJECT_USERS_BY_PROJECT = ".findProjectUsersByProject";

    @Override
    public List<ProjectUserDTO> getProjectUserDTOsByProjectId(int projectId) {
        return getSqlSession().selectList(ProjectUser.class.getName() + SQL_ID_GET_PROJECT_USER_DTOS_BY_PROJECT_ID,
                projectId);
    }

    @Override
    public ProjectUserDTO getDTOById(int id) {
        return getSqlSession().selectOne(ProjectUser.class.getName() + SQL_ID_GET_DTO_BY_ID, id);
    }

    @Override
    public void updateMemberPrivilege(int projectUserId, boolean isManager) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_USER_ID, projectUserId);
        map.put(EntityConstants.PROJECT_USER_IS_MANAGER, isManager);
        getSqlSession().update(ProjectUser.class.getName() + SQL_ID_UPDATE_MEMBER_PRIVILEGE, map);
    }

    @Override
    public ProjectUserDTO getProjectUserDTO(int projectId, int userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.USER_ID, userId);
        return getSqlSession().selectOne(ProjectUser.class.getName() + SQL_ID_GET_PROJECT_USER_DTO, map);
    }

    @Override
    public List<ProjectUser> findAllProjectUser() {
        return getSqlSession().selectList(ProjectUser.class.getName() + SQL_ID_FIND_ALL_PROJECT_USER);
    }

    @Override
    public List<ProjectUser> findProjectUsersByProject(int projectId) {
        return getSqlSession()
                .selectList(ProjectUser.class.getName() + SQL_ID_FIND_PROJECT_USERS_BY_PROJECT, projectId);
    }
}
