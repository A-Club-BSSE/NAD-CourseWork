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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class InventoryRegister extends SimpleTagSupport {

    private String table;
    private String values;

  
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            try{
            Class.forName("com.mysql.jdbc.Driver");
//              out.println("driver loaded");
               try{
                 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccines","root","");
                 
                Statement st= conn.createStatement();
              
                String[] newValues = values.split(",");
               if(newValues.length > 1){ 
                   
//               st.execute("insert into "+table+" set date = '"+newValues[0]+"',"
//                        + "VaccineType='"+newValues[1]+"',status='"+newValues[2]+"',"
//                                + "Amount='"+newValues[3]+"'");
               st.execute("insert into inventory (date,VaccineType,status,Amount)values('"+newValues[0]+"','"+newValues[1]+"','"+newValues[2]+"','"+newValues[3]+"');");
         
               out.println("<script type='text/javascript'>alert('Data inserted');</script>");
               
               }
               
               
            
            }catch (SQLException e){
                out.println("SQL error :"+ e.getMessage());
            } 
               
           } catch (ClassNotFoundException ex) {
                out.println("Driver error is"+ ex.getMessage() );
         }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in InventoryRegister tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
