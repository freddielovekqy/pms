package com.ntu.pms.controller;

import java.util.HashMap;
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
import com.ntu.pms.dto.Pagination;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.dto.TaskDTO;
import com.ntu.pms.dto.TicketDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.service.ProjectService;
import com.ntu.pms.service.ProjectUserService;
import com.ntu.pms.service.SprintService;
import com.ntu.pms.service.TaskService;
import com.ntu.pms.service.TicketService;

@RestController
@RequestMapping("task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectUserService projectUserService;
    @Autowired
    private SprintService sprintService;
    @Autowired
    private TicketService ticketService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "showTaskListPage", method = RequestMethod.GET)
    public ModelAndView showTaskListPage(@RequestParam("projectId") int projectId) throws BussinessException {
        ProjectDTO projectDTO = projectService.getProjectDTOById(projectId);
        List<ProjectDTO> projectDTOs = projectService.findProjectDTOsByUser(getCurrentLoginUser().getId(), projectId);
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);
        List<SprintDTO> sprintDTOs = sprintService.findSprintDTOByProject(projectId);
        Pagination pagination = ticketService.findCurrentSprintTicketDTOs(projectId);
        List<TicketDTO> ticketDTOs = pagination.getList();

        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_TASK_LIST);
        mav.addObject(EntityConstants.PROJECT_DTO, projectDTO);
        mav.addObject(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        mav.addObject(EntityConstants.SPRINT_DTOS, sprintDTOs);
        mav.addObject(EntityConstants.TICKET_DTOS, ticketDTOs);
        mav.addObject(EntityConstants.PAGINATION, pagination);
        mav.addObject(EntityConstants.PROJECT_DTOS, projectDTOs);
        return mav;
    }

    @RequestMapping(value = "showTaskByTicket", method = RequestMethod.GET)
    public List<TaskDTO> showTaskByTicket(@RequestParam("projectId") int projectId,
            @RequestParam("ticketId") int ticketId) {
        List<TaskDTO> taskDTOs = taskService.findTaskDTOsByTicket(projectId, ticketId);
        return taskDTOs;
    }

    @RequestMapping(value = "deleteTask", method = RequestMethod.POST)
    public TaskDTO deleteTask(@RequestParam("taskId") int taskId) throws BussinessException {
        TaskDTO taskDTO = taskService.deleteTask(taskId);
        return taskDTO;
    }

    @RequestMapping(value = "initEditTask", method = RequestMethod.GET)
    public Map<String, Object> initEditTask(@RequestParam("taskId") int taskId,
            @RequestParam("projectId") int projectId, @RequestParam("sprintId") int sprintId) throws BussinessException {
        TaskDTO taskDTO = taskService.getTaskDTOById(taskId);
        List<TicketDTO> ticketDTOs = ticketService.findAllTicketDTOsBySprint(projectId, sprintId);
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.TASK_DTO, taskDTO);
        map.put(EntityConstants.TICKET_DTOS, ticketDTOs);
        map.put(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        return map;
    }

    @RequestMapping(value = "updateTask", method = RequestMethod.POST)
    public void updateTask(TaskDTO taskDTO) throws BussinessException {
        taskDTO = taskService.updateTask(taskDTO, getCurrentLoginUser());
    }

    @RequestMapping(value = "initCreateTask", method = RequestMethod.GET)
    public Map<String, Object> initCreateTask(@RequestParam("projectId") int projectId,
            @RequestParam("sprintId") int sprintId) {
        List<TicketDTO> ticketDTOs = ticketService.findAllTicketDTOsBySprint(projectId, sprintId);
        List<ProjectUserDTO> projectUserDTOs = projectUserService.getProjectUserDTOsByProjectId(projectId);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.TICKET_DTOS, ticketDTOs);
        map.put(EntityConstants.PROJECT_USER_DTOS, projectUserDTOs);
        return map;
    }

    @RequestMapping(value = "saveTask", method = RequestMethod.POST)
    public TaskDTO saveTask(TaskDTO taskDTO) throws BussinessException {
        taskDTO = taskService.saveTask(taskDTO, getCurrentLoginUser());
        return taskDTO;
    }

    @RequestMapping(value = "saveTaskAndShow", method = RequestMethod.POST)
    public List<TaskDTO> saveTaskAndShow(TaskDTO taskDTO) throws BussinessException {
        taskDTO = taskService.saveTask(taskDTO, getCurrentLoginUser());
        List<TaskDTO> taskDTOs = taskService.findTaskDTOsByTicket(taskDTO.getProjectId(), taskDTO.getTicketId());
        return taskDTOs;
    }

}
