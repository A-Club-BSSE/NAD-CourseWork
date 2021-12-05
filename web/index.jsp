<%-- 
    Document   : index
    Created on : 4 Dec 2021, 23:06:17
    Author     : Hyasmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <form action="Certificate" method="post">
        <table>

            <tr>
                <td> Name</td>
                <td> <input type="text" name="name"/> </td>
            </tr>
              <tr>
                <td> NIN</td>
                <td> <input type="text" name="nin"/> </td>
            </tr>
              <tr>
                <td> Healthcentre</td>
                <td> <input type="text" name="healthcentre"/> </td>
            </tr>
              <tr>
                <td> Date</td>
                <td> <input type="date" name="data"/> </td>
            </tr>
              <tr>
                <td> Batchnumber</td>
                <td> <input type="text" name="batchnumber"/> </td>
            </tr>
             <tr>
                <td> Vaccinetype</td>
                <td> <input type="text" name="vaccinetype"/> </td>
            </tr>
              <tr>
               
                <td> <input type="submit" name="" value ="SAVE"/> </td>
            </tr>
          
        </table>
                    </form>
        <button>
            <a href="certificateservlet">Certificate</a>
        </button>
         <button>
            <a href="target.jsp">Target Check</a>
        </button>
        <%
            String x = request.getParameter("name"); 

              String y = request.getParameter("nin");
             
               String z = request.getParameter("healthcentre");
                String a = request.getParameter("data");
                 String b = request.getParameter("batchnumber");
                  String c = request.getParameter("vaccinetype");
        %>
        <%@taglib  prefix="handler" uri="/WEB-INF/tlds/handler" %>

        <handler:Tagh table="module3" values="${name},${nin},${healthcentre},${data},${batchnumber},${vaccinetype}"/>
    </body>
</html>
