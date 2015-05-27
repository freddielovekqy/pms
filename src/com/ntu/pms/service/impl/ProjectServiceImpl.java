package com.ntu.pms.service.impl;

import java.rmi.ServerException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dao.ProjectDao;
import com.ntu.pms.dao.ProjectUserDao;
import com.ntu.pms.dao.RevisionDao;
import com.ntu.pms.dao.SprintDao;
import com.ntu.pms.dao.TaskDao;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.dto.RevisionDTO;
import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.exception.ValidationException;
import com.ntu.pms.model.Project;
import com.ntu.pms.model.ProjectUser;
import com.ntu.pms.service.BaseService;
import com.ntu.pms.service.ProjectService;
import com.ntu.pms.service.SequenceService;
import com.ntu.pms.utils.ProjectConverter;
import com.ntu.pms.utils.StringUtils;

@Service("projectService")
public class ProjectServiceImpl extends BaseService implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private SprintDao sprintDao;
    @Autowired
    private RevisionDao revisionDao;
    @Autowired
    private ProjectUserDao projectUserDao;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public List<ProjectDTO> findProjectDTOsByUser(int userId, int currentProjectId) {
        List<ProjectDTO> projectDTOs = projectDao.findProjectDTOByUser(userId);
        for (int i = 0; i < projectDTOs.size(); i++) {
            if (projectDTOs.get(i).getId() == currentProjectId) {
                projectDTOs.remove(i);
            }
        }
        return projectDTOs;
    }

    @Override
    public Map<String, List<ProjectDTO>> findProjectDTOByUser(int userId) {
        List<ProjectDTO> projectDTOs = projectDao.findProjectDTOByUser(userId);
        List<ProjectDTO> filedProjectDTOs = projectDao.findFiledProjectDTOByUser(userId);
        Map<String, List<ProjectDTO>> projectMap = new HashMap<String, List<ProjectDTO>>();
        projectMap.put("onlineProjectDTOs", projectDTOs);
        projectMap.put("filedProjectDTOs", filedProjectDTOs);
        return projectMap;
    }

    @Override
    public Map<String, Object> getProjectMainPageData(int projectId) throws BussinessException {
        ProjectDTO projectDTO = this.getProjectDTOById(projectId);
        Integer sprintId = sprintDao.getCurrnetSprintId(projectId);
        if (sprintId != null) {
            SprintDTO sprintDTO = sprintDao.getSprintDTOById(sprintId);
            projectDTO.setSprintId(sprintId);
            projectDTO.setSprintName(sprintDTO.getName());
        }

        int totalTaskCount = 0;
        int completedTaskCount = 0;
        int restSprintTime = 0;
        if (sprintId != null) {
            totalTaskCount = taskDao.getTaskCountBySprint(projectId, sprintId);
            completedTaskCount = taskDao.getCompletedTaskCountBySprint(projectId, sprintId);
            restSprintTime = sprintDao.getRestSprintTime(projectId, sprintId);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_DTO, projectDTO);
        map.put(OtherConstants.TOTAL_TASK_COUNT, totalTaskCount);
        map.put(OtherConstants.COMPLETED_TASK_COUNT, completedTaskCount);
        map.put(OtherConstants.REST_SPRINT_TIME, restSprintTime);
        return map;
    }

    @Override
    public Map<String, List<RevisionDTO>> findProjectDynamic(int projectId) {
        List<RevisionDTO> todayDynamic = revisionDao.findRevisionByTime(projectId, new Date());
        List<RevisionDTO> lastDateDynamic = revisionDao.findLastDateDynamic(projectId);
        Map<String, List<RevisionDTO>> dynamics = new HashMap<String, List<RevisionDTO>>();
        dynamics.put("todayDynamic", todayDynamic);
        dynamics.put("lastDateDynamic", lastDateDynamic);
        return dynamics;
    }

    @Override
    public ProjectDTO getProjectDTOById(int id) throws BussinessException {
        ProjectDTO projectDTO = projectDao.getDTOById(id);
        if (projectDTO == null || projectDTO.getState() != 1) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(EntityConstants.OBJECT_TYPE, EntityConstants.USER);
            map.put(EntityConstants.OBJECT_ID, id);
            throw new BussinessException("No user or user exit.", map);
        }
        return projectDTO;
    }

    @Override
    public Project getProjectById(int id) throws BussinessException {
        Project project = projectDao.getById(id);
        if (project == null || project.getState() != 1) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(EntityConstants.OBJECT_TYPE, EntityConstants.USER);
            map.put(EntityConstants.OBJECT_ID, id);
            throw new BussinessException("No user or user exit.", map);
        }
        return project;
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) throws BussinessException, ServerException,
            ValidationException {
        validate(projectDTO);
        Project project = this.getProjectById(projectDTO.getId());
        project = ProjectConverter.converterDTOToModel(projectDTO, project, true);
        projectDao.update(project);
        projectDTO = projectDao.getDTOById(project.getId());
        return projectDTO;
    }

    @Override
    public ProjectDTO updateProjectUrl(int projectId) throws BussinessException {
        String newUrl = StringUtils.getRandomUrlString();
        projectDao.updateProjectUrl(projectId, newUrl);
        ProjectDTO projectDTO = this.getProjectDTOById(projectId);
        return projectDTO;
    }

    @Override
    public ProjectDTO getProjectByUrl(String url) {
        return projectDao.getProjectByUrl(url);
    }

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO, UserDTO userDTO) {
        Project project = new Project();
        project = ProjectConverter.converterDTOToModel(projectDTO, project, true);
        project.setCreatorId(userDTO.getId());
        project.setAddMemberUrl(StringUtils.getRandomUrlString());
        project.setCreateTime(new Date());
        projectDao.add(project);
        ProjectUser projectUser = new ProjectUser(project.getId(), userDTO.getId());
        projectUser.setIsManager(true);
        projectUserDao.add(projectUser);
        sequenceService.addProjectSequence(project.getId());
        projectDTO = projectDao.getDTOById(project.getId());
        return projectDTO;
    }
}
