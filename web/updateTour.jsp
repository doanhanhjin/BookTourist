<%-- 
    Document   : updateTour
    Created on : Mar 28, 2019, 6:49:40 PM
    Author     : user
--%>

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
                height: 1100px;
                padding: 80px 40px;
                box-sizing: border-box;
                background: rgba(0,0,0,.5);
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
            input[type="checkbox"] {
                width: 20%;
            }
        </style>
    </head>
    <body>
        <a class="a" href="NullController">HOME</a>
        <div class="contact-form">
        <h1>Update TOURs Page!</h1>
        <p>${requestScope.SUCCESS_UPDATE_TOUR}</p>
        <form action="TourManagerController" method="POST">
            <p>Id</p><input type="text" name="txtId" value="${requestScope.TOUR_DTO.id}" readonly="readonly"/><br/><br/>
            <p>Name</p><input type="text" name="txtName" value="${requestScope.TOUR_DTO.name}" required="required"/><br/><br/>
            <p>Description</p><input type="text" name="txtDescription" value="${requestScope.TOUR_DTO.description}"  required="required" /><br/><br/>
            <p>Price</p><input type="number" name="txtPrice" value="${requestScope.TOUR_DTO.price}"  required="required" /><br/><br/>
            <p>Start Date</p><input type="date" name="txtStartDate" value="${requestScope.TOUR_DTO.startDate}"  required="required" /><br/><br/>
            <p>End Date</p><input type="date" name="txtEndDate" value="${requestScope.TOUR_DTO.endDate}"  required="required" /><br/><br/>
            <p>Participant Number</p><input type="number" name="txtParticipantNumber" value="${requestScope.TOUR_DTO.participantNumber}"readonly="readonly" id="txtParticipantNumber" min="0" /><br/><br/>
            <p>Max Participant Number</p><input type="number" name="txtMaxParticipantNumber" value="${requestScope.TOUR_DTO.maxParticipantNumber}" required="required"  id="txtMaxParticipantNumber" onblur="compareParticipant();"/><br/><br/>
            <p>Image</p><input type="text" name="txtImage" value="${requestScope.TOUR_DTO.image}"  required="required" /><br/><br/>
            <p>Category Id</p><input type="number" name="txtCategoryId" value="${requestScope.TOUR_DTO.categoryId}"  required="required" /><br/><br/>
            <p>Status</p><input type="text" name="txtStatus" value="${requestScope.TOUR_DTO.status}"  required="required" /><br/><br/>
            <input type="submit" value="Update" name="action" />
        </form>
            </div>
            <script>
                function compareParticipant()
            {
                var min = document.getElementById("txtParticipantNumber").value;
                var max = document.getElementById("txtMaxParticipantNumber").value;

                if (min >= max)
                {
                    // Your code here
                   window.alert("Participant Number < Max Participant Number please!");
                }
            }
            </script>
    </body>
</html>
