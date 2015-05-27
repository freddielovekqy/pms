package com.ntu.pms.controller;

import java.util.List;

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
import com.ntu.pms.dto.ScheduleDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.service.ProjectService;
import com.ntu.pms.service.ProjectUserService;
import com.ntu.pms.service.ScheduleService;

@RestController
@RequestMapping("schedule")
public class ScheduleController extends BaseController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ProjectUserService projectUserService;

    @RequestMapping(value = "showScheduleList", method = RequestMethod.GET)
    public ModelAndView showScheduleList(@RequestParam("projectId") int projectId) throws BussinessException {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_SCHEDULE_MAIN_PAGE);
        List<ScheduleDTO> scheduleDTOs = scheduleService.findScheduleDTOsByProjectId(projectId, getCurrentLoginUser());
        ProjectDTO projectDTO = projectService.getProjectDTOById(projectId);
        List<ProjectDTO> projectDTOs = projectService.findProjectDTOsByUser(getCurrentLoginUser().getId(), projectId);
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);
        mav.addObject(EntityConstants.SCHEDULE_DTOS, scheduleDTOs);
        mav.addObject(EntityConstants.PROJECT_DTO, projectDTO);
        mav.addObject(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        mav.addObject(EntityConstants.PROJECT_DTOS, projectDTOs);
        return mav;
    }

    @RequestMapping(value = "saveSchedule", method = RequestMethod.POST)
    public ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO) {
        scheduleDTO = scheduleService.saveSchedule(scheduleDTO, getCurrentLoginUser());
        return scheduleDTO;
    }

    @RequestMapping(value = "initEditSchedule", method = RequestMethod.GET)
    public ScheduleDTO initEditSchedule(@RequestParam("scheduleId") int scheduleId) {
        ScheduleDTO scheduleDTO = scheduleService.getScheduleDTOById(scheduleId);
        return scheduleDTO;
    }

    @RequestMapping(value = "updateSchedule", method = RequestMethod.POST)
    public ScheduleDTO updateSchedule(ScheduleDTO scheduleDTO) {
        scheduleDTO = scheduleService.updateSchedule(scheduleDTO);
        return scheduleDTO;
    }

    @RequestMapping(value = "deleteSchedule", method = RequestMethod.POST)
    public ScheduleDTO deleteSchedule(@RequestParam("scheduleId") int scheduleId) {
        ScheduleDTO scheduleDTO = scheduleService.deleteSchedule(scheduleId);
        return scheduleDTO;
    }

}
