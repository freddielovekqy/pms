package com.ntu.pms.dao;

import java.util.List;

import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.model.Project;

public interface ProjectDao extends BaseDao<Project, Integer> {

    List<ProjectDTO> findProjectDTOByUser(int userId);

    List<ProjectDTO> findFiledProjectDTOByUser(int userId);
}
