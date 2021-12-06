<%-- 
    Document   : SendEmailData
    Created on : 6 Dec 2021, 11:03:10
    Author     : elijahokello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Email Reminder</title>
        <style>
            *{
                font-family: "Poppins", sans-serif ;
            }
        </style>
    </head>
    <body>
        <%@taglib uri="WEB-INF/tlds/Register.tld" prefix="email" %>
        <%
            String subject = request.getParameter("subject");
//            out.println(subject);
            String email = request.getParameter("email");
//            out.println(email);
            String body = request.getParameter("body");
//            out.println(body);
        %>
        <email:SendEmail values="${subject},${email},${body}"></email:SendEmail>
        <h1>Sending Email ...</h1>
    </body>
</html>
