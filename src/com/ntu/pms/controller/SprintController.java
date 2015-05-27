package com.ntu.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.service.SprintService;

@RestController
@RequestMapping("sprint")
public class SprintController extends BaseController {

    @Autowired
    private SprintService sprintService;

    @RequestMapping(value = "updateSprintEndDate", method = RequestMethod.POST)
    public SprintDTO updateSprintEndDate(@RequestParam("sprintId") int sprintId) {
        SprintDTO sprintDTO = sprintService.updateSprintEndDate(sprintId);
        return sprintDTO;
    }

    @RequestMapping(value = "saveSprint", method = RequestMethod.POST)
    public SprintDTO saveSprint(SprintDTO sprintDTO) {
        sprintDTO = sprintService.createSprint(sprintDTO, getCurrentLoginUser());
        return sprintDTO;
    }

    @RequestMapping(value = "updateTicketAndTask", method = RequestMethod.POST)
    public void updateTicketAndTask(@RequestParam("projectId") int projectId, @RequestParam("sprintId") int sprintId,
            @RequestParam("isMove") boolean isMove) {

    }
}
