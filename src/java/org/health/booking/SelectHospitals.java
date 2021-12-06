/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.booking;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class SelectHospitals extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
             out.println("<strong>Hllo</strong>");
            // out.println("    <blockquote>");

            String[] hospitals = {"Mulago", "Nsambya", "Lyantonde", "Soroti", "Gulu"};
            for (int i = 0; i < 5; i++) {
                String hospital = hospitals[i];
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "");
//                       out.println("11");
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery("SELECT COUNT(Name) as total FROM `vaccination` WHERE PlaceOfPreference = '" + hospital + "'");
                        rs.next();
                        String total = rs.getString("total");
                        out.println("<option value = " + hospital + ">" + hospital + " Hospital Booked by " + total + "</option>");

                        out.println(rs.getString(1));

                    } catch (SQLException ex) {
                        out.println("Error" + ex.getMessage());
                    }
                } catch (ClassNotFoundException ex) {
                    out.println("Error" + ex.getMessage());
                }
            }
//<option value = "Mulago">Mulago Hospital</option>
//                    <option value = "Nsambya">Nsambya Hospital</option>
//                    <option value = "Lyantonde">Lyantonde Hospital</option>
//                    <option value = "Soroti ">Soroti Hospital</option>
//                    <option value = "Gulu ">Gulu Hospital</option>

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in GetTagHandler tag", ex);
        }

    }
    
}
