package com.ntu.pms.block;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

@Repository("project_simple")
public class ProjectSimpleBlock extends BlockAbstract {

	@Override
	protected void execute(PageContext pageContext) {
		// TODO Auto-generated method stub
		template = "/WEB-INF/page/project/project_simple_block.jsp";
	}

}
