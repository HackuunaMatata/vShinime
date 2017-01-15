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
    <link rel="stylesheet" type="text/css" href="../styles/css/bootstrap.css">
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
                    <label for="inputName" class="col-md-3 control-label">Name</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="name" id="inputName" placeholder="Name" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputSurname" class="col-md-3 control-label">Surname</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="surname" id="inputSurname" placeholder="Surname" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-md-3 control-label">Email</label>
                    <div class="col-md-9">
                        <input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputLogin" class="col-md-3 control-label">Login</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="login" id="inputLogin" placeholder="Login" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-md-3 control-label">Password</label>
                    <div class="col-md-9">
                        <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-9">
                        <button type="submit" class="btn btn-primary col-md-5">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
