package com.ntu.pms.block.ticket;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

import com.ntu.pms.block.BlockAbstract;

@Repository("edit_ticket")
public class EditTicketBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        template = "/WEB-INF/page/ticket/edit_ticket.jsp";
    }

}
