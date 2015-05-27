package com.ntu.pms.block.sprint;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

import com.ntu.pms.block.BlockAbstract;

@Repository("create_sprint")
public class CreateSprintBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        template = "/WEB-INF/page/sprint/create_sprint.jsp";
    }

}
