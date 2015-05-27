package com.ntu.pms.block.ticket;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

import com.ntu.pms.block.BlockAbstract;

@Repository("create_ticket")
public class CreateTicketBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        template = "/WEB-INF/page/ticket/create_ticket.jsp";
    }

}
