<%-- 
    Document   : SiginIn
    Created on : 5 Dec 2021, 08:59:06
    Author     : elijahokello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100&display=swap" rel="stylesheet">
        <style>
            *{
                font-family: 'Poppins', sans-serif;
            }
            
            .form-container{
                box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
                width:60%;
                margin-left:auto;
                margin-right:auto;
                display:flex;
                justify-content: center;
                border-radius: 20px;
            }
            
            .field-container{
                margin:2em;
            }
            
            .inpttxt{
                border:0px solid black;
                padding:1.5em;
                border-radius:9px;
                background:#e6ecf5;
                width:200px;
            }
            
            .field-container-btn{
                display:flex;
                justify-content: center;
            }
            
            .btn{
                background-color:#ed5d15;
                padding:1em;
                border-radius: 20px;
                border:0px;
                color:white;
            }
        </style>
    </head>
    <body style="background-color:">
        <h1 style="text-align: center ">SIGN IN  </h1>
        <div class="form-container">
            <!--<img src="https://image.freepik.com/free-vector/pills-medical-realistic-composition_98292-1233.jpg" alt="medic" width="700">-->
            <div>
                <form action="/Vaccine_Admin_Tracker/AuthServlet" method="post">
                    <div class="field-container">
                        <input class="inpttxt" type="email" name="email" placeholder="Email" required>
                    </div>
                    <div class="field-container">
                        <input class="inpttxt" type="password" placeholder="Password" name = "password" required>
                    </div>
                    <div class="field-container-btn">
                        <input class="btn" type="submit">
                    </div>
                    <p style="text-align: center">Don't have an account? <a href="/Vaccine_Admin_Tracker/RegisterPage">Register</a> </p>
               </form>
            </div>
        </div>
    </body>
</html>
