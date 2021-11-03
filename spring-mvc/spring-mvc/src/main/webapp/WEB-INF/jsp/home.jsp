<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 11/3/2021
  Time: 1:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<header>
    <%@ include file="navbar.jsp" %>

</header>

<main>
    <h1>
        All students
    </h1>

    <c:forEach items="${allStudents}" var="loopedStudent">
        <div class="card">
            firstName: ${loopedStudent.firstName}
            <br>
            lastName: ${loopedStudent.lastName}
            <br>
            email: ${loopedStudent.email}
        </div>
    </c:forEach>
</main>

</body>
</html>
