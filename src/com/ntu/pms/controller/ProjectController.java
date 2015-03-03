package com.ntu.pms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("project")
public class ProjectController {

    @RequestMapping(value = "showProjectList")
    public ModelAndView showProjectList() {
        ModelAndView mav = new ModelAndView("common/header");
        return mav;
    }
}
