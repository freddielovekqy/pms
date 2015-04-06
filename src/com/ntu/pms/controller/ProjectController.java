package com.ntu.pms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.constant.PageNameConstant;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.service.ProjectService;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "showProjectList")
    public ModelAndView showProjectList() {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_PROJECT_MAIN);
        Map<String, List<ProjectDTO>> map = projectService.findProjectDTOByUser(1);
        mav.addAllObjects(map);
        return mav;
    }
}
