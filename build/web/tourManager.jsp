<%-- 
    Document   : tourManager
    Created on : Mar 25, 2019, 9:34:35 PM
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
                top: 32%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 70vw;
                height: 320px;
                padding: 40px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
                border-radius: 5%;
            }
            .contact-form2
            {
                position: absolute;
                top: 420%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 98vw;
                box-sizing: border-box;
                background: wheat;
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
                left: 8%;
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
            <h1>TOUR MANAGER!</h1>
            <form action="TourManagerController" method="POST">
                <input type="submit" value="View Tour" name="action" />
            </form>
            <form action="TourManagerController" method="POST">
                <input type="submit" value="Insert Tour" name="action" />
            </form>
        </div>
        <div class="contact-form2">
            <c:if test="${requestScope.VIEW_TOUR_SUCCESS != null}">
                <c:if test="${not empty requestScope.VIEW_TOUR_SUCCESS}">
                    <table border="1" style="text-align: center; border-collapse: collapse; border: none">
                        <thead>
                            <tr>
                                <th style="width: 4%">No</th>
                                <th style="width: 4%">Id</th>
                                <th style="width: 8%">Name</th>
                                <th style="width: 8%">Price</th>
                                <th style="width: 26%">Description</th>
                                <th style="width: 8%">Start date</th>
                                <th style="width: 8%">End date</th>
                                <th style="width: 4%">Participant number</th>
                                <th style="width: 4%">Max participant</th>
                                <th style="width: 4%">Category Id</th>
                                <th>Image</th>
                                <th>Delete</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.VIEW_TOUR_SUCCESS}" var="dto" varStatus="counter" >
                            <form action="TourManagerController" method="POST">

                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${dto.id}</td>
                                    <td>${dto.name}</td>
                                    <td>${dto.price}</td>
                                    <td>${dto.description}</td>
                                    <td>${dto.startDate}</td>
                                    <td>${dto.endDate}</td>
                                    <td>${dto.participantNumber}</td>
                                    <td>${dto.maxParticipantNumber}</td>
                                    <td>${dto.categoryId}</td>
                                    <td><img src="${dto.image}" style="width: 200px; height: 190px;"/></td>
                                    <td>
                                        <input type="hidden" name="tourId" value="${dto.id}" />
                                        <input type="submit" value="Delete" name="action" style="height: 186px;"/>
                                    </td>
                                    <td>
                                        <input type="hidden" name="tourId" value="${dto.id}" />
                                        <input type="submit" value="Edit" name="action" style="height: 186px;"/>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

            </c:if>
            <c:if test="${requestScope.VIEW_TOUR_SUCCESS == null}">
                No TOURs found!
            </c:if>

        </div>
    </body>
</html>
