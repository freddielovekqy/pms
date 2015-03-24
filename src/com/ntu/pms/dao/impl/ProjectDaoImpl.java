package com.ntu.pms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.ProjectDao;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.model.Project;

@Repository("projectDao")
public class ProjectDaoImpl extends BaseDaoImpl<Project, Integer> implements ProjectDao {

    private static final String SQL_ID_FIND_PROJECT_DTO_BY_USER = ".findProjectDTOByUser";
    
    @Override
    public List<ProjectDTO> findProjectDTOByUser(int userId) {
        return getSqlSession().selectList(Project.class.getName() + SQL_ID_FIND_PROJECT_DTO_BY_USER, userId);
    }

}
