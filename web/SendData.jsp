<%-- 
    Document   : SendData
    Created on : 5 Dec 2021, 07:57:45
    Author     : elijahokello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sending data ...</title
    </head>
    <body>
        <p>Sending Data ...</p>
        <%@taglib uri="WEB-INF/tlds/Register.tld" prefix="register" %>
        <%
            String name = request.getParameter("name");
            String contact = request.getParameter("contact");
            String nin = request.getParameter("nin");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
//            out.println(name);
        %>
        <register:RegisterUsers values="${name},${contact},${nin},${age},${gender},${email},${password}"></register:RegisterUsers>
       
    </body>
</html>
