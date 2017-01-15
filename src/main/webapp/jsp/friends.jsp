<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 15.01.2017
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="friends" scope="request" type="java.util.List"/>

<html>
<head>
    <title>Friends</title>
    <link rel="stylesheet" type="text/css" href="../styles/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../styles/css/mainPage.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="table-friends">
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Magazine</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="friend" items="${friends}">
            <tr>
                <td>${friend.getName()}</td>
                <td>${friend.getSurname()}</td>
                <td>${friend.getMagazine()}</td>
                <td>
                    <a class="btn btn-info" href="">Send Message</a>
                    <a class="btn btn-warning" href="guest?id=${friend.getId()}">Show Profile</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
