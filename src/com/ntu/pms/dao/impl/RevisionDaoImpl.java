package com.ntu.pms.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.RevisionDao;
import com.ntu.pms.dto.RevisionDTO;
import com.ntu.pms.model.Revision;

@Repository("revisionDao")
public class RevisionDaoImpl extends BaseDaoImpl<Revision, Integer> implements RevisionDao {

    private static final String SQL_ID_FIND_REVISION_BY_TIME = ".findRevisionByTime";
    private static final String SQL_ID_FIND_LAST_DATE_DYNAMIC = ".findLastDateDynamic";

    @Override
    public List<RevisionDTO> findRevisionByTime(int projectId, Date date) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put("createTime", date);
        return getSqlSession().selectList(Revision.class.getName() + SQL_ID_FIND_REVISION_BY_TIME, map);
    }

    @Override
    public List<RevisionDTO> findLastDateDynamic(int projectId) {
        return getSqlSession().selectList(Revision.class.getName() + SQL_ID_FIND_LAST_DATE_DYNAMIC, projectId);
    }

}
