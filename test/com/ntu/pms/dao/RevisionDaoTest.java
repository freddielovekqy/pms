package com.ntu.pms.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntu.pms.dto.RevisionDTO;

public class RevisionDaoTest extends BaseTest {

    @Autowired
    private RevisionDao revisionDao;

    @Test
    public void findLastDateDynamicTest() {
        List<RevisionDTO> list = revisionDao.findLastDateDynamic(2);
        for (RevisionDTO revisionDTO : list) {
            System.out.println(revisionDTO.getCreateTime());
            System.out.println(revisionDTO.getCreateDayTime());
            System.out.println(revisionDTO.getCreateDate());
        }
    }

    @Test
    public void findRevisionByTimeTest() {
        List<RevisionDTO> list = revisionDao.findRevisionByTime(2, new Date());
        for (RevisionDTO revisionDTO : list) {
            System.out.println(revisionDTO.getCreateTime());
            System.out.println(revisionDTO.getCreateDayTime());
            System.out.println(revisionDTO.getCreateDate());
        }
    }
}
