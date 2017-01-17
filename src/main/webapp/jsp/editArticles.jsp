<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: HackuunaMatata
  Date: 16.01.2017
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="article" scope="request" type="entities.Articles"/>

<html>
<head>
    <title>Edit Articles</title>
    <link rel="stylesheet" type="text/css" href="../styles/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../styles/css/mainPage.css">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="col-md-offset-2 col-md-8">
    <form class="form-horizontal common-label"
            <c:if test="${!article.getTitle().equals(\"\")}"> action="editArticles" </c:if>
            <c:if test="${article.getTitle().equals(\"\")}"> action="addArticles" </c:if>
          method="post">
        <div class="form-group">
            <label class="col-md-4 control-label" for="title">Title</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <c:if test="${!article.getTitle().equals(\"\")}">
                        <input id="title" name="title" type="hidden" placeholder="Title" class="form-control input-md"
                        value="${article.getTitle()}">
                    </c:if>
                    <input id="newTitle" name="newTitle" type="text" placeholder="Title" class="form-control input-md"
                           value="${article.getTitle()}"
                            <c:if test="${!article.getTitle().equals(\"\")}"> disabled </c:if> required/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="annotation">Annotation</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-user"></i>
                    </div>
                    <textarea id="annotation" name="annotation" placeholder="Annotation" rows="5"
                              class="form-control input-md" required>${article.getAnnotation()}</textarea>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="date">Date</label>
            <div class="col-md-6">
                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="glyphicon glyphicon-gift"></i>
                    </div>
                    <% String date = new SimpleDateFormat("yyyy-MM-dd").format(article.getDate()); %>
                    <input id="date" name="date" type="text" placeholder="YYYY-MM-DD" class="form-control input-md"
                           value="<%=date%>" required/>
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
