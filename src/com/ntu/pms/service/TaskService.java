package com.ntu.pms.service;

import java.util.List;
import java.util.Map;

import com.ntu.pms.dto.TaskDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;

public interface TaskService {

    Map<String, List<Object>> getTaskChartData(int projectId);

    List<TaskDTO> findTaskDTOsByTicket(int projectId, int ticketId);

    TaskDTO getTaskDTOById(int taskId) throws BussinessException;

    TaskDTO deleteTask(int taskId) throws BussinessException;

    TaskDTO updateTask(TaskDTO taskDTO, UserDTO userDTO) throws BussinessException;

    TaskDTO saveTask(TaskDTO taskDTO, UserDTO creator) throws BussinessException;
}
