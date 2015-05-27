package com.ntu.pms.block.task;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

import com.ntu.pms.block.BlockAbstract;

@Repository("edit_task")
public class EditTaskBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        // TODO Auto-generated method stub
        template = "/WEB-INF/page/task/edit_task.jsp";
    }

}
