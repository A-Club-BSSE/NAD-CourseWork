/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.administration;

import java.io.*;
import java.util.*;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 *
 * @author elijahokello
 */
public class SendEmail extends SimpleTagSupport {

    private String values;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            String [] data = values.split(",");
            // Assuming you are sending email from localhost
            String host = "localhost";
            //Get System Properties
            Properties properties = System.getProperties();
            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties);
            
            try{
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);
         
                // Set From: header field of the header.
                message.setFrom(new InternetAddress("elijahokello90@gmail.com"));
         
                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(data[1]));
         
                // Set Subject: header field
                message.setSubject(data[0]);
         
                // Now set the actual message
                message.setText(data[2]);
                // Send message
                Transport.send(message);
                out.println("<script>window.alert('Sent Email Successfully');</script>");
                    }catch(Exception e){
                        out.println(e);
                    }
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in SendEmail tag", ex);
        }
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
