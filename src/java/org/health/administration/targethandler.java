/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.administration;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hyasmin
 */
public class targethandler extends SimpleTagSupport {
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
                Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nad" , "root" , ""); 
             Statement st = con.createStatement();
             
              ResultSet ps = st.executeQuery("SELECT COUNT(name) from module3");
              int target = 0;// declaring  an interger
              double population = 110.0;
             
            while (ps.next()){
                 target = Integer.parseInt(ps.getString (1));//we converting an integer into a string to be able to do some 
             // mathematical opertations 
              // out.println(target);
                    
               // out.println(ps.getString (1));
                }
            out.print(90 - (target / population) * 100 + "%" );
            
            // ResultSet rs = st.executeQuery("select *from module3");
            // while (rs.next()){
                
                // out.println("<tr>" + "<br>"  +  rs.getString(1)+"</tr>");
                 //out.println("<tr>" +  rs.getString(2)+"</tr>");
                 
             
                 
         
        }
       
          catch(SQLException e){
                 out.println("error"+ e.getMessage());  
                }
        
    
            } 
             catch (ClassNotFoundException e) {
                
                out.println("the error is"+ e.getMessage());
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
            throw new JspException("Error in targethandler tag", ex);
        }
    }
     public void setTable(String table) {
        this.table = table;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}

