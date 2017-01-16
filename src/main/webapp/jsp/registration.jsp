<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 15.01.2017
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="textError" scope="request" type="java.lang.String"/>

<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="../styles/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../styles/css/mainPage.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <c:if test="${!textError.equals('')}">
        <div class="alert alert-danger" role="alert">${textError}</div>
    </c:if>
    <div>
        <div class="col-md-offset-4 col-md-4">
            <form action="registration" method="post" class="form-horizontal common-label">
                <div class="form-group">
                    <label for="inputName" class="col-md-3 control-label"><fmt:message key='name'/></label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="name" id="inputName" placeholder=<fmt:message key='name'/> required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputSurname" class="col-md-3 control-label"><fmt:message key='surname'/></label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="surname" id="inputSurname" placeholder=<fmt:message key='surname'/> required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-md-3 control-label"><fmt:message key='email'/></label>
                    <div class="col-md-9">
                        <input type="email" class="form-control" name="email" id="inputEmail" placeholder=<fmt:message key='email'/> required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputLogin" class="col-md-3 control-label"><fmt:message key='login'/></label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="login" id="inputLogin" placeholder=<fmt:message key='login'/> required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-md-3 control-label"><fmt:message key='password'/></label>
                    <div class="col-md-9">
                        <input type="password" class="form-control" name="password" id="inputPassword" placeholder=<fmt:message key='password'/> required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <button type="submit" class="btn btn-primary col-md-5"><fmt:message key='submit'/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
