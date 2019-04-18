<%-- 
    Document   : admin
    Created on : Mar 7, 2019, 10:18:23 PM
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
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 600px;
                height: 500px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
                margin-bottom: 20px;
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
                margin-bottom: 6px;
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
        <c:if test="${sessionScope.USER != null}">
                <c:if test="${sessionScope.USER.role == 'admin'}">
                    <p>Welcome ${sessionScope.USER.fullname}</p><br/><br/>
                    <h1>Admin Page</h1>
                </c:if>
                <c:if test="${sessionScope.USER.role == 'user'}">
                    Access Deny!! 
                </c:if>
        </c:if>
        <c:if test="${sessionScope.USER == null}">
            Page not evailable!!
        </c:if>
            <form action="AdminMainController" method="POST"> 
                <input type="submit" value="ACCOUNT" name="action" />
            </form>
            <form action="AdminMainController" method="POST">
                <input type="submit" value="TOUR" name="action" />
            </form>
            </div>
    </body>
</html>
