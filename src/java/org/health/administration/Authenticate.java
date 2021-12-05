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
public class Authenticate extends SimpleTagSupport {

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
            out.println(values);
            String[] data = values.split(",");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination", "root", "")) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Persons WHERE Email='" + data[0] +"'");
//                    " + data[0] +"'
                    boolean email = false;
                    String emailContent = "";
                    String passwordContent = "";
                    while(rs.next()){
                        passwordContent = rs.getString(8);
                        out.println("Working");
                        emailContent = rs.getString(7);
                        email = true;
                    }
                    out.println("DB PASS: "+ passwordContent);
                    out.println("INPUT: "+ data[1]);
                    if(email){
                        if(data[1].equals(passwordContent)){
                            out.println("<script> window.location.href = 'http://localhost:8080/Vaccine_Admin_Tracker/'</script>");
                        }else{
                            out.println("<script>window.alert('Wrong Password. Try Again!');</script>");
                            out.println("<script> window.location.href = 'http://localhost:8080/Vaccine_Admin_Tracker/signin'</script>");                            
                        }
                    }else{
                        out.println("<script> window.alert('Account Doesnt exist');</script>");
                        out.println("<script> window.location.href = 'http://localhost:8080/Vaccine_Admin_Tracker/RegisterPage'</script>");
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
            throw new JspException("Error in Authenticate tag", ex);
        }
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
