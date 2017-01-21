<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="/WEB-INF/datetimeTag" %>
<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 18.01.2017
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="nMessages" scope="request" type="java.util.List"/>
<jsp:useBean id="guest" scope="request" type="entities.UserInfo"/>
<jsp:useBean id="userInfo" scope="request" type="entities.UserInfo"/>

<html>
<head>
    <title>Dialog</title>
    <link rel="stylesheet" type="text/css" href="../../styles/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../styles/css/mainPage.css">
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="container shinima-dialog">
                    <c:forEach var="message" items="${nMessages}">
                        <div class="row message-bubble
                                <c:if test="${message.getId_from()==user.getId()}">message-bubble-dark</c:if>
                                <c:if test="${message.getId_from()==guest.getId()}">message-bubble-light</c:if>">
                            <p class="text-muted"><i>
                                <c:if test="${message.getId_from()==user.getId()}">${userInfo.getName()} ${userInfo.getSurname()}</c:if>
                                <c:if test="${message.getId_from()==guest.getId()}">${guest.getName()} ${guest.getSurname()}</c:if>
                            </i></p>
                            <span>${message.getText()}</span>
                            <small class="pull-right time"><i
                                    class="fa fa-clock-o"></i><ct:datetimeFormat format="dd.MM HH:mm:ss"
                                                                                 datetime="${message.getDatetime()}"/>
                            </small>
                        </div>
                    </c:forEach>
                </div>
                <div class="panel-footer">
                    <form action="dialog" method="post">
                        <div class="input-group">
                            <input id="guestId" name="guestId" type="hidden" value="${guest.getId()}"/>
                            <input id="text" name="text" type="text" class="form-control" required/>
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="submit"><fmt:message key='send'/></button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
