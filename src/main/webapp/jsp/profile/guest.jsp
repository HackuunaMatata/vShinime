<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 16.01.2017
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="/WEB-INF/formatTag" %>

<jsp:useBean id="friend" scope="request" type="entities.Users"/>
<jsp:useBean id="userInfo" scope="request" type="entities.UserInfo"/>
<jsp:useBean id="position" scope="request" type="java.lang.String"/>
<jsp:useBean id="articles" scope="request" type="java.util.List"/>
<jsp:useBean id="locale" scope="session" type="java.util.Locale"/>

<html>
<head>
    <title>Your colleague</title>
    <link rel="stylesheet" type="text/css" href="../../styles/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../styles/css/mainPage.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="row user-info">
    <div class="col-sm-6 col-md-4 user-photo">
        <c:if test="${!userInfo.getPhoto().equals(\"null\")}">
            <img width="200" height="200" src="images/${userInfo.getPhoto()}"/>
        </c:if>
        <c:if test="${userInfo.getPhoto().equals(\"null\")}">
            <img width="200" height="200" src="../../images/default.png"/>
        </c:if>
    </div>
    <div class="col-sm-6 col-md-8 info big-text">
        <h2>${userInfo.getName()} ${userInfo.getSurname()}</h2>
        <small><cite title="job">${userInfo.getMagazine()}, ${position} <i class="glyphicon glyphicon-folder-close">
        </i></cite></small>
        <p>
            <i class="glyphicon glyphicon-envelope"></i> ${friend.getEmail()}
            <br/>
            <i class="glyphicon glyphicon-gift"></i>
            <ct:dateFormat format="dd MMMMM, yyyy" date="${userInfo.getBday()}" locale="${locale}"/>
            <br/>
            <br/>
            <a class="btn btn-info" href="dialog?id=${friend.getId()}"><fmt:message key='sendMessage'/></a>
        </p>
    </div>
</div>
<div class="row articles">
    <c:forEach var="article" items="${articles}">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <div class="caption">
                    <h3>${article.getTitle()}</h3>
                    <small><cite title="date">${article.getDate()} <i class="glyphicon glyphicon-file">
                    </i></cite></small>
                    <p>${article.getAnnotation()}</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>

