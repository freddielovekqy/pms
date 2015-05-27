package com.ntu.pms.utils;

import org.apache.commons.lang.StringUtils;

import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.model.Project;

public class ProjectConverter {

    public static Project converterDTOToModel(ProjectDTO projectDTO, Project project, boolean isCover) {
        if (isCover) {
            project.setId(projectDTO.getId());
            project.setName(projectDTO.getName());
            project.setDescription(projectDTO.getDescription());
            project.setState(projectDTO.getState());
            project.setIsPublic(projectDTO.getIsPublic());
        } else {
            if (StringUtils.isNotEmpty(projectDTO.getName())) {
                project.setName(projectDTO.getName());
            }
            if (StringUtils.isNotEmpty(projectDTO.getDescription())) {
                project.setDescription(projectDTO.getDescription());
            }
            project.setState(projectDTO.getState());
        }
        return project;
    }
}
