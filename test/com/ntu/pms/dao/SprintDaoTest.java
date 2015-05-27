package com.ntu.pms.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SprintDaoTest extends BaseTest {

    @Autowired
    private SprintDao sprintDao;

    @Test
    public void getCurrnetSprintIdTest() {
        int sprintId = sprintDao.getCurrnetSprintId(2);
        System.out.println(sprintId);
    }
}
