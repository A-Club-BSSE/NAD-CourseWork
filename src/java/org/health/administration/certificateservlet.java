package org.health.administration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hyasmin
 */
public class certificateservlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet certificateservlet</title>"); 
            out.println("<style>\n" +
"            body{\n" +
"                display:flex;\n" +
"                flex-direction: column;\n" +
"                justify-content:center;\n" +
"                align-items:center;\n" +
"            }\n" +
"         </style>");
            out.println("</head>");
            out.println("<body>");
            Cookie[] cookies = request.getCookies();
          for(Cookie cook : cookies){
             if(cook.getName().equals("newCoookie")){
                 String value = cook.getValue();
                 displayCertificateservlet(value,out);
             }
          }
            out.println("<button onclick='window.print();'>Print Now</button>");
            
            out.println("</body>");
            out.println("</html>");
           out.println("</body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
   private void displayCertificateservlet(String patient,PrintWriter out){
      try{
            Class.forName("com.mysql.jdbc.Driver");
       try{
       Connection con  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/nad","root","");
     Statement state = con.createStatement();
   ResultSet set = state.executeQuery("select * from module3 where Name='"+patient+"';");
   /*out.println(" <div class=\"card w-60 card-profile\">\n" +
"           <div class=\"card-body\">\n" +
"       // <div class=\"table-responsive\">\n");*/

 while(set.next()){
       out.println(
"        <table class=\"table\">\n" +
"            <thead>\n" +
"                <tr>\n" +
"                    <th colspan=\"\">\n" +

"                <br><!-- added logo -->\n" +
"                <img src=\"./download.jpeg\" alt=\"courtofarms.jpeg\"/>\n"
        + "<p><b>GOVERNMENT OF UGANDA</b></p>" +
        "            <center>\n" +
"                <p class=\"text-2xl\"> COVID-19 VACCINATION CERTIFICATE</p>\n" +
           "            <center>\n" +
"                <p class=\"text-2xl\">This is to certify that this person has been vaccinated</p>\n" +
        
        
"            </center>\n" +
"                 </th>\n" +
"               </tr>\n" +
"            </thead>\n" +
"            <tbody>\n" +
"                 <tr>\n" +
"                    <td>Name</td>\n" +
"                    <td>"+set.getString("Name")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                  <tr>\n" +
"                    <td>NIN</td>\n" +
"                    <td>"+set.getString("NIN")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                  <tr>\n" +
"                    <td>Date</td>\n" +
"                    <td>"+set.getString("Healthcentre")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                  <tr>\n" +
"                    <td>Health center</td>\n" +
"                    <td>"+set.getString("Date")+"</td>\n" +
"                 </tr>\n" +
"                  <tr>\n" +
"                    <td>Vaccine</td>\n" +
"                    <td>"+set.getString("Batchnumber")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                   <tr>\n" +
"                    <td>Batch</td>\n" +
"                    <td>"+set.getString("Vaccinetype")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
     
                   
"            </tbody>\n");   
   }
    out.println("</table>\n" +
"     </div>   \n" +
"            \n" +
"       </div>\n" +
                      "            <center>\n" +
"                <p class=\"text-2xl\">keep this card safely and produce it when you come for the subsequent doses</p>\n" +
               "            <center>\n" +
"                <p class=\"text-2xl\"><b>Incase of any side Effects or concerns following immunization:"
            + "<p>Toll free Numbers:</p>"
            + " <p>MOH: 0800-100-066</p>"
            + " <p>NDA:0800-101-999</P>"
            + "<P>Dial:*284*99#(fill in short Questionaire)</P>"
            + " WhatsApp-0791415555"
            
            
           
            + " </b></p>\n" +
"  </div>");
            
           
       
    }// </editor-fold>
       catch(SQLException e){
                 out.println("error"+ e.getMessage());  
                }
      }
            catch (ClassNotFoundException e) {
                
                out.println("the error is"+ e.getMessage());
            }
         }
}

