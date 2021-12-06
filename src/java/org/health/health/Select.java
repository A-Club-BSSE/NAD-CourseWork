/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.health;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IPERU
 */
public class Select extends SimpleTagSupport {

    private String table;
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
            
             try{   
        Class.forName("com.mysql.jdbc.Driver"); 
        //out.println("accessed");
        Connection con=null;
        try{
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthCentres", "root", "");
//         con.createStatement().executeQuery("");
        Statement st= con.createStatement();
       ResultSet ps =st.executeQuery("select * from hospitals");
      
        while(ps.next()){
            
           out.println("<tr>");
            out.println("<td>" +ps.getString(1) +"</td>");
            //out.println("<th>"+"Location"+"</th>");
            out.println("<td>" +ps.getString(2) +"</td>");
            out.println("<td>" +ps.getString(3) +"</td>");
            out.println("</tr>");
           
      }
        }catch(SQLException e){
                        out.print("the error is "+e.getMessage());
                    }
                    
      
    }catch(ClassNotFoundException e){
                out.print("the error is "+e.getMessage());
                       
            }; 
            
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Select tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
