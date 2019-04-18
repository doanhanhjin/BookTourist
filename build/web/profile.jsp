<%-- 
    Document   : profile
    Created on : Mar 19, 2019, 8:40:27 PM
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
                height: 100vh;
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
                width: 400px;
                height: 730px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
            }
            .tour
            {
                position: absolute;
                top: 150%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 80vw;
                height: 500px;
                box-sizing: border-box;
                background:lightcoral;
                color: white;
                padding-left: 140px;
                padding-top: 40px;
                border:white;
                border-collapse: collapse;
                font-size: 24px;
                border-radius: 6%;
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
                margin-bottom: 20px;
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
            <h1>Profile Page</h1>
<!--            <a href="NullController">HOME</a>-->
            <p style="color: green">${requestScope.SUCCESS_UPDATE_ACCOUNT}</p>
            <p style="color: red">${requestScope.FAIL_UPDATE_ACCOUNT}</p>

            <form action="UpdateAccountController" method="POST">
                <input type="text" name="txtUsername" value="${sessionScope.USER.username}" readonly="true"/><br/>
                <input type="password" name="txtPassword" value="${sessionScope.USER.password}" required="required" /><br/>
                <input type="text" name="txtFullname" value="${sessionScope.USER.fullname}" required="required" /><br/>
                <input type="text" name="txtAddress" value="${sessionScope.USER.address}" required="required" /><br/>
                <input type="mail" name="txtEmail" value="${sessionScope.USER.email}" required="required" /><br/>
                <input type="text" name="txtGender"
                       <c:if test="${sessionScope.USER.gender == 'True'}">value="Male"</c:if> 
                       <c:if test="${sessionScope.USER.gender == 'False'}">value="Female"</c:if>/><br/>
                <input type="del" name="txtPhoneNumber" value="${sessionScope.USER.phoneNumber}" required="required" /><br/>
                <input type="submit" value="Update" name="btnAction" />
            </form>
            <form name="action" action="UserMainController" method="POST">
                <input type="submit" value="View My Tours" name="action" />
            </form>
        </div>
        <div class="tour">
            <c:if test="${requestScope.MY_LIST_ORDERS != null && requestScope.MY_TOURS != null}">
                <c:if test="${not empty requestScope.MY_LIST_ORDERS && not empty requestScope.MY_TOURS}">

                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>TOURs name</th>
                                <th>Start date</th>
                                <th>End date</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Checkout Date</th>
                                <th>Cancel</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.MY_TOURS}" var="dto" varStatus="counter">
                            <form action="UserMainController" method="POST">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${dto.name}</td>
                                    <td>${dto.startDate}</td>
                                    <td>${dto.endDate}</td>
                                    <c:forEach items="${requestScope.MY_LIST_ORDERS}" var="order" varStatus="counter">
                                        <c:if test="${dto.id.equals(order.tourId)}">
                                        <input type="hidden" name="ID" value="${order.id}" />
                                        <td>${order.quantity}</td>
                                        <td>${order.total}</td>
                                        <td>${order.checkoutDate}</td>
                                    </c:if>
                                </c:forEach>
                                <td><input type="submit" value="Cancel" name="action" /></td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>

                </c:if>
                ${requestScope.NO_ORDER}
            </c:if>
        </div>
    </body>
</html>
