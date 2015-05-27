package com.ntu.pms.service;

import java.util.List;

import com.ntu.pms.dto.ScheduleDTO;
import com.ntu.pms.dto.UserDTO;

public interface ScheduleService {

    List<ScheduleDTO> findScheduleDTOsByProjectId(int projectId, UserDTO userDTO);

    ScheduleDTO getScheduleDTOById(int scheduleId);

    ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO, UserDTO userDTO);

    ScheduleDTO updateSchedule(ScheduleDTO scheduleDTO);

    ScheduleDTO deleteSchedule(int scheduleId);
}
