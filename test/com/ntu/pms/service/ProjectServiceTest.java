package com.ntu.pms.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntu.pms.dao.BaseTest;
import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.exception.BussinessException;

public class ProjectServiceTest extends BaseTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void findProjectDynamicTest() {
        projectService.findProjectDynamic(3);
    }

    @Test
    public void getProjectMainPageDataTest() throws BussinessException {
        projectService.getProjectMainPageData(3);
    }

    @Test
    public void findProjectDTOsByUserTest() {
        List<ProjectDTO> projectDTOs = projectService.findProjectDTOsByUser(1, 3);
        for (ProjectDTO projectDTO : projectDTOs) {
            System.out.println(projectDTO.getName() + "-------------------");
        }
    }
}
