package com.ntu.pms.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dao.RevisionDao;
import com.ntu.pms.dao.SequenceDao;
import com.ntu.pms.dao.SprintDao;
import com.ntu.pms.dao.TaskDao;
import com.ntu.pms.dao.TicketDao;
import com.ntu.pms.dto.SprintDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.model.Revision;
import com.ntu.pms.model.Sprint;
import com.ntu.pms.model.Ticket;
import com.ntu.pms.service.BaseService;
import com.ntu.pms.service.SprintService;
import com.ntu.pms.utils.SprintConverter;

@Service("sprintService")
public class SprintServiceImpl extends BaseService implements SprintService {

    @Autowired
    private SprintDao sprintDao;
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private RevisionDao revisionDao;
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private TaskDao taskDao;

    @Override
    public SprintDTO updateSprintEndDate(int sprintId) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        cd.add(Calendar.DATE, 1);
        sprintDao.updateSprintEndDate(sprintId, cd.getTime());
        SprintDTO sprintDTO = this.getSprintDTOById(sprintId);
        return sprintDTO;
    }

    @Override
    public SprintDTO getSprintDTOById(int sprintId) {
        return sprintDao.getSprintDTOById(sprintId);
    }

    @Override
    public List<SprintDTO> findSprintDTOByProject(int projectId) {
        return sprintDao.findSprintDTOByProject(projectId);
    }

    @Override
    public SprintDTO createSprint(SprintDTO sprintDTO, UserDTO userDTO) {
        Sprint sprint = new Sprint();
        // 将迭代DTO转化为后台的迭代对象
        sprint = SprintConverter.converterDTOToModel(sprintDTO, sprint);
        // 获取迭代的索引值
        int serialNumber = sequenceDao.getCurrentValue(sprintDTO.getProjectId(), EntityConstants.TYPE_SPRINT);
        sprint.setSerialNumber(serialNumber + 1);
        sprint.setcreatorId(userDTO.getId());
        sprint.setIsCurrent(true);
        sprintDao.finishOldSprint(sprintDTO.getProjectId());
        sprintDao.add(sprint);

        if (sprintDTO.isMove()) { // 将前一个迭代中所有未完成的功能模块和任务迁移到当前新创建的迭代
            taskDao.moveTaskToCurrentSprint(sprintDTO.getProjectId(), sprint.getId());
            ticketDao.moveTicketToCurrentSprnt(sprintDTO.getProjectId(), sprint.getId());
        } else { // 将前一个迭代中所有未完成的功能模块和任务标记为已完成
            taskDao.finishAllSprintTask(sprintDTO.getProjectId());
            ticketDao.finishAllSprintTicket(sprintDTO.getProjectId());
        }
        sprintDTO = sprintDao.getSprintDTOById(sprint.getId());
        // 创建迭代的默认功能模块
        Ticket ticket = new Ticket(0, OtherConstants.DUFAULT_TICKET, EntityConstants.TYPE_DEFAULT_TICKET,
                sprintDTO.getProjectId(), sprint.getId(), OtherConstants.STATE_CREATED);
        ticketDao.add(ticket);
        // 更新迭代的索引值
        sequenceDao.updateValue(sprintDTO.getProjectId(), EntityConstants.TYPE_SPRINT);
        // 添加日志信息
        Revision revision = new Revision(OtherConstants.REVISION_NEW_SPRINT, sprint.getId(), sprint.getName(),
                EntityConstants.TYPE_SPRINT, sprint.getProjectId(), userDTO.getId());
        revisionDao.add(revision);
        return sprintDTO;
    }

    @Override
    public void updateTicketAndTask(int projectId, int sprintId, boolean isMove) {
        if (isMove) {
            taskDao.moveTaskToCurrentSprint(projectId, sprintId);
            ticketDao.moveTicketToCurrentSprnt(projectId, sprintId);
        } else {
            taskDao.finishAllSprintTask(projectId);
            ticketDao.finishAllSprintTicket(projectId);
        }
    }
}
