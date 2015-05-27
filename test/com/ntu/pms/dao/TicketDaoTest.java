package com.ntu.pms.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntu.pms.dto.TicketDTO;

public class TicketDaoTest extends BaseTest {

    @Autowired
    private TicketDao ticketDao;

    @Test
    public void findTicketDTOBySprintTest() {
        int projectId = 2;
        int sprintId = 2;
        List<TicketDTO> ticketDTOs = ticketDao.findTicketDTOsBySprint(projectId, sprintId, 5, 1);
        for (TicketDTO ticketDTO : ticketDTOs) {
            System.out.println(ticketDTO.getBlocked());
        }
    }
}
