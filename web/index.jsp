<%-- 
    Document   : index
    Created on : Dec 1, 2021, 2:36:56 PM
    Author     : IPERU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="healthcentre" uri="/WEB-INF/tlds/healthcentre"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register HealthCentre</h1>
        
       <table>
       <form action='Receiver' method='post' >
           <tr>
               <td>Name:</td> 
               <td><input type='text' name='name'></td>
           </tr>
           <tr>
               <td>LOCATION</td> 
               <td> <input type='text' name='location'></td>
           </tr>
            <tr>
               <td></td> 
               <td> <input type='submit' value='save'></td>
           </tr>
            

            </form>
           </table>
           
               
           
       <%
       String h=request.getParameter("healthcentre");
       request.setAttribute("healthcentre",h);
       %>
        
        <form action="index.jsp" method="post">
            <br> <tr>Enter healthCentre
                   <td><input type='text' name='healthcentre'></td>
               </tr>
               <tr><input type='submit' value='save'></tr>
               
           </form>
        
        <%@taglib prefix="healthcentre" uri="/WEB-INF/tlds/healthcentre"%>
        <%@taglib prefix="assess" uri="/WEB-INF/tlds/Retreive"%>
        
        <%@taglib prefix="retrive" uri="/WEB-INF/tlds/Retreive"%>
        
        <assess:assessing value="${healthcentre}"/>
        <table border="1">
            <tr>
                <th>Id</th>
                
                <th>Name</th>
             <th>location</th>
             <th> Editing</th>
            </tr>
           <retrive:Select table="hospitals" values=""/>
        </table>
        <button onClick="window.location='Updating.jsp'">Edit healthCentre</button>
<!--        custom tag for updating healthcentre information-->
           <%@taglib prefix="update" uri="/WEB-INF/tlds/Retreive"%>
<!--           form for editing
           <form action="UpDate" post=""> 
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
           </form> -->
           <%%>
<%@taglib prefix="update" uri="/WEB-INF/tlds/Retreive"%>
<%--<update:updateHandler table="hospitals" newvalue="${nme},${lctn}" where="${id}"/>--%>
       

                              
    </body>
</html>
