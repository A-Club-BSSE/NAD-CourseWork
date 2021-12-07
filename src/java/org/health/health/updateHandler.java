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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IPERU
 */
public class updateHandler extends SimpleTagSupport {
    Connecting conn=new Connecting();

    private String table;
    private String newvalue;
    private String where;

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
            try{
                Connection newConn = conn.getMyConnection();
                Statement st= newConn.createStatement();
                String [] value= newvalue.split(",");
                if(value.length>1){
                   st.executeUpdate("UPDATE hospitals SET Name='"+value[0]+"',Location='"+value[1]+"' WHERE Id='"+where+"';");
                   out.println("<script type='text/javascript'>window.location='index.jsp'</script>");
                }
                
                
//                out.println(value[1]);
//                while(rs.next()){
//                    out.print(rs.getString(1));
//                    out.print(rs.getString(2));
//                }
//                
            }catch(SQLException e){
                        out.print("the error is "+e.getMessage());
                    }
            }catch(ClassNotFoundException e){
                out.print("the error is "+e.getMessage());
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
            throw new JspException("Error in updateHandler tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue;
    }

    public void setWhere(String where) {
        this.where = where;
    }
    
}
