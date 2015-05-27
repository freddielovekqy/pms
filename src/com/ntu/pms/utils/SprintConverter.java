package com.ntu.pms.utils;

import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.model.Sprint;

public class SprintConverter {

    public static Sprint converterDTOToModel(SprintDTO sprintDTO, Sprint sprint) {
        sprint.setName(sprintDTO.getName());
        sprint.setDescription(sprintDTO.getDescription());
        sprint.setIsCurrent(sprintDTO.getIsCurrent());
        sprint.setEndDate(sprintDTO.getEndDate());
        sprint.setcreatorId(sprintDTO.getCreatorId());
        sprint.setStartDate(sprintDTO.getStartDate());
        sprint.setProjectId(sprintDTO.getProjectId());
        sprint.setState(sprintDTO.getState());
        return sprint;
    }
}
