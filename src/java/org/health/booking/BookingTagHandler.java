/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.booking;

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
 * @author Joanita
 */
public class BookingTagHandler extends SimpleTagSupport {
    private String table;
    private String values;
    //private String []data;
   
    public void setValues(String values){
        this.values = values;
        
    }
    public void setTable(String table){
        this.table = table;
        
    }
    

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
             String[] arr = values.split(",");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","");
                    Statement st = conn.createStatement();
                    if(arr.length >1){
                    st.execute("insert into " +table+"(Name,Date,Time,PlaceOfPreference )values('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"');");
                    out.print("<script type ='text/javascript'>alert('Dear "+arr[0]+", your booking has been saved')</script>");
                    
                    }
                    
                } catch (SQLException ex){
                    out.println("Error"+ ex.getMessage());
                }
            }catch (ClassNotFoundException ex){
                out.println("Error" + ex.getMessage());
            }
            
//            String []data = values.split(",");
//            out.println(data[0]);
//            out.println(data[1]);
//            out.println(data[2]);
//            out.println(data[3]);
////                  out.println(values);
            
            
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
            throw new JspException("Error in BookingTagHandler tag", ex);
        }
    }
    
   
    
}
