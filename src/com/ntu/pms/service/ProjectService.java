package com.ntu.pms.service;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

import com.ntu.pms.dto.ProjectDTO;
import com.ntu.pms.dto.RevisionDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.exception.ValidationException;
import com.ntu.pms.model.Project;

public interface ProjectService {

    Map<String, List<ProjectDTO>> findProjectDTOByUser(int userId);

    ProjectDTO getProjectDTOById(int id) throws BussinessException;

    Project getProjectById(int id) throws BussinessException;

    ProjectDTO updateProject(ProjectDTO projectDTO) throws BussinessException, ServerException, ValidationException;

    ProjectDTO saveProject(ProjectDTO projectDTO, UserDTO userDTO);

    Map<String, Object> getProjectMainPageData(int projectId) throws BussinessException;

    Map<String, List<RevisionDTO>> findProjectDynamic(int projectId);

    List<ProjectDTO> findProjectDTOsByUser(int userId, int currentProjectId);

    ProjectDTO updateProjectUrl(int projectId) throws BussinessException;

    ProjectDTO getProjectByUrl(String url);
}
