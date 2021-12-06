<%-- 
    Document   : Distribute
    Created on : Dec 5, 2021, 4:42:35 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
   <style>
        
                    
            
  @import url(https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic);
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
  -moz-font-smoothing: antialiased;
  -o-font-smoothing: antialiased;
  font-smoothing: antialiased;
  text-rendering: optimizeLegibility;
}

body {
  font-family: "Roboto", Helvetica, Arial, sans-serif;
  font-weight: 100;
  font-size: 12px;
  line-height: 30px;
  color: black;
  background:lightgoldenrodyellow;
}

.container {
  max-width: 400px;
  width: 100%;
  margin: 0 auto;
  position: relative;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea,
#contact button[type="submit"] {
  font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
}

#contact {
  background: #F9F9F9;
  padding: 25px;
  margin: 150px 0;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

#contact h3 {
  display: block;
  font-size: 30px;
  font-weight: 300;
  margin-bottom: 10px;
}

#contact h4 {
  margin: 5px 0 15px;
  display: block;
  font-size: 13px;
  font-weight: 400;
}

fieldset {
  border: medium none !important;
  margin: 0 0 10px;
  min-width: 100%;
  padding: 0;
  width: 100%;
}

#contact input[type="text"],
#contact input[type="email"],
#contact input[type="tel"],
#contact input[type="url"],
#contact textarea {
  width: 100%;
  border: 1px solid #ccc;
  background: #FFF;
  margin: 0 0 5px;
  padding: 10px;
}

#contact input[type="text"]:hover,
#contact input[type="email"]:hover,
#contact input[type="tel"]:hover,
#contact input[type="url"]:hover,
#contact textarea:hover {
  -webkit-transition: border-color 0.3s ease-in-out;
  -moz-transition: border-color 0.3s ease-in-out;
  transition: border-color 0.3s ease-in-out;
  border: 1px solid #aaa;
}

#contact textarea {
  height: 100px;
  max-width: 100%;
  resize: none;
}

#contact button[type="submit"] {
  cursor: pointer;
  width: 100%;
  border: none;
  background: #4CAF50;
  color: #FFF;
  margin: 0 0 5px;
  padding: 10px;
  font-size: 15px;
}

#contact button[type="submit"]:hover {
  background: #43A047;
  -webkit-transition: background 0.3s ease-in-out;
  -moz-transition: background 0.3s ease-in-out;
  transition: background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active {
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

.copyright {
  text-align: center;
}

#contact input:focus,
#contact textarea:focus {
  outline: 0;
  border: 1px solid #aaa;
}

::-webkit-input-placeholder {
  color: #888;
}

:-moz-placeholder {
  color: #888;
}

::-moz-placeholder {
  color: #888;
}

:-ms-input-placeholder {
  color: #888;
}

input{
    width:100%;
    padding: 10px;
}
        </style>
    </head>
    <body>
        
        <!--<h1>Hello World!</h1>-->
          <!--<tr class="field-container">-->
<div class="container">  
    <form action="/Vaccine_Admin_Tracker/DistributeVaccine" method="POST">
    <h3>VACCINE DISTRIBUTION</h3>
   
    <table>
        <tr>
            <td>HealthCentre Name:</td>
            <td>
    <fieldset>
      <input type='text' name='Name' tabindex="1" required autofocus>
    </fieldset>
       </td>    
    </tr>
    
    
    <tr>
        <td>Vaccine Type:</td>
        <td>
    <fieldset>
     <input type='text' name='VaccineType' tabindex="2" required>
    </fieldset>
    </td>
    </tr>
    
    <tr>
        <td>Doze Amount:</td>
        
        <td>
     <fieldset>
      <input type='number' name='Amount' tabindex="3" required>
    </fieldset>
        </td>
    </tr>
    <tr>
        <td>Distribute:</td>
        <td>
    <fieldset>
      <button name='distribute' type='submit' value='distribute'id="contact-submit" >Submit</button>
    </fieldset>
        </td>
    </tr>
    </table>
  </form>
</div>
             
          
        <%@taglib uri="/WEB-INF/tlds/distribute" prefix="distribute"%>
        <distribute:DistributeTagHandler/>
                
   <% 
            String N=request.getParameter("Name");
            String V=request.getParameter("VaccineType");
            String A=request.getParameter("Amount");
   %>
    </body>
</html>
