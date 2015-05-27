package com.ntu.pms.utils;

import com.ntu.pms.dto.ScheduleDTO;
import com.ntu.pms.model.Schedule;

public class ScheduleConverter {

    public static Schedule converterDTOToModel(ScheduleDTO scheduleDTO, Schedule schedule) {
        schedule.setName(scheduleDTO.getName());
        schedule.setDescription(scheduleDTO.getDescription());
        schedule.setStartTime(scheduleDTO.getStartTime());
        schedule.setProjectId(scheduleDTO.getProjectId());
        schedule.setTime(scheduleDTO.getTime());
        schedule.setPlace(scheduleDTO.getPlace());
        schedule.setType(scheduleDTO.getType());
        return schedule;
    }
}
