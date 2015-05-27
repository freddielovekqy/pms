package com.ntu.pms.dao;

import java.util.Date;
import java.util.List;

import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.model.Sprint;

public interface SprintDao extends BaseDao<Sprint, Integer> {

    Integer getCurrnetSprintId(int projectId);

    Integer getRestSprintTime(int projectId, int sprintId);

    void updateSprintEndDate(int sprintId, Date endDate);

    SprintDTO getSprintDTOById(int sprintId);

    List<SprintDTO> findSprintDTOByProject(int projectId);

    void finishOldSprint(int projectId);
}
