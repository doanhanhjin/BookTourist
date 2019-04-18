<%-- 
    Document   : register
    Created on : Mar 8, 2019, 7:42:25 AM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                margin: 0;
                padding: 0;
            }
            body:before{
                content: '';
                position: fixed;
                width: 100vw;
                height: 120vh;
                background-image: url("img/quangbinh.jpg");
                background-position: center center;
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
                -webkit-filter: blur(10px);
                -moz-filter: blur(10px);
                -o-filter: blur(10px);
                -ms-filter: blur(10px);
                filter: blur(10px);
            }
            .contact-form
            {
                position: absolute;
                top: 70%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 600px;
                height: 800px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
            }
            .avatar {
                position: absolute;
                width: 80px;
                height: 80px;
                border-radius: 50%;
                overflow: hidden;
                top: calc(-80px/2);
                left: calc(50% - 40px);
            }
            .contact-form h1 {
                margin: 0;
                padding: 0 0 20px;
                color: #fff;
                text-align: center;
                text-transform: uppercase;
            }
            .contact-form p
            {
                margin: 0;
                padding: 0;
                font-weight: bold;
                color: #fff;
            }
            .contact-form input
            {
                width: 100%;
                margin-bottom: 10px;
            }
            .contact-form input[type="text"],
            .contact-form input[type="password"]
            {
                border: none;
                border-bottom: 1px solid #fff;
                background: transparent;
                outline: none;
                height: 40px;
                color: #fff;
                font-size: 16px;
            }
            .contact-form input[type="submit"] {
                height: 30px;
                color: #fff;
                font-size: 15px;
                background: red;
                cursor: pointer;
                border-radius: 25px;
                border: none;
                outline: none;
                margin-top: 5%;
            }
            .contact-form input[type="reset"] {
                height: 30px;
                color: #fff;
                font-size: 15px;
                background: red;
                cursor: pointer;
                border-radius: 25px;
                border: none;
                outline: none;
                margin-top: 10%;
            }
            .a
            {
                position: absolute;
                top: 16%;
                left: 15%;
                transform: translate(-50%,-50%);
                width: 100px;
                height: 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
                color: white;
                padding-top: 10px;
                padding-left: 22px;
                border-radius: 10%;
                text-decoration: none;
            }
            .contact-form a
            {
                color: #fff;
                font-size: 14px;
                font-weight: bold;
                text-decoration: none;
            }
            input[type="checkbox"] {
                width: 20%;
            }
        </style>
    </head>
    <body>
         <a class="a" href="NullController">HOME</a>
    <div class="contact-form">
        <img src="img/2.jpg" alt="" class="avatar">
        <h1>Register Page!</h1>
        <p>${requestScope.ERROR}</p>
        <form action="MainController" method="POST">
            <p>Username</p>
            <input type="text" name="txtUsername" value="" required="required"/>
            <p>Password</p> 
            <input type="password" name="txtPassword" value="" required="required"/>
            <p>Confirm Password</p> 
            <input type="password" name="txtConfirmPassword" value="" required="required"/>
            <p>Fullname</p> <input type="text" name="txtFullname" value="" required="required"/>
            <p>Address</p> <input type="text" name="txtAddress" value="" required="required"/>
            <p>Email</p> <input type="email" name="txtEmail" value="" required="required"/>
            <p>Male <input type="radio" name="rbtnGender" value="Male" checked="checked"/> Female<input type="radio" name="rbtnGender"  value="Female"/></p>
            <p>Phone Number</p> <input type="tel" name="txtPhoneNumber" value="" required="required"/>
            <input type="submit" value="Register" name="action" />
        </form>
    </div>
</body>
</html>
