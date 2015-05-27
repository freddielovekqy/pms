package com.ntu.pms.service;

import java.util.List;

import com.ntu.pms.dto.Pagination;
import com.ntu.pms.dto.TicketDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;

public interface TicketService {
    Pagination findTicketDTOsBySprint(int projectId, int sprintId, int pageIndex);

    List<TicketDTO> findAllTicketDTOsBySprint(int projectId, int sprintId);

    Pagination findCurrentSprintTicketDTOs(int projectId);

    TicketDTO deleteTicket(int project, int sprintId, int ticketId, boolean isCascade) throws BussinessException;

    TicketDTO getTicketDTOById(int ticketId) throws BussinessException;

    void updateTicketScientific(int ticketId);

    TicketDTO updateTicket(TicketDTO ticketDTO);

    TicketDTO saveTicket(TicketDTO ticketDTO, UserDTO userDTO);
}
