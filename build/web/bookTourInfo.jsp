<%-- 
    Document   : bookTourInfo
    Created on : Mar 18, 2019, 4:09:49 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                top: 70%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 500px;
                height: 780px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
            }

            .contact-form2
            {
                position: absolute;
                top: 180%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 500px;
                height: 500px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
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

            .contact-form h2 {
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
                margin-bottom: 25px;
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
            
            <h2>Book Tour Information</h2>
            <form action="UserMainController" method="POST">
                <input type="hidden" name="tourId" value="${sessionScope.TOUR_ID}" />
                <p>Participant number - Only <c:out value="${sessionScope.DTO_TOUR.maxParticipantNumber - sessionScope.DTO_TOUR.participantNumber}"/> slots.<br/></p>
                <p>Adult
                    <select name="txtAdult">
                        <c:forEach items="${sessionScope.LIST_NUMBER}" varStatus="counter">
                            <option value="${counter.count}">${counter.count}</option>
                        </c:forEach>
                    </select>
                    Child
                    <select name="txtChild">
                        <c:forEach items="${sessionScope.LIST_NUMBER}" varStatus="counter">
                            <option value="${counter.count-1}">${counter.count-1}</option>
                        </c:forEach>
                    </select></p>
                <input type="submit" value="View Price" name="action"/>
            </form>

            <div>
                <c:if test="${not empty requestScope.ViewPriceController_PriceAdult && not empty requestScope.ViewPriceController_PriceChild}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th><p>Adult</p></th>
                                <th><p>Child</p></th>
                                <th><p>Total</p></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><p>${requestScope.ViewPriceController_PriceAdult}</p></td>
                                <td><p>${requestScope.ViewPriceController_PriceChild}</p></td>
                                <td><p>${requestScope.ViewPriceController_PriceAdult + requestScope.ViewPriceController_PriceChild}</p></td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>
            </div>
            <div style="float: left; width: 92%;">
                <form action="UserMainController" method="POST">
                    <p>Full name</p>  <input type="text" name="txtFullname" value="${sessionScope.USER.fullname}"  required="required" />
                    <p>Address</p>  <input type="text" name="txtAddress" value="${sessionScope.USER.address}"  required="required" />
                    <p>Email</p>  <input type="email" name="txtEmail" value="${sessionScope.USER.email}"  required="required" />
                    <p>Phone Number</p><input type="tel" name="txtPhoneNumber" value="${sessionScope.USER.phoneNumber}"  required="required" />
                    <input type="hidden" name="tourId" value="${sessionScope.TOUR_ID}"/>
                    <input type="hidden" name="username" value="${sessionScope.USER.username}"/>
                    <input type="hidden" name="txtAdult" value="${param.txtAdult}"/>
                    <input type="hidden" name="txtChild" value="${param.txtChild}"/>
                    <input type="hidden" name="Total" value="${requestScope.ViewPriceController_PriceAdult+requestScope.ViewPriceController_PriceChild}"  required="required" />
                    <input type="submit" value="Book" name="action" />
                </form>
            </div>

                    <p>${requestScope.SUCCESS}</p>
        </div>
        <!--*********************************-->

        <c:if test="${sessionScope.ORDER_DTO != null}">
            <div class="contact-form2"style="background-color:greenyellow;text-align: center; font-size: 18px;">

                ** INFORMATIONs OF YOUR TOUR **<br/><br/>
                <td>${sessionScope.DTO_TOUR.name}</td>TOURs<br/><br/>
                Full Name: <td>${sessionScope.USER.fullname}</td><br/><br/>
                Start Date: <td>${sessionScope.DTO_TOUR.startDate}</td><br/><br/>
                End Date: <td>${sessionScope.DTO_TOUR.endDate}</td><br/><br/>
                Quantity: <td>${sessionScope.ORDER_DTO.quantity}</td><br/><br/>
                Total: <td>${sessionScope.ORDER_DTO.total}</td><br/><br/>
                Checkout Date: <td>${sessionScope.ORDER_DTO.checkoutDate}</td><br/><br/>
            </div>
        </c:if>

    </body>
</html>
