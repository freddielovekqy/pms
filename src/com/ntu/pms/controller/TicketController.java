package com.ntu.pms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dto.Pagination;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.dto.TicketDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.service.ProjectUserService;
import com.ntu.pms.service.SprintService;
import com.ntu.pms.service.TicketService;

@RestController
@RequestMapping("ticket")
public class TicketController extends BaseController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private SprintService sprintService;

    @RequestMapping(value = "showTicketListBySprint", method = RequestMethod.GET)
    public Pagination showTicketListBySprint(@RequestParam("projectId") int projectId,
            @RequestParam("sprintId") int sprintId, @RequestParam("pageIndex") int pageIndex) {
        Pagination pagination = ticketService.findTicketDTOsBySprint(projectId, sprintId, pageIndex);
        return pagination;
    }

    @RequestMapping(value = "deleteTicket", method = RequestMethod.POST)
    public TicketDTO deleteTicket(int projectId, int sprintId, int ticketId, boolean isCascade)
            throws BussinessException {
        TicketDTO ticketDTO = ticketService.deleteTicket(projectId, sprintId, ticketId, isCascade);
        return ticketDTO;
    }

    @RequestMapping(value = "initEditTicket", method = RequestMethod.GET)
    public Map<String, Object> initEditTicket(@RequestParam("projectId") int projectId,
            @RequestParam("ticketId") int ticketId) throws BussinessException {
        TicketDTO ticketDTO = ticketService.getTicketDTOById(ticketId);
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);
        List<SprintDTO> sprintDTOs = sprintService.findSprintDTOByProject(projectId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.TICKET_DTO, ticketDTO);
        map.put(EntityConstants.SPRINT_DTOS, sprintDTOs);
        map.put(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        return map;
    }

    @RequestMapping(value = "updateTicket", method = RequestMethod.POST)
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        ticketDTO = ticketService.updateTicket(ticketDTO);
        return ticketDTO;
    }

    @RequestMapping(value = "initCreateTicket", method = RequestMethod.GET)
    public Map<String, Object> initCreateTicket(@RequestParam("projectId") int projectId) {
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);
        List<SprintDTO> sprintDTOs = sprintService.findSprintDTOByProject(projectId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        map.put(EntityConstants.SPRINT_DTOS, sprintDTOs);
        return map;
    }

    @RequestMapping(value = "saveTicket", method = RequestMethod.POST)
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        ticketDTO = ticketService.saveTicket(ticketDTO, getCurrentLoginUser());
        return ticketDTO;
    }
}
