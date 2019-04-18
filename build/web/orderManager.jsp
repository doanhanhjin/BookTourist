<%-- 
    Document   : orderManager
    Created on : Mar 25, 2019, 9:36:49 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ORDER MANAGER!</h1>
        <form action="OrderManagerController" method="POST">
            <input type="text" name="txtSearch" value="" />
            <input type="submit" value="Search" name="action" />
        </form>
    </body>
</html>
