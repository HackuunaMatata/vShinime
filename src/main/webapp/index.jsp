<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="usersList" scope="request" type="java.util.List"/>
<jsp:useBean id="title" scope="request" type="java.lang.String"/>

<html>
    <body>
    <h2>Hello World!</h2>

    <div>
        <ul>
            <li>
                <h1>${title}</h1>
            </li>
            <hr/>
            <c:forEach var="user" items="${usersList}">
                <li>
                    ${user.getLogin()}&nbsp;${user.getPassword()}&nbsp;${user.getEmail()}
                </li>
            </c:forEach>
        </ul>
    </div>

    </body>
</html>
