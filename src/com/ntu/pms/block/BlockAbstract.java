package com.ntu.pms.block;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

public abstract class BlockAbstract {

    public String template;

    public String displayBlock(PageContext pageContext) throws ServletException, IOException {
        execute(pageContext);
        Writer body = new StringWriter();

        if (template != null && !template.trim().equals("")) {
            pageContext.pushBody(body);
            pageContext.include(template);
            pageContext.popBody();
            return body.toString();
        }
        body.close();
        return "";
    }

    protected abstract void execute(PageContext pageContext);

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
