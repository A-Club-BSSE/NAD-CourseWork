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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hyasmin
 */
public class Tagh extends SimpleTagSupport {

    private String table;
    private String values;

        @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            try{
                Class.forName("com.mysql.jdbc.Driver");
//                out.println("sucessfully");
                try{
                    
                  Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nad" , "root" , "");
                    Statement st = con.createStatement();// returns statement object 
                    String[] newValues = values.split(",");
         if(newValues.length > 1){
//     st.execute("insert into module3 (Name,NIN,Healthcentre,Date,Batchnumber,Vaccinetype)values('""');");

     st.executeUpdate("insert into module3 set Name='"+newValues[0]+"',NIN='"+newValues[1]+"' ,Healthcentre='"+newValues[2]+"'"
                            + " ,Date='"+newValues[3]+"',Batchnumber='"+newValues[4]+"',Vaccinetype='"+newValues[5]+"'"
                           );
                                    
                      out.println("successfully printed");
                      out.println("<script type='text/javascript'> window.location = 'index.jsp';</script>");
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
            throw new JspException("Error in Tagh tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setValues(String values) {
        this.values = values;
    }
      
    
}
