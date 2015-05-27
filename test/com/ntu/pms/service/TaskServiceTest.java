package com.ntu.pms.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntu.pms.dao.BaseTest;

public class TaskServiceTest extends BaseTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void getTaskChartDataTest() {
        Map<String, List<Object>> map = taskService.getTaskChartData(2);
        System.out.println(map);
    }
}
