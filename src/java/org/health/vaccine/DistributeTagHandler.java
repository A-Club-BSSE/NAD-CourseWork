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
public class DistributeTagHandler extends SimpleTagSupport {

    private String Quantity;
    private String table;


    

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            
             try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Driver started successfully
             try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccines","root","");
               
                Statement st = conn.createStatement();
                
               String[] Values = Quantity.split(",");
               if(Values.length > 1){ 
                   
//               st.execute("insert into "+table+" set date = '"+newValues[0]+"',"
//                        + "VaccineType='"+newValues[1]+"',status='"+newValues[2]+"',"
//                                + "Amount='"+newValues[3]+"'");
               st.execute("insert into hospitals (date,VaccineType,status,Amount)values('"+Values[0]+"','"+Values[1]+"','"+Values[2]+"','"+Values[3]+"');");
         
               out.println("<script type='text/javascript'>alert('Data inserted');</script>");
               
               }
               
                
                
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
            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in DistributeTagHandler tag", ex);
        }
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
    
}
