package com.ntu.pms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.ScheduleDao;
import com.ntu.pms.dto.ScheduleDTO;
import com.ntu.pms.model.Schedule;

@Repository("scheduleDao")
public class ScheduleDaoImpl extends BaseDaoImpl<Schedule, Integer> implements ScheduleDao {

    private static final String SQL_ID_GET_DTO_BY_ID = ".getDTOById";
    private static final String SQL_ID_FIND_ALL_SCHEDULE_DTOS_BY_PROJECT_ID = ".findAllScheduleDTOsByProjectId";
    private static final String SQL_ID_FIND_UNFINISHED_SCHEDULE_DTOS_BY_PROJECT_ID = ".findUnfinishedScheduleDTOsByProjectId";

    @Override
    public ScheduleDTO getDTOById(int scheduleId) {
        return getSqlSession().selectOne(Schedule.class.getName() + SQL_ID_GET_DTO_BY_ID, scheduleId);
    }

    @Override
    public List<ScheduleDTO> findAllScheduleDTOsByProjectId(int projectId) {
        return getSqlSession().selectList(Schedule.class.getName() + SQL_ID_FIND_ALL_SCHEDULE_DTOS_BY_PROJECT_ID,
                projectId);
    }

    @Override
    public List<ScheduleDTO> findUnfinishedScheduleDTOsByProjectId(int projectId) {
        return getSqlSession().selectList(
                Schedule.class.getName() + SQL_ID_FIND_UNFINISHED_SCHEDULE_DTOS_BY_PROJECT_ID, projectId);
    }

}
