package com.ntu.pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.dto.ResultObjectDTO;

@RestController
@RequestMapping("project")
public class ProjectController {

    @RequestMapping(value = "showProjectList")
    public ModelAndView showProjectList(HttpSession session) {
        ModelAndView mav = new ModelAndView("common/header");
        ResultObjectDTO resultObjectDTO = new ResultObjectDTO();
        resultObjectDTO.setMesCount(1);
        resultObjectDTO.setResultObject(session.getAttribute("user"));
        mav.addObject("resultObject", resultObjectDTO);
        return mav;
    }
}
