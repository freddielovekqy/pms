package com.ntu.pms.dao;

import com.ntu.pms.model.Sequence;

public interface SequenceDao extends BaseDao<Sequence, Integer> {

    int getCurrentValue(int projectId, String type);

    void updateValue(int projectId, String type);
}
