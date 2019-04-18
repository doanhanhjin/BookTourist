<%-- 
    Document   : categoryManager
    Created on : Mar 25, 2019, 9:35:24 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CATEGORY MANAGER!</h1>
        <form action="CategoryManagerController" method="POST">
            <input type="submit" value="View Category" name="action" />
        </form>
        <c:if test="${requestScope.LIST_CATEGORY}">
        
    </c:if>
    </body>
</html>
