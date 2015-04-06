package com.ntu.pms.service;

import java.util.List;
import java.util.Map;

import com.ntu.pms.dto.ProjectDTO;

public interface ProjectService {

    Map<String, List<ProjectDTO>> findProjectDTOByUser(int userId);
}
