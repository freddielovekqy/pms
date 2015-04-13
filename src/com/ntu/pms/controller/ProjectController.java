package com.ntu.pms.controller;

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
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.service.ProjectService;
import com.ntu.pms.service.UserService;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "showProjectList", method = RequestMethod.GET)
    public ModelAndView showProjectList(@RequestParam(value = "userId") int userId) throws BussinessException {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_PROJECT_MAIN);
        Map<String, List<ProjectDTO>> map = projectService.findProjectDTOByUser(userId);
        UserDTO userDTO = userService.getUserDTO(userId);
        mav.addObject(EntityConstants.USER_DTO, userDTO);
        mav.addAllObjects(map);
        return mav;
    }
}
