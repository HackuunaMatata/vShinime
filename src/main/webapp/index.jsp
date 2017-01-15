<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="loginError" scope="request" type="java.lang.String"/>

<html>
    <head>
        <title>vShinime</title>
        <link rel="stylesheet" type="text/css" href="styles/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="styles/css/mainPage.css">
    </head>
    <body>
    <%@ include file="jsp/header.jsp" %>
    <div>
        <div class="col-md-3">
            <c:if test="${!loginError.equals('')}">
                <div class="alert alert-danger" role="alert">${loginError}</div>
            </c:if>
            <form action="login" method="post" class="form-horizontal common-label">
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
                        <button type="submit" class="btn btn-primary col-md-5">Sign In</button>
                        <a href="registration" type="button" class="btn btn-default pull-right col-md-5">Sign Up</a>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-8 info">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus nam perspiciatis quae quod saepe. Ab, asperiores dignissimos eaque error ex ipsa laudantium magni maiores nobis quidem quod sapiente sed ut velit vero. Ad commodi delectus deserunt eaque eius expedita fugit illo impedit iste iure iusto maiores nihil officia optio porro provident quas recusandae reiciendis, reprehenderit saepe sed similique soluta sunt suscipit temporibus ut voluptatibus voluptatum! Doloribus ea, eligendi facere id, incidunt ipsam necessitatibus provident qui quis recusandae sequi vitae! Consequuntur deleniti deserunt est inventore sapiente, sequi sit tempora voluptate voluptatem voluptatibus. Ab debitis deleniti ducimus eum exercitationem, fuga quaerat. Blanditiis dolorem facilis quod saepe sequi. Alias architecto beatae blanditiis deleniti doloremque eaque esse exercitationem expedita hic illo maxime molestias natus nemo non obcaecati officiis, optio quidem quod, rem reprehenderit repudiandae sunt suscipit temporibus veniam voluptas? Cumque debitis deserunt doloremque, eius esse eum id impedit ipsum laudantium minus optio quidem suscipit velit. Aut cupiditate doloribus ducimus enim eos et eum facere facilis illum inventore magnam molestiae nam, neque, nihil nobis numquam praesentium quis, quos reprehenderit vero. Aspernatur consectetur dolorum ex in ipsum iure odit, repellendus temporibus vero voluptate? Aut autem facilis soluta? Culpa debitis eveniet nesciunt quis totam? Animi aperiam asperiores aspernatur consequuntur eligendi et ex ipsa laudantium molestias odio, odit quibusdam quidem suscipit! Aspernatur culpa dolorem ipsum minus placeat repudiandae sint ut! Accusantium ad animi consequuntur delectus doloribus exercitationem explicabo fugit impedit iste molestiae natus, neque nobis numquam quod recusandae reiciendis reprehenderit saepe sequi sit tenetur unde, velit voluptas voluptatibus?
        </div>
    </div>
    </body>
</html>
