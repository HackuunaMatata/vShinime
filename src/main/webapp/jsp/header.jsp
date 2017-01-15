<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 15.01.2017
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" type="entities.Users"/>

<header class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">vShinime</a>
        </div>
        <c:if test="${user.getLogin()!=null}">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">${user.getLogin()}</a>
            </div>
        </c:if>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Main Page</a></li>
                <li><a href="#">Profile</a></li>
            </ul>
            <c:if test="${user.getLogin() != null}">
                <ul class="nav navbar-nav">
                    <li><a href="logout">Exit</a></li>
                </ul>
            </c:if>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">РУС</a></li>
                <li><a href="#">ENG</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</header>