<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="/WEB-INF/datetimeTag" %>
<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 17.01.2017
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lastMessages" scope="request" type="java.util.List"/>

<html>
<head>
    <title>Messages</title>
    <link rel="stylesheet" type="text/css" href="../../styles/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../styles/css/mainPage.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="col-md-offset-3 col-md-6">
    <c:forEach var="message" items="${lastMessages}">
        <div class="panel panel-default shinima-messages">
            <div class="panel-title">
                <div class="col-md-offset-1 col-md-7">${message.getColleague()}</div>
                <div class="col-md-4 message-time">
                    <small><ct:datetimeFormat format="dd.MM HH:mm:ss" datetime="${message.getDate()}"/> <i
                            class="glyphicon glyphicon-time"></i></small>
                </div>
            </div>
            <a href="dialog?id=${message.getColleagueId()}">
                <div class="panel-body">
                    <div class="col-md-1">
                        <small>${message.getFrom()}</small>
                    </div>
                    <div class="col-md-10 last-message">${message.getMessage()}</div>
                    <div class="col-md-1"><span class="label label-primary badge">${message.getCountUnreaded()}</span>
                    </div>
                </div>
            </a>
        </div>
    </c:forEach>
</div>

</body>
</html>
