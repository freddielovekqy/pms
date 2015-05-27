package com.ntu.pms.dao;

import java.util.List;

import com.ntu.pms.dto.TicketDTO;
import com.ntu.pms.model.Ticket;

public interface TicketDao extends BaseDao<Ticket, Integer> {

    TicketDTO getTicketDTOById(int ticketId);

    List<TicketDTO> findTicketDTOsBySprint(int projectId, int sprintId, int pageSize, int startIndex);

    List<TicketDTO> findAllTicketDTOsBySprint(int projectId, int sprintId);

    Integer getTicketCountBySprint(int projectId, int sprintId);

    Ticket getDefaultTicket(int projectId, int sprintId);

    Ticket getTicketScientific(int ticketId);

    void moveTicketToCurrentSprnt(int projectId, int sprintId);

    void finishAllSprintTicket(int projectId);
}
