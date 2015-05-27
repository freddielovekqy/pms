package com.ntu.pms.service;

import java.util.List;
import java.util.Map;

import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.model.ProjectUser;

public interface ProjectUserService {

    List<ProjectUserDTO> getProjectUserDTOsByProjectId(int projectId);

    ProjectUserDTO addProjectMember(int userId, int projectId);

    ProjectUserDTO removeProjectMember(int projectUserid);

    ProjectUserDTO updateMemberPrivilege(int projectUserId, boolean isManager);

    ProjectUserDTO validateManager(int projectId, UserDTO userDTO);

    Map<Integer, List<ProjectUser>> findAllProjectUser();
}
