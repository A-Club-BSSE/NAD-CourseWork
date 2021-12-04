/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.administration;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elijahokello
 */
public class RegisterUsers extends SimpleTagSupport {

    private String values;

    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
     * @throws jakarta.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            String[] data = values.split(",");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination", "root", "")) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("INSERT INTO Persons ('" + data[0] +"','" + data[1] +"')");
                    while(rs.next()){
                        out.println(rs.getString(1) + " " + rs.getString(2));
                    }
                }
            } catch (SQLException e) {
                out.println(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegisterUsers.class.getName()).log(Level.SEVERE, null, ex);
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
            throw new JspException("Error in RegisterUsers tag", ex);
        }
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
