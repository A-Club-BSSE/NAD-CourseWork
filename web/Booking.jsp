<%-- 
    Document   : Booking
    Created on : 3 Dec 2021, 11:28:01
    Author     : Joanita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Page</title>
    </head>
    <body>
            <%@taglib uri = "WEB-INF/tlds/Booking.tld" prefix="Book"%>
            
        <h1>Booking Of Vaccination</h1>
        
        <table>
            <form action="/CourseWork/BookingServlet" method="post">
                <tr> 
                    <td> Name:</td>
                    <td><input type="text" name="name" /></td>
                </tr>

                <tr>
                    <td>Date</td>
                    <td><input type="date" name="date" /></td>
                </tr>
                <tr>
                    <td>Time</td>
                    <td><input type="time" name="time"/></td>
                </tr>
                <tr>
                    <td>Place Of Preference</td>
                    <td><input type="text" name="place"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type ="submit" name="submit" value="save"/></td>
                </tr>
            </form>
<%
               String Name =request.getParameter ("name");
               String Date = request.getParameter("date");
               String Time = request.getParameter("time");
               String PlaceOfPreference = request.getParameter("place");
//               request.setAttribute("name",Name);
//               request.setAttribute("date",Date);
//               request.setAttribute("time",Time);
//               request.setAttribute("place",POP);
            %>
            
            <Book:BookingTagHandler table="vaccination" values="${name},${date},${time},${place}"/>
        </table>
    </body>
</html>
