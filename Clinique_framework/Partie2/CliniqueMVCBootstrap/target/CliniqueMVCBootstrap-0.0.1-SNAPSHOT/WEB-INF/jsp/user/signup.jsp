<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/resources/css/main2.css" var="bootstrapMinCSSURL" />
<spring:url value="/resources/js/jquery-3.3.1.min.js"
	var="bootstrapMinJSURL" />
<spring:url value="/resources/js/main.js" var="bootstrapMinJSURL2" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Abel|Montserrat|Patua+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,500"
	rel="stylesheet">
<link rel="stylesheet" href="${bootstrapMinCSSURL }">

<title>Login</title>
<style>
body {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/image2.jpg");
}

.checkbox input:checked ~ span:before {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/check.png");
	background-size: cover;
}
</style>
</head>
<body>
<body>
	<spring:url value="/user/register" var="registerURL" />
	<div class="gradient"></div>
	<div class="container">
		<div class="logo">Clinique</div>

		<div class="align">
			<img class="logo2"
				src="${pageContext.request.contextPath}/resources/images/logo2.png">
			<div class="card">
				<div class="head">
					<div></div>
					<a id="login" class="selected">SignUp</a>

					<div></div>
				</div>
				<div class="tabs">
					<form:form action="${registerURL}" modelAttribute="userForm"
						method="post">
						<div class="inputs">
							<div class="input">
								<form:input path="username" placeholder="Username" type="text" />
								<form:errors path="username" cssClass="error" />
								<img
									src="${pageContext.request.contextPath}/resources/images/user.png">
							</div>
							<div class="input">
								<form:password path="password" placeholder="CIN" />
								<form:errors path="password" cssClass="error" />
								<img
									src="${pageContext.request.contextPath}/resources/images/pass.png">
							</div>
							<div class="input">
								<form:password path="confirmPassword" placeholder="Confirm CIN" />
								<form:errors path="confirmPassword" cssClass="error" />
								<img
									src="${pageContext.request.contextPath}/resources/images/pass.png">
							</div>
						</div>

						<div>
							<button type="submit">Register</button>
							<a class="forgot"
								href="${pageContext.request.contextPath}/login">sign in ?</a>
						</div>
					</form:form>


				</div>
			</div>
		</div>
		<script src="${bootstrapMinJSURL }"></script>
		<script src="${bootstrapMinJSURL2 }"></script>
	</div>

</body>
</html>