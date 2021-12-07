/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.health;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.Connection;

/**
 *
 * @author IPERU
 */
public class module1 extends SimpleTagSupport {
    Connecting conn = new Connecting();


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
            //Class.forName("com.mysql.jdbc.Driver");
          //  out.println("the driver has loaded successfully");
                        
            try{
           //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthCentres", "root", "");
            // Statement st= con.createStatement();
             //String n=  getParameter("name");
            //String l=getParameter("location");
                Connection newConn = conn.getMyConnection();
                Statement st= newConn.createStatement();
                
          
            
            String [] newValues = values.split(",");
            
             st.executeUpdate("insert into `hospitals` set Name='"+newValues[0]+"',Location='"+newValues[1]+"',Email='"+newValues[2]+"'");
             
            // out.println("successfully inserted ");
             out.println("<script type='text/javascript'>window.location='healthcentre.jsp'</script>");
             
            
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
            throw new JspException("Error in module1 tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
