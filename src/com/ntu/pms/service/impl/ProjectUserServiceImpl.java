package com.ntu.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.dao.ProjectDao;
import com.ntu.pms.dao.ProjectUserDao;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.model.Project;
import com.ntu.pms.model.ProjectUser;
import com.ntu.pms.service.ProjectUserService;

@Service("projectUserService")
public class ProjectUserServiceImpl implements ProjectUserService {

    @Autowired
    private ProjectUserDao projectUserDao;
    @Autowired
    private ProjectDao projectDao;

    @Override
    public List<ProjectUserDTO> getProjectUserDTOsByProjectId(int projectId) {
        List<ProjectUserDTO> projectUserDTOs = projectUserDao.getProjectUserDTOsByProjectId(projectId);
        return projectUserDTOs;
    }

    @Override
    public ProjectUserDTO addProjectMember(int userId, int projectId) {
        ProjectUser projectUser = new ProjectUser();
        projectUser.setUserId(userId);
        projectUser.setProjectId(projectId);
        int id = projectUserDao.add(projectUser);
        ProjectUserDTO projectUserDTO = projectUserDao.getDTOById(id);
        return projectUserDTO;
    }

    @Override
    public ProjectUserDTO removeProjectMember(int projectUserid) {
        projectUserDao.delete(projectUserid);
        ProjectUserDTO projectUserDTO = projectUserDao.getDTOById(projectUserid);
        return projectUserDTO;
    }

    @Override
    public ProjectUserDTO updateMemberPrivilege(int projectUserId, boolean isManager) {
        projectUserDao.updateMemberPrivilege(projectUserId, isManager);
        ProjectUserDTO projectUserDTO = projectUserDao.getDTOById(projectUserId);
        return projectUserDTO;
    }

    @Override
    public ProjectUserDTO validateManager(int projectId, UserDTO userDTO) {
        ProjectUserDTO projectUserDTO = projectUserDao.getProjectUserDTO(projectId, userDTO.getId());
        return projectUserDTO;
    }

    @Override
    public Map<Integer, List<ProjectUser>> findAllProjectUser() {
        List<Project> projects = projectDao.findAllProject();
        Map<Integer, List<ProjectUser>> map = new HashMap<Integer, List<ProjectUser>>();
        for (Project project : projects) {
            List<ProjectUser> projectUsers = projectUserDao.findProjectUsersByProject(project.getId());
            map.put(project.getId(), projectUsers);
        }
        return map;
    }
}
