package com.ntu.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.dao.ProjectDao;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public Map<String, List<ProjectDTO>> findProjectDTOByUser(int userId) {
        List<ProjectDTO> projectDTOs = projectDao.findProjectDTOByUser(userId);
        List<ProjectDTO> filedProjectDTOs = projectDao.findFiledProjectDTOByUser(userId);
        Map<String, List<ProjectDTO>> projectMap = new HashMap<String, List<ProjectDTO>>();
        projectMap.put("onlineProjectDTOs", projectDTOs);
        projectMap.put("filedProjectDTOs", filedProjectDTOs);
        return projectMap;
    }

}
