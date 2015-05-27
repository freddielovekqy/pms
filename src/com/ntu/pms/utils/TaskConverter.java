package com.ntu.pms.utils;

import java.util.Date;

import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dto.TaskDTO;
import com.ntu.pms.model.Task;

public class TaskConverter {

    public static Task converterDTOToModel(TaskDTO taskDTO, Task task) {
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setOwner(taskDTO.getOwner());
        task.setState(taskDTO.getState());
        task.setBlocked(taskDTO.getBlocked());
        task.setEstimate(taskDTO.getEstimate());
        task.setTodo(taskDTO.getTodo());
        task.setTicketId(taskDTO.getTicketId());
        task.setDegree(taskDTO.getDegree());

        if (OtherConstants.STATE_COMPLETED.equals(task.getState())) {
            task.setTodo(0);
            task.setBlocked(false);
            task.setEndTime(new Date());
        }
        return task;
    }
}
