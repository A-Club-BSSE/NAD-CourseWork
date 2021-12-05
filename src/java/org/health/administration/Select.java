/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.administration;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hyasmin
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
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        try {
            try{
                Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nad" , "root" , ""); 
             Statement st = con.createStatement();
             
              ResultSet rs = st.executeQuery("SELECT Name from module3 where Name = '"+values+"'");
                int target = 0;// declaring  an interger
              //double population = 20;
             
            //while (ps.next()){
                 //target = Integer.parseInt(ps.getString (1));//we converting an integer into a string to be able to do some 
             // mathematical opertations 
              // out.println(target);
                    
               // out.println(ps.getString (1));
              //  }
            //out.print((target / population) * 100);
                
                
                
              //ResultSet rs = st.executeQuery("select *from module3");
             while (rs.next()){
                
                  out.println("<tr>" + "<br>"  +  rs.getString(1)+"</tr>");
                  out.println("<tr>" +  rs.getString(2)+"</tr>");
                   out.println("<tr>" +  rs.getString(3)+"</tr>");
                    out.println("<tr>" +  rs.getString(4)+"</tr>");
                     out.println("<tr>" +  rs.getString(5)+"</tr>");
                      out.println("<tr>" +  rs.getString(6)+"</tr>");
                 
             }
                 
         
        }
       
          catch(SQLException e){
                 out.println("error"+ e.getMessage());  
                }
        
    
            } 
             catch (ClassNotFoundException e) {
                
                out.println("the error is"+ e.getMessage());
            } 
 

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }


         
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
