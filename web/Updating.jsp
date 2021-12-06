<%-- 
    Document   : Updating
    Created on : Dec 5, 2021, 9:13:52 PM
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
        <h1>Hello World!</h1>
        <!--           form for editing-->
           <form action="UpDate" method="post"> 
               <tr>
               <td>ID:</td>
               <input type="text" name="id"/>
               
               <td>Name:</td> 
               <td><input type='text' name='nme'></td>
           </tr>
           <tr>
               <td>LOCATION</td> 
               <td> <input type='text' name='lctn'></td>
           </tr>
            <tr>
               <td></td> 
               <td> <input type='submit' value='save'></td>
           </tr>
           </form> 
        <%@taglib prefix="update" uri="/WEB-INF/tlds/Retreive"%>
<update:updateHandler table="hospitals" newvalue="${nme},${lctn}" where="${id}"/>
    </body>
</html>
