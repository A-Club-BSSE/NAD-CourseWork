/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.health.vaccine;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class gettingdataHandler extends SimpleTagSupport {

    private String totalvaccine;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        //out.println("hello");
        
        
        try {
               try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
             try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccines","root","");
               
                Statement st = conn.createStatement();
                String Sum = "select sum(Amount) from inventory";
                
               
               ResultSet rs = st.executeQuery(Sum);
               rs.next();
               
               int totalInventory = rs.getInt(1);
               out.println("Total Inventory:"+ totalInventory);
               //out.println("hello wor");
               
                  }catch(SQLException e){
                    out.println("<br>There is an error:: "+ e.getMessage());
                }
              }catch(ClassNotFoundException e){          
                out.println("<br><br>loading the driver has result to an error:: "+e.getMessage());
            }



              
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in gettingdataHandler tag", ex);
        }
    }

    public void setTotalvaccine(String totalvaccine) {
        this.totalvaccine = totalvaccine;
    }
    
}
