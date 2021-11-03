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
    <title>Title</title>
</head>
<body>
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


</body>
</html>
