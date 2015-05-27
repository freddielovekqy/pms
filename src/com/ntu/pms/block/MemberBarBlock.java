package com.ntu.pms.block;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Repository;

@Repository("member_bar")
public class MemberBarBlock extends BlockAbstract {

    @Override
    protected void execute(PageContext pageContext) {
        // TODO Auto-generated method stub
        template = "/WEB-INF/page/common/member_bar.jsp";
    }

}
