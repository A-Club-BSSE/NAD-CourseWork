<%-- 
    Document   : Register
    Created on : 2 Dec 2021, 15:53:17
    Author     : elijahokello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register </title>
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
                height:900px;
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
        <h1 style="text-align: center ">Register </h1>
        <div class="form-container">
            <!--<img src="https://image.freepik.com/free-vector/pills-medical-realistic-composition_98292-1233.jpg" alt="medic" width="700">-->
            <div>
                <form action="/Vaccine_Admin_Tracker/Register" method="post">
                    <div class="field-container">
                        <input class="inpttxt" type="text" name="Name" placeholder="Name" required>
                    </div>
                    <div class="field-container">
                        <input class="inpttxt" type="text" placeholder="Contact" name = "contact" required>
                    </div>
                    <div class="field-container">
                        <input class="inpttxt" type="text" placeholder="Nin" name = "nin" required>
                    </div>
                    <div class="field-container">
                        <input class="inpttxt" type="number" placeholder="Age" name = "age" required>
                    </div>
                    <div class="field-container">
                        <input class="inpttxt" type="text" placeholder="Gender" name = "gender" required>
                    </div>
                    <div class="field-container">
                        <input class="inpttxt" type="email" placeholder="Email" name = "email" required>
                    </div>
                    <div class="field-container">
                        <input class="inpttxt" type="password" placeholder="Password" name = "password" required>
                    </div>
                    <div class="field-container">
                        <p style="text-align:center;">Are you an Admin ?</p>
                        <input value="TRUE" class="inpttxt" type="radio" name = "is_admin" >
                    </div>
                    <div class="field-container-btn">
                        <input class="btn" type="submit">
                    </div>
                    <p style="text-align: center">Already have an account? <a href="/Vaccine_Admin_Tracker/signin">Sign In</a> </p>
               </form>
            </div>
        </div>
    </body>
</html>
