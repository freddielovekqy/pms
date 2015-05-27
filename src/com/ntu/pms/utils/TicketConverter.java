package com.ntu.pms.utils;

import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.dto.TicketDTO;
import com.ntu.pms.model.Ticket;

public class TicketConverter {

    public static Ticket converterDTOToModel(TicketDTO ticketDTO, Ticket ticket) {
        ticket.setName(ticketDTO.getName());
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setOwnerId(ticketDTO.getOwnerId());
        ticket.setSprintId(ticketDTO.getSprintId());
        ticket.setType(ticketDTO.getType());
        ticket.setBlocked(ticketDTO.getBlocked());
        ticket.setPlanEst(ticketDTO.getPlanEst());
        ticket.setState(ticketDTO.getState());
        if (OtherConstants.STATE_COMPLETED.equals(ticket.getState())) {
            ticket.setBlocked(false);
            ticket.setTodo(0);
        }
        return ticket;
    }
}
