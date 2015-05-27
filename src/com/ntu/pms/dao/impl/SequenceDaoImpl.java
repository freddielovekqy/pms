package com.ntu.pms.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.SequenceDao;
import com.ntu.pms.model.Sequence;

@Repository("sequenceDao")
public class SequenceDaoImpl extends BaseDaoImpl<Sequence, Integer> implements SequenceDao {

    private static final String SQL_ID_GET_CURRENT_VALUE = ".getCurrentValue";
    private static final String SQL_ID_UPDATE_VALUE = ".updateValue";

    @Override
    public int getCurrentValue(int projectId, String type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SEQUENCE_TYPE, type);
        return getSqlSession().selectOne(Sequence.class.getName() + SQL_ID_GET_CURRENT_VALUE, map);
    }

    @Override
    public void updateValue(int projectId, String type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SEQUENCE_TYPE, type);
        getSqlSession().update(Sequence.class.getName() + SQL_ID_UPDATE_VALUE, map);
    }

}
