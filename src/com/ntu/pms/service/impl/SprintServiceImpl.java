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
        // ������DTOת��Ϊ��̨�ĵ�������
        sprint = SprintConverter.converterDTOToModel(sprintDTO, sprint);
        // ��ȡ����������ֵ
        int serialNumber = sequenceDao.getCurrentValue(sprintDTO.getProjectId(), EntityConstants.TYPE_SPRINT);
        sprint.setSerialNumber(serialNumber + 1);
        sprint.setcreatorId(userDTO.getId());
        sprint.setIsCurrent(true);
        sprintDao.finishOldSprint(sprintDTO.getProjectId());
        sprintDao.add(sprint);

        if (sprintDTO.isMove()) { // ��ǰһ������������δ��ɵĹ���ģ�������Ǩ�Ƶ���ǰ�´����ĵ���
            taskDao.moveTaskToCurrentSprint(sprintDTO.getProjectId(), sprint.getId());
            ticketDao.moveTicketToCurrentSprnt(sprintDTO.getProjectId(), sprint.getId());
        } else { // ��ǰһ������������δ��ɵĹ���ģ���������Ϊ�����
            taskDao.finishAllSprintTask(sprintDTO.getProjectId());
            ticketDao.finishAllSprintTicket(sprintDTO.getProjectId());
        }
        sprintDTO = sprintDao.getSprintDTOById(sprint.getId());
        // ����������Ĭ�Ϲ���ģ��
        Ticket ticket = new Ticket(0, OtherConstants.DUFAULT_TICKET, EntityConstants.TYPE_DEFAULT_TICKET,
                sprintDTO.getProjectId(), sprint.getId(), OtherConstants.STATE_CREATED);
        ticketDao.add(ticket);
        // ���µ���������ֵ
        sequenceDao.updateValue(sprintDTO.getProjectId(), EntityConstants.TYPE_SPRINT);
        // �����־��Ϣ
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
