package com.ntu.pms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.TaskDao;
import com.ntu.pms.dto.TaskDTO;
import com.ntu.pms.model.Task;

@Repository("taskDao")
public class TaskDaoImpl extends BaseDaoImpl<Task, Integer> implements TaskDao {

    private static final String SQL_ID_GET_TASK_DTO = ".getTaskDTO";
    private static final String SQL_ID_GET_TASK_COUNT_BY_SPRINT = ".getTaskCountBySprint";
    private static final String SQL_ID_GET_COMPLETED_TASK_COUNT_BY_SPRINT = ".getCompletedTaskCountBySprint";
    private static final String SQL_ID_GET_REST_TASK_TIME_BY_SPRINT = ".getRestTaskTimeBySprint";
    private static final String SQL_ID_GET_TASK_CHART_DATA = ".getTaskChartData";
    private static final String SQL_ID_FIND_TASK_DTOS_BY_TICKET = ".findTaskDTOsByTicket";
    private static final String SQL_ID_DELETE_TASK_BY_TICKET = ".deleteTaskByTicket";
    private static final String SQL_ID_UPDATE_TASK_WHEN_TICKET_DELETED = ".updateTaskWhenTicketDeleted";
    private static final String SQL_ID_GET_BLOCKED_TASK_COUNT_BY_TICKET = ".getBlockedTaskCountByTicket";
    private static final String SQL_ID_FINISHED_ALL_TASK_IN_TICKET = ".finishedAllTaskInTicket";
    private static final String SQL_ID_MOVE_TASK_TO_CURRENT_SPRINT = ".moveTaskToCurrentSprint";
    private static final String SQL_ID_FINISH_ALL_SPRINT_TASK = ".finishAllSprintTask";

    @Override
    public int getTaskCountBySprint(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        return getSqlSession().selectOne(Task.class.getName() + SQL_ID_GET_TASK_COUNT_BY_SPRINT, map);
    }

    @Override
    public int getCompletedTaskCountBySprint(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        return getSqlSession().selectOne(Task.class.getName() + SQL_ID_GET_COMPLETED_TASK_COUNT_BY_SPRINT, map);
    }

    @Override
    public double getRestTaskTimeBySprint(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        return getSqlSession().selectOne(Task.class.getName() + SQL_ID_GET_REST_TASK_TIME_BY_SPRINT, map);
    }

    @Override
    public Map<String, Map<String, Long>> getTaskChartData(int projectId, Date date) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put("endTime", date);
        return getSqlSession().selectMap(Task.class.getName() + SQL_ID_GET_TASK_CHART_DATA, map, "endTime");
    }

    @Override
    public List<TaskDTO> findTaskDTOsByTicket(int projectId, int ticketId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.TICKET_ID, ticketId);
        return getSqlSession().selectList(Task.class.getName() + SQL_ID_FIND_TASK_DTOS_BY_TICKET, map);
    }

    @Override
    public void deleteTaskByTicket(int projectId, int ticketId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.TICKET_ID, ticketId);
        getSqlSession().update(Task.class.getName() + SQL_ID_DELETE_TASK_BY_TICKET, map);
    }

    @Override
    public void updateTaskWhenTicketDeleted(int projectId, int sprintId, int ticketId, int defaultTicketId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        map.put(EntityConstants.TICKET_ID, ticketId);
        map.put(EntityConstants.SPRINT_DEFAULT_TICKET_ID, defaultTicketId);
        getSqlSession().update(Task.class.getName() + SQL_ID_UPDATE_TASK_WHEN_TICKET_DELETED, map);
    }

    @Override
    public TaskDTO getTaskDTO(int taskId) {
        return getSqlSession().selectOne(Task.class.getName() + SQL_ID_GET_TASK_DTO, taskId);
    }

    @Override
    public boolean getBlockedTaskCountByTicket(int ticketId) {
        int count = getSqlSession().selectOne(Task.class.getName() + SQL_ID_GET_BLOCKED_TASK_COUNT_BY_TICKET, ticketId);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void finishedAllTaskInTicket(int projectId, int ticketId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.TICKET_ID, ticketId);
        getSqlSession().update(Task.class.getName() + SQL_ID_FINISHED_ALL_TASK_IN_TICKET, map);
    }

    @Override
    public void moveTaskToCurrentSprint(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        getSqlSession().update(Task.class.getName() + SQL_ID_MOVE_TASK_TO_CURRENT_SPRINT, map);
    }

    @Override
    public void finishAllSprintTask(int projectId) {
        getSqlSession().update(Task.class.getName() + SQL_ID_FINISH_ALL_SPRINT_TASK, projectId);
    }
}
