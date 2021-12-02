package org.health.administration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import static jakarta.servlet.jsp.tagext.Tag.SKIP_BODY;
import jakarta.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 *
 * @author elijahokello
 */
public class RegisterTagHandler extends TagSupport {

    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
     * @return 
     * @throws jakarta.servlet.jsp.JspException
     */
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        
        try{
            out.println("Hi this is Elijah");
        }catch(IOException e){
            System.out.println(e);
        }
        
        return SKIP_BODY;
    }
}
