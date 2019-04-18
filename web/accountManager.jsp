<%-- 
    Document   : accountManager
    Created on : Mar 25, 2019, 9:30:17 PM
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
                top: 30%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 58vw;
                height: 250px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
            }
            .contact-form2
            {
                position: absolute;
                top: 150%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 70vw;
                height: 1000px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
                color: white;
                padding-left: 30px;
                font-size: 20px;
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
                width: 130px;
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
        <a class="a" href="admin.jsp">ADMIN page</a>

        <div class="contact-form">
            <h1>ACCOUNT MANAGER!</h1>
            <form action="AdminSearchController" method="POST">
                <input type="submit" value="View Account" name="action" />
            </form>
        </div>

        <c:if test="${requestScope.LIST_ACCOUNT != null}">
            <c:if test="${not empty requestScope.LIST_ACCOUNT}">
                <div class="contact-form2">
                    <table border="1">
                        <thead>
                            <tr>
                                <th><p>No.</p></th>
                                <th><p>Username</p></th>
                                <th><p>Fullname</p></th>
                                <th><p>Address</p></th>
                                <th><p>Email</p></th>
                                <th><p>Phonenumber</p></th>
                                <th><p>Gender</p></th>
                                <th><p>Status</p></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.LIST_ACCOUNT}" var="dto" varStatus="counter">
                                <tr>
                                    <td><p>${counter.count}</p></td>
                                    <td><p>${dto.username}</p></td>
                                    <td><p>${dto.fullname}</p></td>
                                    <td><p>${dto.address}</p></td>
                                    <td><p>${dto.email}</p></td>
                                    <td><p>${dto.phoneNumber}</p></td>
                                    <td>
                                        <p><c:if test="${dto.gender eq 'true'}">
                                                Male
                                            </c:if>
                                            <c:if test="${dto.gender eq 'false'}">
                                                Female
                                            </c:if></p>
                                    </td>
                            <p> <td>${dto.status}</td></p>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>

            </c:if>
        </div>
    </body>
</html>
