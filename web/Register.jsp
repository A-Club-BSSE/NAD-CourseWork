<%-- 
    Document   : Register
    Created on : 2 Dec 2021, 15:53:17
    Author     : elijahokello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/Vaccine_Admin_Tracker/Register" method="post">
            <input type="text" placeholder="Test" name="test" required>
            <input type="submit">
        </form>
        <%@taglib uri="WEB-INF/tlds/Register.tld" prefix="register" %>
        <%
            String name = request.getParameter("test");
            out.println(name);
        %>
        <register:NewTag name="${name}"></register:NewTag>
    </body>
</html>
