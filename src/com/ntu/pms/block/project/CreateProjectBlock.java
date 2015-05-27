package com.ntu.pms.block.project;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

import com.ntu.pms.block.BlockAbstract;

@Repository("create_project")
public class CreateProjectBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        // TODO Auto-generated method stub
        template = "/WEB-INF/page/project/create_project.jsp";
    }

}
