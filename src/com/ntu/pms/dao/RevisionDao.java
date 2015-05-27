package com.ntu.pms.dao;

import java.util.Date;
import java.util.List;

import com.ntu.pms.dto.RevisionDTO;
import com.ntu.pms.model.Revision;

public interface RevisionDao extends BaseDao<Revision, Integer> {

    List<RevisionDTO> findRevisionByTime(int projectId, Date date);

    List<RevisionDTO> findLastDateDynamic(int projectId);
}
