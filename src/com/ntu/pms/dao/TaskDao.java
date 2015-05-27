package com.ntu.pms.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ntu.pms.dto.TaskDTO;
import com.ntu.pms.model.Task;

public interface TaskDao extends BaseDao<Task, Integer> {

    TaskDTO getTaskDTO(int taskId);

    int getTaskCountBySprint(int projectId, int sprintId);

    int getCompletedTaskCountBySprint(int projectId, int sprintId);

    double getRestTaskTimeBySprint(int projectId, int sprintId);

    Map<String, Map<String, Long>> getTaskChartData(int projectId, Date date);

    List<TaskDTO> findTaskDTOsByTicket(int projectId, int ticketId);

    void deleteTaskByTicket(int projectId, int ticketId);

    void updateTaskWhenTicketDeleted(int projectId, int sprintId, int ticketId, int defaultTicketId);

    boolean getBlockedTaskCountByTicket(int ticketId);

    void finishedAllTaskInTicket(int projectId, int ticketId);

    void moveTaskToCurrentSprint(int projectId, int sprintId);

    void finishAllSprintTask(int projectId);
}
