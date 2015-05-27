package com.ntu.pms.block;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

@Repository("project_menu")
public class ProjectMenuBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        // TODO Auto-generated method stub
        template = "/WEB-INF/page/project/project_menu.jsp";
    }

}
