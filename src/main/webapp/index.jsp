<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="loginError" scope="request" type="java.lang.String"/>

<html>
    <head>
        <title>vShinime</title>
        <link rel="stylesheet" type="text/css" href="styles/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="styles/css/mainPage.css">
    </head>
    <body>
    <%@ include file="jsp/header.jsp" %>
    <div>
        <div class="col-md-4">
            <c:if test="${!loginError.equals('')}">
                <div class="alert alert-danger" role="alert">${loginError}</div>
            </c:if>
            <form action="login" method="post" class="form-horizontal common-label">
                <div class="form-group">
                    <label for="inputLogin" class="col-md-3 control-label"><fmt:message key='login'/></label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="login" id="inputLogin" placeholder="<fmt:message key='login'/>" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-md-3 control-label"><fmt:message key='password'/></label>
                    <div class="col-md-9">
                        <input type="password" class="form-control" name="password" id="inputPassword" placeholder="<fmt:message key='password'/>" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <button type="submit" class="btn btn-primary col-md-5"><fmt:message key='signIn'/></button>
                        <a href="registration" type="button" class="btn btn-default pull-right col-md-5"><fmt:message key='signUp'/></a>
                    </div>
                </div>
            </form>
        </div>
        <div style="text-align: center;" class="col-md-7 info">
            <h3><fmt:message key='mainTitle'/></h3>
            <h5><fmt:message key='mainText'/></h5>
        </div>
    </div>
    </body>
</html>
