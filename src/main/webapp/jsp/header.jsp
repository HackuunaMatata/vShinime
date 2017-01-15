<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 15.01.2017
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" type="entities.Users"/>

<header class="navbar navbar-default shinima-header">
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">vShinime</a>
        </div>
        <c:if test="${user.getLogin() != null}">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">${user.getLogin()}</a>
            </div>
        </c:if>

        <c:if test="${user.getLogin() != null}">
            <ul class="nav navbar-nav">
                <li><a href="profile">Profile</a></li>
                <li><a href="friends">Friends</a></li>
                <li><a href="logout">Exit</a></li>
            </ul>
        </c:if>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">РУС</a></li>
            <li><a href="#">ENG</a></li>
        </ul>
    </div>
</header>