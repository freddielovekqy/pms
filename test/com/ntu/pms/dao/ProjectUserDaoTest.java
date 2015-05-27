package com.ntu.pms.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntu.pms.dto.ProjectUserDTO;

public class ProjectUserDaoTest extends BaseTest {

    @Autowired
    private ProjectUserDao projectUserDao;

    @Test
    public void getProjectUserDTOByProjectIdTest() {
        List<ProjectUserDTO> projectUserDTOs = projectUserDao.getProjectUserDTOsByProjectId(2);
        for (ProjectUserDTO projectUserDTO : projectUserDTOs) {
            System.out.println(projectUserDTO.getUserName());
        }
    }
}
