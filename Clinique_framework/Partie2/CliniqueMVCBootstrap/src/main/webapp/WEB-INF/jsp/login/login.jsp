<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css/main.css" var="bootstrapMinCSSURL" />
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
	<div class="gradient"></div>
	<div class="container">
		<div class="logo">Clinique</div>
		<div class="header">
			
		</div>
		<div class="align">
			<img class="logo2"
				src="${pageContext.request.contextPath}/resources/images/logo.png">
			<div class="card">
				<div class="head">
					<div></div>
					<a id="login" class="selected">Login</a>

					<div></div>
				</div>
				<div class="tabs">
					<form name="loginForm"
						action='<c:url value="j_spring_security_check" />' method="post">
						<div class="inputs">
							<div class="input">
								<input placeholder="Username" type="text" name="username">
								<img
									src="${pageContext.request.contextPath}/resources/images/user.png">
							</div>
							<div class="input">
								<input type="password" placeholder="CIN" name="password">
								<img
									src="${pageContext.request.contextPath}/resources/images/pass.png">
							</div>
							<label class="checkbox"> <input type="checkbox">
								<span>Remember me</span>
							</label>
						</div>

						<div>
							<button type="submit">Login</button>
							<a class="forgot"
								href="${pageContext.request.contextPath}/user/signup">don't
								have an account ?</a>
						</div>
					</form>


				</div>
			</div>
		</div>
		<script src="${bootstrapMinJSURL }"></script>
		<script src="${bootstrapMinJSURL2 }"></script>
	</div>

</body>
</html>