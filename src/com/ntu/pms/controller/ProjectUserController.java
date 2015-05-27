package com.ntu.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.PageNameConstant;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.service.ProjectService;
import com.ntu.pms.service.ProjectUserService;

@RestController
@RequestMapping("projectUser")
public class ProjectUserController extends BaseController {

    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "addProjectMember/{addMemberUrl}", method = RequestMethod.GET)
    public ModelAndView addProjectMember(@PathVariable String addMemberUrl) {
        ProjectDTO projectDTO = projectService.getProjectByUrl(addMemberUrl);
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_ADD_PROJECT_MEMBER);
        mav.addObject(EntityConstants.PROJECT_DTO, projectDTO);
        return mav;
    }

    @RequestMapping(value = "joinInProject", method = RequestMethod.POST)
    public ModelAndView joinInProject(@RequestParam("projectId") int projectId) {
        ModelAndView mav = new ModelAndView(PageNameConstant.REDIRECT_PROJECT_MAIN_PAGE + projectId);
        UserDTO userDTO = getCurrentLoginUser();
        projectUserService.addProjectMember(userDTO.getId(), projectId);
        return mav;
    }

    @RequestMapping(value = "removeProjectMember", method = RequestMethod.POST)
    public ProjectUserDTO removeProjectMember(@RequestParam("projectUserId") int projectUserId) {
        ProjectUserDTO projectUserDTO = projectUserService.removeProjectMember(projectUserId);
        return projectUserDTO;
    }

    @RequestMapping(value = "validateManager", method = RequestMethod.GET)
    public ProjectUserDTO validateManager(@RequestParam("projectId") int projectId) {
        ProjectUserDTO projectUserDTO = projectUserService.validateManager(projectId, getCurrentLoginUser());
        return projectUserDTO;
    }

    @RequestMapping(value = "updateMemberPrivilege", method = RequestMethod.POST)
    public ProjectUserDTO updateMemberPrivilege(@RequestParam("projectUserId") int projectUserId,
            @RequestParam("isManager") boolean isManager) {
        ProjectUserDTO projectUserDTO = projectUserService.updateMemberPrivilege(projectUserId, isManager);
        return projectUserDTO;
    }
}
