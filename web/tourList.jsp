<%-- 
    Document   : tourList
    Created on : Mar 14, 2019, 7:53:35 PM
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
           
           
            #aManager
            {
                position: absolute;
                top: 16%;
                left: 75%;
                transform: translate(-50%,-50%);
                width: 120px;
                height: 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
                color: white;
                padding-top: 10px;
                padding-left: 22px;
                border-radius: 10%;
                text-decoration: none;
            }
            #aHome
            {
                position: absolute;
                top: 16%;
                left: 5%;
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
            .one
            {
                position: absolute;
                width: 98vw;
                height: 160px;
                margin-bottom: 200px;
            }
/*            .two
            {
                position: absolute;
            }*/
            #search
            {
                left: 75%;
                top: 210px;
                position: relative;
                font-size: 26px;
            }
            .four
            {
                top: 236px;
                left: -10%;
                position: relative;
            }
            .four2
            {
                top: 100px;
                text-align: center;
                position: relative;
            }
            .five
            {
                top: 100px;
                position: relative;
            }
            .six
            {
                top: 100px;
                position: relative;
            }
            #TOURLIST
            {
                text-align: center;
                color: greenyellow;
                font-size: 58px;
            }
            #Logout{
                position: absolute;
                top: 16%;
                left: 94%;
                transform: translate(-50%,-50%);
                width: 110px;
                height: 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
                color: white;
                padding-top: 10px;
                padding-left: 22px;
                border-radius: 10%;
                text-decoration: none;
            }
            #profile
            {
                position: absolute;
                top: 16%;
                left: 85%;
                transform: translate(-50%,-50%);
                width: 110px;
                height: 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
                color: white;
                padding-top: 10px;
                padding-left: 22px;
                border-radius: 10%;
                text-decoration: none;
                text-align: center;
            }
            #welcome {
                position: absolute;
                top: 46%;
                left: 85%;
                font-size: 26px;
                color: navy;
            }

        </style>
    </head>
    <body>
<!--       <div class="two">
            <img class="mySlides" src="img/phuquoc.jpg" style="width:100%; height: 70vh;">
            <img class="mySlides" src="img/sapa.jpg" style="width:100%; height: 70vh">
            <img class="mySlides" src="img/quynhon.jpg" style="width:100%; height: 70vh">
        </div>-->

        <div class="one">
            <h1 id="TOURLIST">Tour List</h1>
            <a id="aHome" href="CategoryController" style="margin-right: 250px;">HOME</a>
            <c:if test="${sessionScope.USER != null}">
                <form action="MainController" method="POST" style="float: left;">
                    <input id="Logout" type="submit" value="Log out" name="action" style="float: right"/>
                </form>
                <a id="profile"href="profile.jsp" style="float: right">Profile</a>
                <span id="welcome"style="float: right">Welcome ${sessionScope.USER.fullname}</span>
                <c:if test="${sessionScope.USER.role == 'admin'}">
                    <a id="aManager" href="admin.jsp" style="float: right;">Manager</a>
                </c:if>
            </c:if> 

            <c:if test="${sessionScope.USER == null}" >
                <a href="login.jsp" style="float: left;">Login</a>
                <a href="register.jsp" style="float: left;">Register</a>
            </c:if> 
        </div>

        
        <!--Form search-->
        <hr/>
        <form id="search" action="MainController" method="POST" style="float: left; margin-right: 250px;">
            <p>CATEGORY <select name="txtSearch" ></p>
                <c:if test="${sessionScope.CATEGORIES != null}">
                    <c:forEach items="${sessionScope.CATEGORIES}" var="dto">
                        <option value="${dto.id}">${dto.name}</option>
                    </c:forEach>
                </c:if>
            </select>
            <input type="submit" value="Search" name="action" />
        </form>

        <form class="four" action="MainController" method="POST" style="float: left">
            min <input type="number" name="txtMin" value="${requestScope.valueMin}" id="txtMin" min="0" required="required" />
            max <input type="number" name="txtMax" value="${requestScope.valueMax}"  id="txtMax" required="required" onblur="comparePrice();" />
            <input type="submit" value="SearchByPrice" name="action"/>
        </form>
        <br>
        <div class="four2">
        <h2 style="color: green">${requestScope.SUCCESS}</h2>
        
        <c:forEach items="${sessionScope.CATEGORIES}" var="dto">
            <c:if test="${dto.id == requestScope.lastSearch}">
                <p style="text-align: center; padding-top: 5px; color: white;font: italic bold 35px/30px Georgia, serif;"> ${dto.name} TOURs</p>
            </c:if>
        </c:forEach>
           </div>     
        <!--Show list category-->
        <div class="five">
        <c:if test="${sessionScope.CATEGORIES != null && requestScope.LIST_TOURS == null}">
            <c:if test="${not empty sessionScope.CATEGORIES}" var="checkList">
                <c:forEach items="${sessionScope.CATEGORIES}" var="dto" varStatus="counter">
                    <div style="background-color: rgba(181, 181, 181, 0.1); width: 100%; height: 410px; float: left; margin-top: 100px; font: italic bold 15px/32px Georgia, serif; text-align: center;
                         "><!--style="background-color: greenyellow; color: black"-->
                        <c:url var="searchLink" value="MainController">
                            <c:param name="action" value="searchLink"/>
                            <c:param name="tourId" value="${dto.id}"/>
                        </c:url>
                        <div style="width: 40%; float: left; height: 100%; margin-left: 96px;"> 
                            <img src="${dto.image}" style="width: 100%; height: 100%"/>
                        </div>
                        <div style="width: 40%; height: 100%; float: left; margin-left: 96px;background-color: rgba(181, 181, 181, 0.52);">
                            <a href="${searchLink}"><h2>${dto.name}</h2></a>
                            <p style="margin: 20px;">${dto.description}</p>
                            <p>IMAGE</p>
                        </div>
                    </div>

                </c:forEach>
            </c:if>
            <c:if test="${!checkList}">
                NO record is found!
            </c:if>
        </c:if>
                </div>
        <!--Show tours & sent form book tour-->
        <div class="six">
        <c:if test="${requestScope.LIST_TOURS != null}">
            <c:if test="${not empty requestScope.LIST_TOURS}" var="checkList">
                <c:forEach items="${requestScope.LIST_TOURS}" var="dto">
                    <form action="UserMainController" method="POST">
                        <div style="background-color: rgba(181, 181, 181, 0.1); width: 100%; height: 410px; float: left; margin-top: 100px; font: italic bold 15px/32px Georgia, serif; text-align: center;
                             ">
                            <div style="width: 40%; height: 100%; float: left; margin-left: 96px;background-color: rgba(181, 181, 181, 0.52);">
                                <h2>${dto.name}</h2>
                                <td>${dto.description}</td><br/>
                                Start Date: <td>${dto.startDate}</td><br/>
                                End Date: <td>${dto.endDate}</td><br/>
                                Price: <td>${dto.price}</td>/ người.<br/> 
                                Slots: <td>${dto.maxParticipantNumber-dto.participantNumber}</td><br/>
                                <input type="hidden" name="tourId" value="${dto.id}" />
                                <input type="hidden" name="tourPrice" value="${dto.price}" />
                                <input type="submit" value="Book Tour" name="action" />
                            </div>
                            <div style="width: 40%; float: left; height: 100%; margin-left: 96px;">
                                <img src="${dto.image}" style="width: 500px; height: 400px;"/>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </c:if>
        </c:if>
        </div>
        <script>
//            var myIndex = 0;
//            carousel();
//
//            function carousel() {
//                var i;
//                var x = document.getElementsByClassName("mySlides");
//                for (i = 0; i < x.length; i++) {
//                    x[i].style.display = "none";
//                }
//                myIndex++;
//                if (myIndex > x.length) {
//                    myIndex = 1
//                }
//                x[myIndex - 1].style.display = "block";
//                setTimeout(carousel, 2000); // Change image every 2 seconds
//            }
//            
            function comparePrice()
            {
                var min = document.getElementById("txtMin").value;
                var max = document.getElementById("txtMax").value;

                if (min >= max)
                {
                    // Your code here
                   window.alert("Min < max please!");
                }
            }
        </script>
    </body>
</html>
