package com.ntu.pms.controller;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.PageNameConstant;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.dto.RevisionDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.exception.ValidationException;
import com.ntu.pms.service.FolderService;
import com.ntu.pms.service.ProjectService;
import com.ntu.pms.service.ProjectUserService;
import com.ntu.pms.service.TaskService;
import com.ntu.pms.service.UserService;

@RestController
@RequestMapping("project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private FolderService folderService;

    @RequestMapping(value = "showProjectList", method = RequestMethod.GET)
    public ModelAndView showProjectList() throws BussinessException {
        UserDTO user = getCurrentLoginUser();
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_PROJECT_MAIN);
        Map<String, List<ProjectDTO>> map = projectService.findProjectDTOByUser(user.getId());
        UserDTO userDTO = userService.getUserDTO(user.getId());
        mav.addObject(EntityConstants.USER_DTO, userDTO);
        mav.addAllObjects(map);
        return mav;
    }

    @RequestMapping(value = "createProject", method = RequestMethod.POST)
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        UserDTO user = getCurrentLoginUser();
        projectDTO = projectService.saveProject(projectDTO, user);
        folderService.addFolderWhenCreateProject(projectDTO.getId(), user);
        return projectDTO;
    }

    @RequestMapping(value = "updateProject", method = RequestMethod.POST)
    public ProjectDTO updateProject(ProjectDTO projectDTO) throws BussinessException, ServerException,
            ValidationException {
        projectDTO = projectService.updateProject(projectDTO);
        return projectDTO;
    }

    @RequestMapping(value = "updateProjectUrl", method = RequestMethod.POST)
    public ProjectDTO updateProjectUrl(@RequestParam("projectId") int projectId) throws BussinessException {
        ProjectDTO projectDTO = projectService.updateProjectUrl(projectId);
        return projectDTO;
    }

    @RequestMapping(value = "showProjectMainPage", method = RequestMethod.GET)
    public ModelAndView showProjectMain(@RequestParam("projectId") int projectId) throws BussinessException {
        ModelAndView mav = new ModelAndView("project/project_main");
        List<ProjectDTO> projectDTOs = projectService.findProjectDTOsByUser(getCurrentLoginUser().getId(), projectId);
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);
        Map<String, Object> dataMap = projectService.getProjectMainPageData(projectId);
        Map<String, List<RevisionDTO>> dynamics = projectService.findProjectDynamic(projectId);
        Map<String, List<Object>> taskChartData = taskService.getTaskChartData(projectId);

        mav.addAllObjects(dataMap);
        mav.addAllObjects(dynamics);
        mav.addAllObjects(taskChartData);
        mav.addObject(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        mav.addObject(EntityConstants.PROJECT_DTOS, projectDTOs);
        return mav;
    }
}
