package com.ntu.pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.SequenceDao;
import com.ntu.pms.model.Sequence;
import com.ntu.pms.service.SequenceService;

@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceDao sequenceDao;

    @Override
    public void addProjectSequence(int projectId) {
        Sequence sequence = new Sequence();
        sequence.setProjectId(projectId);
        sequence.setCurrentValue(0);
        sequence.setType(EntityConstants.TYPE_SPRINT);
        sequenceDao.add(sequence);
        sequence.setType(EntityConstants.TYPE_TASK);
        sequenceDao.add(sequence);
        sequence.setType(EntityConstants.TYPE_US);
        sequenceDao.add(sequence);
        sequence.setType(EntityConstants.TYPE_DE);
        sequenceDao.add(sequence);
    }
}
