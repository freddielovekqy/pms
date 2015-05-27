package com.ntu.pms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.SprintDao;
import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.model.Sprint;

@Repository("sprintDao")
public class SprintDaoImpl extends BaseDaoImpl<Sprint, Integer> implements SprintDao {

    private static final String SQL_ID_GET_CURRENT_SPRINT_ID = ".getCurrnetSprintId";
    private static final String SQL_ID_GET_REST_SPRINT_TIME = ".getRestSprintTime";
    private static final String SQL_ID_UPDATE_SPRINT_END_DATE = ".updateSprintEndDate";
    private static final String SQL_ID_GET_SPRINT_DTO_BY_ID = ".getDTOById";
    private static final String SQL_ID_FIND_SPRINT_DTO_BY_PROJECT = ".findSprintDTOByProject";
    private static final String SQL_ID_FINISH_OLD_SPRINT = ".finishOldSprint";

    @Override
    public Integer getCurrnetSprintId(int projectId) {
        return getSqlSession().selectOne(Sprint.class.getName() + SQL_ID_GET_CURRENT_SPRINT_ID, projectId);
    }

    @Override
    public Integer getRestSprintTime(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        return getSqlSession().selectOne(Sprint.class.getName() + SQL_ID_GET_REST_SPRINT_TIME, map);
    }

    @Override
    public void updateSprintEndDate(int sprintId, Date endDate) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.SPRINT_ID, sprintId);
        map.put(EntityConstants.SPRINT_END_DATE, endDate);
        getSqlSession().update(Sprint.class.getName() + SQL_ID_UPDATE_SPRINT_END_DATE, map);
    }

    @Override
    public SprintDTO getSprintDTOById(int sprintId) {
        return getSqlSession().selectOne(Sprint.class.getName() + SQL_ID_GET_SPRINT_DTO_BY_ID, sprintId);
    }

    @Override
    public List<SprintDTO> findSprintDTOByProject(int projectId) {
        return getSqlSession().selectList(Sprint.class.getName() + SQL_ID_FIND_SPRINT_DTO_BY_PROJECT, projectId);
    }

    @Override
    public void finishOldSprint(int projectId) {
        getSqlSession().update(Sprint.class.getName() + SQL_ID_FINISH_OLD_SPRINT, projectId);
    }

}
