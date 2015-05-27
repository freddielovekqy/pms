package com.ntu.pms.service;

import java.util.List;

import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.dto.UserDTO;

public interface SprintService {

    SprintDTO updateSprintEndDate(int sprintId);

    SprintDTO getSprintDTOById(int sprintId);

    List<SprintDTO> findSprintDTOByProject(int projectId);

    SprintDTO createSprint(SprintDTO sprintDTO, UserDTO userDTO);

    void updateTicketAndTask(int projectId, int sprintId, boolean isMove);
}
