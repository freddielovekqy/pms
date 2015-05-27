package com.ntu.pms.dao;

import java.util.List;

import com.ntu.pms.dto.ScheduleDTO;
import com.ntu.pms.model.Schedule;

public interface ScheduleDao extends BaseDao<Schedule, Integer> {

    ScheduleDTO getDTOById(int scheduleId);

    List<ScheduleDTO> findAllScheduleDTOsByProjectId(int projectId);

    List<ScheduleDTO> findUnfinishedScheduleDTOsByProjectId(int projectId);
}
