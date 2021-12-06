h<%-- 
    Document   : AddToDb
    Created on : Dec 2, 2021, 9:02:17 AM
    Author     : IPERU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@taglib prefix="healthcentre" uri="/WEB-INF/tlds/healthcentre"%>
        <%
            String name = request.getParameter("name");
            String location  = request.getParameter("location");
            String email = request.getParameter("email");
            String vaccine = request.getParameter("vaccine");
            String action= request.getParameter("action");
           
        %>

        <healthcentre:module1 table="hospitals" values="${name} , ${location},${email},${vaccine},${action}" ></healthcentre:module1>
    </body>
</html>
