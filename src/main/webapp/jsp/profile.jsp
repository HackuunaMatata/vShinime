<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 15.01.2017
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="userInfo" scope="request" type="entities.UserInfo"/>
<jsp:useBean id="position" scope="request" type="java.lang.String"/>
<jsp:useBean id="articles" scope="request" type="java.util.List"/>

<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="../styles/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../styles/css/mainPage.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="row user-info">
    <div class="col-sm-6 col-md-4 user-photo">
        <img width="200" height="200" src="../images/${userInfo.getPhoto() ? userInfo.getPhoto() : "default.png"}"/>
    </div>
    <div class="col-sm-6 col-md-8 info big-text">
        <h2>${userInfo.getName()} ${userInfo.getSurname()}</h2>
        <small><cite title="job">${userInfo.getMagazine()}, ${position} <i class="glyphicon glyphicon-gift">
        </i></cite></small>
        <p>
            <i class="glyphicon glyphicon-envelope"></i>${user.getEmail()}
            <br/>
            <% String date = new SimpleDateFormat("dd MMMMM, yyyy").format(userInfo.getBday()); %>
            <i class="glyphicon glyphicon-text-color"></i><%=date%>
            <br/>
        </p>
    </div>
</div>
<div class="row articles">
    <c:forEach var="article" items="${articles}">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <div class="caption">
                    <h3>${article.getTitle()}</h3>
                    <small><cite title="date">${article.getDate()}<i class="glyphicon glyphicon-gift">
                    </i></cite></small>
                    <p>${article.getAnnotation()}</p>
                    <div>
                        <a href="#" class="btn btn-info" role="button">Edit Information</a>
                        <a href="#" class="btn btn-primary pull-right" role="button">Delete Article</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</div>

</body>
</html>
