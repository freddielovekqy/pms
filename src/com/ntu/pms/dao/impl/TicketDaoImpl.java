package com.ntu.pms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.TicketDao;
import com.ntu.pms.dto.TicketDTO;
import com.ntu.pms.model.Ticket;

@Repository("ticketDao")
public class TicketDaoImpl extends BaseDaoImpl<Ticket, Integer> implements TicketDao {

    private static final String SQL_ID_GET_TICKET_DTO_BY_ID = ".getDTOById";
    private static final String SQL_ID_FIND_TICKET_DTO_BY_SPRINT = ".findTicketDTOBySprint";
    private static final String SQL_ID_FIND_ALL_TICKET_DTO_BY_SPRINT = ".findAllTicketDTOBySprint";
    private static final String SQL_ID_GET_TICKET_COUNT_BY_SPRINT = ".getTicketCountBySprint";
    private static final String SQL_ID_GET_DEFAULT_TICKET = ".getDefaultTicket";
    private static final String SQL_ID_GET_TICKET_SCIENTIFIC = ".getTicketScientific";
    private static final String SQL_ID_MOVE_TICKET_TO_CURRENT_SPRINT = ".moveTicketToCurrentSprnt";
    private static final String SQL_ID_FINISH_ALL_SPRINT_TICKET = ".finishAllSprintTicket";

    @Override
    public TicketDTO getTicketDTOById(int ticketId) {
        return getSqlSession().selectOne(Ticket.class.getName() + SQL_ID_GET_TICKET_DTO_BY_ID, ticketId);
    }

    @Override
    public List<TicketDTO> findTicketDTOsBySprint(int projectId, int sprintId, int pageSize, int startIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        map.put(OtherConstants.PAGE_SIZE, pageSize);
        map.put(OtherConstants.START_INDEX, startIndex);
        List<TicketDTO> ticketDTOs = getSqlSession().selectList(
                Ticket.class.getName() + SQL_ID_FIND_TICKET_DTO_BY_SPRINT, map);
        return ticketDTOs;
    }

    @Override
    public Integer getTicketCountBySprint(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        return getSqlSession().selectOne(Ticket.class.getName() + SQL_ID_GET_TICKET_COUNT_BY_SPRINT, map);
    }

    @Override
    public Ticket getDefaultTicket(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        return getSqlSession().selectOne(Ticket.class.getName() + SQL_ID_GET_DEFAULT_TICKET, map);
    }

    @Override
    public List<TicketDTO> findAllTicketDTOsBySprint(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        return getSqlSession().selectList(Ticket.class.getName() + SQL_ID_FIND_ALL_TICKET_DTO_BY_SPRINT, map);
    }

    @Override
    public Ticket getTicketScientific(int ticketId) {
        return getSqlSession().selectOne(Ticket.class.getName() + SQL_ID_GET_TICKET_SCIENTIFIC, ticketId);
    }

    @Override
    public void moveTicketToCurrentSprnt(int projectId, int sprintId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(EntityConstants.PROJECT_ID, projectId);
        map.put(EntityConstants.SPRINT_ID, sprintId);
        getSqlSession().update(Ticket.class.getName() + SQL_ID_MOVE_TICKET_TO_CURRENT_SPRINT, map);
    }

    @Override
    public void finishAllSprintTicket(int projectId) {
        getSqlSession().update(Ticket.class.getName() + SQL_ID_FINISH_ALL_SPRINT_TICKET, projectId);
    }

}
