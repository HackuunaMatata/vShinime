<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 15.01.2017
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="/WEB-INF/formatTag" %>

<jsp:useBean id="userInfo" scope="request" type="entities.UserInfo"/>
<jsp:useBean id="position" scope="request" type="java.lang.String"/>
<jsp:useBean id="articles" scope="request" type="java.util.List"/>
<jsp:useBean id="locale" scope="session" type="java.util.Locale"/>

<html>
<head>
    <title>Profile</title>
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
            <i class="glyphicon glyphicon-envelope"></i> ${user.getEmail()}
            <br/>
            <i class="glyphicon glyphicon-gift"></i>
            <ct:dateFormat format="dd MMMMM, yyyy" date="${userInfo.getBday()}" locale="${locale}"/>
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
                    <small><cite title="date">${article.getDate()} <i class="glyphicon glyphicon-book">
                    </i></cite></small>
                    <p>${article.getAnnotation()}</p>
                    <div class="article-buttons">
                        <a href="editArticles?title=${article.getTitle()}" class="btn btn-info col-sm-6 col-md-5" role="button"><fmt:message key='editInformation'/></a>
                        <a href="deleteArticle?id=${article.getUserId()}&title=${article.getTitle()}" class="btn btn-primary pull-right col-sm-6 col-md-5" role="button"><fmt:message key='deleteArticle'/></a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
            <div class="caption add-article">
                <a href="addArticles" role="button">
                <img height="150" width="150" src="../../images/add_article.png"/>
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
