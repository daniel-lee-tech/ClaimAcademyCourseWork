<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Student Portal</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/cover/">

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="cover.css" rel="stylesheet">
</head>


<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Cover</h3>
            <%@ include file="navbar.jsp" %>

        </div>
    </header>

    <main role="main" class="inner cover">
        <form:form class="w-50 mx-auto" method="post" action="/signup" modelAttribute="student">

            <div class="form-row">
                <label for="inputFirstName">First Name</label>
                <form:input path="firstName" type="text" class="form-control" id="inputFirstName"/>
            </div>

            <div class="form-row">
                <label for="inputLastName">Last Name</label>
                <form:input path="lastName" type="text" class="form-control" id="inputLastName"/>
            </div>

            <div class="form-row">
                <label for="age">age</label>
                <form:input path="age" class="form-control"/>
            </div>

            <div class="form-row">
                <label for="inputEmail4">Email</label>
                <form:input path="email" type="email" class="form-control" id="inputEmail4"/>
            </div>

            <div class="form-row">
                <label for="inputPassword4">Password</label>
                <form:input path="password" type="password" class="form-control" id="inputPassword4"/>
            </div>

            <div class="form-row">
                <label for="inputAddress">Street</label>
                <form:input path="address.street" type="text" class="form-control" id="inputAddress"
                            placeholder="1234 Main St"/>
            </div>

            <div class="form-row">
                <label for="inputCity">City</label>
                <form:input path="address.city" type="text" class="form-control" id="inputCity"/>
            </div>

            <div class="form-row">
                <label for="inputState">State</label>
                <form:select path="address.state" id="inputState" class="form-control">
                    <option selected>Choose...</option>
                    <option value="NY">New York</option>
                    <option value="RI">Rhode Island</option>
                    <option value="ME">Maine</option>
                </form:select>
            </div>

            <div class="form-row">
                <label for="inputZip">Zip</label>
                <form:input path="address.zip" type="text" class="form-control" id="inputZip"/>
            </div>

<%--            <div class="form-row">--%>
<%--                <label for="number">Number</label>--%>
<%--                <form:input path="number" placeholder="some number like 2" type="number" class="form-control" id="number"/>--%>
<%--            </div>--%>


            <div class="form-row">
                <label for="number">Number without jsp</label>
                <input onchange="document.querySelector('#hiddenInput').value = this.value" placeholder="some number like 2" type="number" class="form-control" id="number"/>
            </div>

            <form:input id="hiddenInput" type="hidden" path="number" />

            <button type="submit" class="btn btn-primary">Sign up</button>
        </form:form>
    </main>

    <footer class="mastfoot mt-auto">
        <div class="inner">
            <p>Cover template for <a href="https://getbootstrap.com/">Bootstrap</a>, by <a
                    href="https://twitter.com/mdo">@mdo</a>.</p>
        </div>
    </footer>
</div>


</body>

</html>


