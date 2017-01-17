<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 16.01.2017
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="positions" scope="request" type="java.util.List"/>
<jsp:useBean id="userInfo" scope="request" type="entities.UserInfo"/>

<html>
<head>
    <title>Edit Profile</title>
    <link rel="stylesheet" type="text/css" href="../styles/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../styles/css/mainPage.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="col-md-offset-2 col-md-8">
    <form class="form-horizontal common-label" action="editProfile" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Name</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <input id="name" name="name" type="text" placeholder="Name" class="form-control input-md"
                     value="${userInfo.getName()}" required/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="surname">Surname</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <input id="surname" name="surname" type="text" placeholder="Surname" class="form-control input-md"
                    value="${userInfo.getSurname()}" required/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="bday">Bday</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-gift"></i>
                    </div>
                    <% String date = new SimpleDateFormat("yyyy-MM-dd").format(userInfo.getBday()); %>
                    <input id="bday" name="bday" type="text" placeholder="YYYY-MM-DD" class="form-control input-md"
                    value="<%=date%>" required/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="magazine">Magazine</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <input id="magazine" name="magazine" type="text" placeholder="Magazine" class="form-control input-md"
                    value="${userInfo.getMagazine()}"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="position">Position</label>
            <div class="col-md-6">
                <select id="position" name="position" class="input-xlarge shinima-select">
                    <option
                            <c:if test="${userInfo.getPositionId() == -1}">selected</c:if> value="-1"></option>
                    <c:forEach var="position" items="${positions}">
                        <option
                                <c:if test="${userInfo.getPositionId() == position.getId()}">selected</c:if> value="${position.getId()}">
                                ${position.getName()}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <!-- File Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="photo">Upload photo</label>
            <div class="col-md-6">
                <input id="photo" name="photo" class="input-file shinima-input-file" type="file">
            </div>
        </div>
        <hr/>
        <%--------------%>
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <input id="email" name="email" type="email" placeholder="Email" class="form-control input-md"
                    value="${user.getEmail()}" required/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">New Password</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-6">
                <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-thumbs-up"></span> Submit</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>