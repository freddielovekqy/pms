package com.ntu.pms.dao;

import java.util.List;

import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.model.ProjectUser;

public interface ProjectUserDao extends BaseDao<ProjectUser, Integer> {

    List<ProjectUserDTO> getProjectUserDTOsByProjectId(int projectId);

    ProjectUserDTO getDTOById(int id);

    void updateMemberPrivilege(int projectUserId, boolean isManager);

    ProjectUserDTO getProjectUserDTO(int projectId, int userId);

    List<ProjectUser> findAllProjectUser();

    List<ProjectUser> findProjectUsersByProject(int projectId);
}
