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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IPERU
 */
public class assessing extends SimpleTagSupport {

    private String value;

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
        try{
        Connection con=null;

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/healthCentres", "root", "");
//         con.createStatement().executeQuery("");
          
              Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("SELECT COUNT(Clinic) FROM vaccinated where Clinic='"+value+"'");
      int entries = 0;
      while(rs.next()){
         //out.println(rs.getString(1));
          entries = Integer.parseInt(rs.getString(1)); 
      }
      out.println(entries+(double)entries/2+"doses recommended");
      if(entries<3){
         // out.println("esss");
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
            }
        catch (java.io.IOException ex) {
            throw new JspException("Error in assessing tag", ex);
        }
    }
        

    public void setValue(String value) {
        this.value = value;
    }
    
}
        
