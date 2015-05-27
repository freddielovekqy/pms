package com.ntu.pms.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dao.RevisionDao;
import com.ntu.pms.dao.SequenceDao;
import com.ntu.pms.dao.SprintDao;
import com.ntu.pms.dao.TaskDao;
import com.ntu.pms.dao.TicketDao;
import com.ntu.pms.dto.Pagination;
import com.ntu.pms.dto.TicketDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.model.Revision;
import com.ntu.pms.model.Sprint;
import com.ntu.pms.model.Ticket;
import com.ntu.pms.service.TicketService;
import com.ntu.pms.utils.TicketConverter;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private SprintDao sprintDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private RevisionDao revisionDao;

    @Override
    public Pagination findTicketDTOsBySprint(int projectId, int sprintId, int pageIndex) {
        Pagination pagination = new Pagination();
        int count = ticketDao.getTicketCountBySprint(projectId, sprintId);
        int startIndex = (pageIndex - 1) * pagination.getPageSize();
        pagination.setTotalCount(count);
        pagination.setCurrentPage(pageIndex);
        pagination.setStartIndex(startIndex);

        List<TicketDTO> ticketDTOs = ticketDao.findTicketDTOsBySprint(projectId, sprintId, pagination.getPageSize(),
                startIndex);
        pagination.setList(ticketDTOs);
        return pagination;
    }

    @Override
    public Pagination findCurrentSprintTicketDTOs(int projectId) {
        int sprintId = sprintDao.getCurrnetSprintId(projectId);
        Pagination pagination = this.findTicketDTOsBySprint(projectId, sprintId, OtherConstants.FIRST_PAGE);
        return pagination;
    }

    @Override
    public TicketDTO deleteTicket(int projectId, int sprintId, int ticketId, boolean isCascade)
            throws BussinessException {
        TicketDTO ticketDTO = this.getTicketDTOById(ticketId);
        ticketDao.delete(ticketId);

        if (isCascade) {
            taskDao.deleteTaskByTicket(projectId, ticketId);
        } else {
            Ticket defaultTicket = ticketDao.getDefaultTicket(projectId, sprintId);
            taskDao.updateTaskWhenTicketDeleted(projectId, sprintId, ticketId, defaultTicket.getId());
        }
        return ticketDTO;
    }

    @Override
    public TicketDTO getTicketDTOById(int ticketId) throws BussinessException {
        TicketDTO ticketDTO = ticketDao.getTicketDTOById(ticketId);
        if (ticketDTO == null || !ticketDTO.getIsActive()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(EntityConstants.OBJECT_TYPE, EntityConstants.TICKET_DTO);
            map.put(EntityConstants.OBJECT_ID, ticketId);
            throw new BussinessException("订单不存在或订单已被删除.", map);
        }
        return ticketDTO;
    }

    @Override
    public List<TicketDTO> findAllTicketDTOsBySprint(int projectId, int sprintId) {
        return ticketDao.findAllTicketDTOsBySprint(projectId, sprintId);
    }

    @Override
    public void updateTicketScientific(int ticketId) {
        Ticket ticket = ticketDao.getById(ticketId);
        Ticket ticketScientific = ticketDao.getTicketScientific(ticketId);
        boolean isTaskBlocked = taskDao.getBlockedTaskCountByTicket(ticketId);
        ticket.setTaskEst(ticketScientific.getTaskEst());
        ticket.setTodo(ticketScientific.getTodo());
        ticket.setBlocked(isTaskBlocked);

        if (ticketScientific.getTodo() == 0.0) {
            ticket.setState("完成");
        } else {
            ticket.setState("正在工作");
        }
        ticketDao.update(ticket);
    }

    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketDao.getById(ticketDTO.getId());
        ticket = TicketConverter.converterDTOToModel(ticketDTO, ticket);
        ticketDao.update(ticket);
        if (OtherConstants.STATE_COMPLETED.equals(ticket.getState())) {
            taskDao.finishedAllTaskInTicket(ticket.getProjectId(), ticket.getId());
        }
        return ticketDTO;
    }

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO, UserDTO userDTO) {
        Ticket ticket = new Ticket();
        ticket = TicketConverter.converterDTOToModel(ticketDTO, ticket);
        Sprint sprint = sprintDao.getById(ticketDTO.getSprintId());
        int serialNumber = sequenceDao.getCurrentValue(sprint.getProjectId(), ticketDTO.getType());
        ticket.setSerialNumber(serialNumber + 1);
        ticket.setCreateTime(new Date());
        ticket.setCreatorId(userDTO.getId());
        ticket.setProjectId(sprint.getProjectId());
        ticketDao.add(ticket);

        sequenceDao.updateValue(sprint.getProjectId(), ticketDTO.getType());
        Revision revision = new Revision(OtherConstants.REVISION_NEW_TICKET, ticket.getId(), ticket.getName(),
                ticket.getType(), ticket.getProjectId(), userDTO.getId());
        revisionDao.add(revision);

        ticketDTO = ticketDao.getTicketDTOById(ticket.getId());
        return ticketDTO;
    }
}
