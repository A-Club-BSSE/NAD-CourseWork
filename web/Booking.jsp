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
        <style>
            body {
              width: 500px;
              margin: 0 auto;
              padding: 50px;
              background: linear-gradient(90deg, #4b6cb7 0%, #182848 100%);
            }
            
            form{
                position: relative;
                z-index: 1;
                background: #FFFFFF;
                border-radius: 10px;
                max-width: 360px;
                margin: 0 auto 100px;
                padding: 45px;
                text-align: center;
            }

            div.elem-group {
              margin: 20px 0;
            }

            div.elem-group.inlined {
              width: 49%;
              display: inline-block;
              float: left;
              margin-left: 1%;
            }

            label {
              display: block;
              font-family: 'Nanum Gothic';
              padding-bottom: 10px;
              font-size: 1.25em;
            }

            input, select, textarea {
              border-radius: 2px;
              border: 2px solid #777;
              box-sizing: border-box;
              font-size: 1.25em;
              font-family: 'Nanum Gothic';
              width: 100%;
              padding: 10px;
              background: #f2f2f2;
            }

            div.elem-group.inlined input {
              width: 95%;
              display: inline-block;
            }

            hr {
              border: 1px dotted #ccc;
            }

            button {
              height: 50px;
              background: orange;
              border: none;
              color: white;
              font-size: 1.25em;
              font-family: 'Nanum Gothic';
              border-radius: 4px;
              cursor: pointer;
            }

            button:hover {
              border: 2px solid black;
            }
        </style>
    </head>
    <body>
            <%@taglib uri = "WEB-INF/tlds/Booking.tld" prefix="vaccination"%>
            
        <h1>Booking Of Vaccination</h1>
        
                <form action="/CourseWork/BookingServlet" method="post" class="form">
          <div class="elem-group">
            <label for="name">Your Name</label>
            <input type="text" id="name" name="name" placeholder="Nakityo Joanita" pattern=[A-Z\sa-z]{3,20} required>
          </div>

          <div class="elem-group inlined">
            <label for="booking-date">Booking Date</label>
            <input type="date" id="booking-date" name="date" required>
          </div>
          <div class="elem-group inlined">
            <label for="booking-time">Booking Time</label>
            <input type="time" id="booking-time" name="time" required>
          </div>
          <div class="elem-group">
            <label for="place-selection">Place Of Preference</label>
            <select id="place-selection" name="place" required>
                <option value="">Choose a place from the List Below</option>
                    <option value = "Mulago">Mulago Hospital</option>
                    <option value = "Nsambya">Nsambya Hospital</option>
                    <option value = "Lyantonde">Lyantonde Hospital</option>
                    <option value = "Soroti ">Soroti Hospital</option>
                    <option value = "Gulu ">Gulu Hospital</option>
            </select>
          </div>
          <hr>

          <button type="submit">Book The Place</button>
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
            
            <vaccination:insert table="vaccination" values="${name},${date},${time},${place}"/>
        </table>
    </body>
</html>
