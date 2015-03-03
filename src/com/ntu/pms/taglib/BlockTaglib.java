package com.ntu.pms.taglib;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.ntu.pms.block.BlockAbstract;
import com.ntu.pms.utils.SpringUtil;

public class BlockTaglib extends TagSupport {

    private static final long serialVersionUID = -3600035804653408819L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        BlockAbstract blockAbstract = (BlockAbstract) SpringUtil.getBean(name);
        String html = null;
        try {
            html = blockAbstract.displayBlock(pageContext);
        } catch (ServletException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            out.print(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }
}
