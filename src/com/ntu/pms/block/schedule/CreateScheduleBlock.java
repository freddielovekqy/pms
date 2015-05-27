package com.ntu.pms.block.schedule;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

import com.ntu.pms.block.BlockAbstract;

@Repository("create_schedule")
public class CreateScheduleBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        // TODO Auto-generated method stub
        template = "/WEB-INF/page/schedule/create_schedule.jsp";
    }

}
