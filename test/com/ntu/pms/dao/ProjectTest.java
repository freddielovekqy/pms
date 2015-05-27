package com.ntu.pms.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.model.Project;

public class ProjectTest extends BaseTest {

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void addTest() {
        Project project = new Project();
        project.setName("test");
        project.setCreatorId(1);
        projectDao.add(project);
    }

    @Test
    public void findProjectDTOByUserTest() {
        List<ProjectDTO> projectDTOs = projectDao.findProjectDTOByUser(1);
        for (ProjectDTO projectDTO : projectDTOs) {
            System.out.println(projectDTO.getName());
        }
    }
}
