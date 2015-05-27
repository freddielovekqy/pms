package com.ntu.pms.dao;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskDaoTest extends BaseTest {

    @Autowired
    private TaskDao taskDao;

    @Test
    public void getTaskCountBySprintTest() {
        int count = taskDao.getTaskCountBySprint(2, 2);
        System.out.println(count);
    }

    @Test
    public void getTaskChartDataTest() {
        Date date = new Date();
        Map<String, Map<String, Long>> map = taskDao.getTaskChartData(2, date);
        Set<String> s = map.keySet();
        for (Object object : s) {
            System.out.println(object);
        }
    }
}
