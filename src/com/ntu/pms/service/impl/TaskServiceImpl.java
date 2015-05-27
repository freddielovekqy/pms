package com.ntu.pms.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dao.RevisionDao;
import com.ntu.pms.dao.SequenceDao;
import com.ntu.pms.dao.TaskDao;
import com.ntu.pms.dao.TicketDao;
import com.ntu.pms.dto.TaskDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.model.Revision;
import com.ntu.pms.model.Task;
import com.ntu.pms.model.Ticket;
import com.ntu.pms.service.BaseService;
import com.ntu.pms.service.TaskService;
import com.ntu.pms.service.TicketService;
import com.ntu.pms.utils.DateUtil;
import com.ntu.pms.utils.TaskConverter;

@Service("taskService")
public class TaskServiceImpl extends BaseService implements TaskService {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private RevisionDao revisionDao;

    @Override
    public Map<String, List<Object>> getTaskChartData(int projectId) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        cd.add(Calendar.DATE, -7);
        Map<String, Map<String, Long>> map = taskDao.getTaskChartData(projectId, cd.getTime());
        Map<String, List<Object>> taskChart = new HashMap<String, List<Object>>();
        List<Object> labels = new ArrayList<Object>();
        List<Object> data = new ArrayList<Object>();

        for (int i = 0; i < 7; i++) {
            cd.add(Calendar.DATE, 1);
            String date = DateUtil.getMonthDay(cd);
            labels.add(date);
            int count = map.get(date) == null ? 0 : Integer.valueOf(map.get(date).get("taskCount").toString());
            data.add(count);
        }

        taskChart.put("labels", labels);
        taskChart.put("data", data);
        return taskChart;
    }

    @Override
    public List<TaskDTO> findTaskDTOsByTicket(int projectId, int ticketId) {
        return taskDao.findTaskDTOsByTicket(projectId, ticketId);
    }

    @Override
    public TaskDTO getTaskDTOById(int taskId) throws BussinessException {
        TaskDTO taskDTO = taskDao.getTaskDTO(taskId);
        if (taskDTO == null || !taskDTO.getIsActive()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(EntityConstants.OBJECT_TYPE, EntityConstants.TASK_DTO);
            map.put(EntityConstants.OBJECT_ID, taskId);
            throw new BussinessException("任务不存在或任务已被删除.", map);
        }
        return taskDTO;
    }

    @Override
    public TaskDTO deleteTask(int taskId) throws BussinessException {
        TaskDTO taskDTO = this.getTaskDTOById(taskId);
        taskDao.delete(taskId);
        return taskDTO;
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, UserDTO creator) throws BussinessException {
        Task task = taskDao.getById(taskDTO.getId());
        task = TaskConverter.converterDTOToModel(taskDTO, task);
        taskDao.update(task);
        ticketService.updateTicketScientific(taskDTO.getTicketId());

        if (OtherConstants.STATE_COMPLETED.equals(task.getState())) {
            Revision revision = new Revision("完成一个任务", task.getId(), task.getName(), EntityConstants.TYPE_TASK,
                    task.getProjectId(), creator.getId());
            revisionDao.add(revision);
        }
        return taskDTO;
    }

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO, UserDTO creator) throws BussinessException {
        Task task = new Task();
        task = TaskConverter.converterDTOToModel(taskDTO, task);
        Ticket ticket = ticketDao.getById(taskDTO.getTicketId());
        task.setProjectId(ticket.getProjectId());
        task.setSprintId(ticket.getSprintId());
        task.setCreateTime(new Date());
        task.setCreatorId(creator.getId());

        int serialNumber = sequenceDao.getCurrentValue(ticket.getProjectId(), EntityConstants.TYPE_TASK);
        task.setSerialNumber(serialNumber + 1);

        taskDao.add(task);
        sequenceDao.updateValue(ticket.getProjectId(), EntityConstants.TYPE_TASK);
        ticketService.updateTicketScientific(ticket.getId());

        Revision revision = new Revision("创建一个新任务", task.getId(), task.getName(), EntityConstants.TYPE_TASK,
                task.getProjectId(), creator.getId());
        revisionDao.add(revision);
        taskDTO = taskDao.getTaskDTO(task.getId());
        return taskDTO;
    }
}
