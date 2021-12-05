<%-- 
    Document   : Auth
    Created on : 5 Dec 2021, 11:45:07
    Author     : elijahokello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authenticating ...</title>
        <style>
            *{
                font-family:"Poppins", sans-serif ;
            }
        </style>
    </head>
    <body>
        <h1>Authenticating ...</h1>
        <%@taglib uri="WEB-INF/tlds/Authenticate.tld" prefix="register" %>
        <%
            String email = request.getParameter("email");
            out.println(email);
            String password = request.getParameter("password");
            out.println(password);
        %>
        <register:Authenticate values="elijahoke@gmail.com,123"></register:Authenticate>
    </body>
</html>
