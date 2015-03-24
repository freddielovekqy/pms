package com.ntu.pms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.constant.PageNameConstant;
import com.ntu.pms.dto.ProjectDTO;

@RestController
@RequestMapping("project")
public class ProjectController {

    @RequestMapping(value = "showProjectList")
    public ModelAndView showProjectList(HttpSession session) {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_PROJECT_MAIN);
        ProjectDTO projectDTO1 = new ProjectDTO();
        projectDTO1.setName("Online Exam System");
        projectDTO1.setDescription("在线考试系统");
        ProjectDTO projectDTO2 = new ProjectDTO();
        projectDTO2.setName("Project Management System");
        projectDTO2.setDescription("项目管理系统");
        List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();
        projectDTOs.add(projectDTO1);
        projectDTOs.add(projectDTO2);
        mav.addObject("projectDTOs", projectDTOs);
        return mav;
    }
}
