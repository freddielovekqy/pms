package com.ntu.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.dao.ProjectUserDao;
import com.ntu.pms.dao.ScheduleDao;
import com.ntu.pms.dto.ProjectUserDTO;
import com.ntu.pms.dto.ScheduleDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.model.Schedule;
import com.ntu.pms.service.BaseService;
import com.ntu.pms.service.ScheduleService;
import com.ntu.pms.utils.ScheduleConverter;

@Service("scheduleService")
public class ScheduleServiceImpl extends BaseService implements ScheduleService {

    @Autowired
    private ProjectUserDao projectUserDao;
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public List<ScheduleDTO> findScheduleDTOsByProjectId(int projectId, UserDTO userDTO) {
        List<ProjectUserDTO> projectUserDTOs = projectUserDao.getProjectUserDTOsByProjectId(projectId);
        List<ScheduleDTO> scheduleDTOs = null;
        for (ProjectUserDTO projectUserDTO : projectUserDTOs) {
            if (projectUserDTO.getUserId() == userDTO.getId() && projectUserDTO.getIsManager()) {
                scheduleDTOs = scheduleDao.findAllScheduleDTOsByProjectId(projectId);
                break;
            }
        }
        if (scheduleDTOs == null) {
            scheduleDTOs = scheduleDao.findUnfinishedScheduleDTOsByProjectId(projectId);
        }
        return scheduleDTOs;
    }

    @Override
    public ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO, UserDTO userDTO) {
        Schedule schedule = new Schedule();
        schedule = ScheduleConverter.converterDTOToModel(scheduleDTO, schedule);
        schedule.setCreatorId(userDTO.getId());
        scheduleDao.add(schedule);
        scheduleDTO = scheduleDao.getDTOById(schedule.getId());
        return scheduleDTO;
    }

    @Override
    public ScheduleDTO updateSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleDao.getById(scheduleDTO.getId());
        schedule = ScheduleConverter.converterDTOToModel(scheduleDTO, schedule);
        scheduleDao.update(schedule);
        scheduleDTO = scheduleDao.getDTOById(schedule.getId());
        return scheduleDTO;
    }

    @Override
    public ScheduleDTO deleteSchedule(int scheduleId) {
        ScheduleDTO scheduleDTO = scheduleDao.getDTOById(scheduleId);
        scheduleDao.delete(scheduleId);
        return scheduleDTO;
    }

    @Override
    public ScheduleDTO getScheduleDTOById(int scheduleId) {
        ScheduleDTO scheduleDTO = scheduleDao.getDTOById(scheduleId);
        return scheduleDTO;
    }
}
