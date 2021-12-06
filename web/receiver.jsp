<%-- 
    Document   : receiver
    Created on : 2 Dec 2021, 12:05:22
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
        <h1>Hello World!</h1>
        <%@taglib prefix = "handler" uri="/WEB-INF/tlds/handler" %>
        <%
              String x = request.getParameter("name");
              String y = request.getParameter("nin");
              String z = request.getParameter("healthcentre");
               String a = request.getParameter("data");
               String b = request.getParameter("batchnumber");
               String c = request.getParameter("vaccinetype");

        %>
        <handler:Tagh table="module3" values="${name},${nin},${healthcentre},${data},${batchnumber},${vaccinetype}  "/>
    </bodydf>
</html>
