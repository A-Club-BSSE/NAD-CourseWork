<%-- 
    Document   : target
    Created on : 3 Dec 2021, 16:00:21
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
        <h1> PERCENTAGE TO REACH GOAL</h1>
         <%@ taglib prefix="retriever" uri ="/WEB-INF/tlds/retrieve"%>
          <retriever:targethandler table="module3" values=""/>
        
    </body>
</html>
