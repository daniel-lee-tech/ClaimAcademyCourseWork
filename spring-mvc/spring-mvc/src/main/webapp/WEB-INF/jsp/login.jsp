<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 11/3/2021
  Time: 1:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


</head>
<body>
<%@ include file="navbar.jsp" %>

<form:form method="post" action="/login" modelAttribute="newLogin" class="w-50 mx-auto">
    <c:if test="${badCredentials.equals(true)}">
        <div class="alert alert-danger" role="alert">
            Email or password is not correct
        </div>
    </c:if>
    <h3>Login</h3>

    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" />
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" />
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</body>
</html>
