<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/resources/css2/style2.css" var="bootstrapMinCSSURL" />
<spring:url value="/resources/css/bootstrap-theme.min.css"
	var="bootstrapMinCSS2URL" />
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapMinCSS3URL" />
<spring:url value="/home" var="homeURL" />
<spring:url value="/malades/list" var="listURL" />
<spring:url value="/malades/add" var="addURL" />
<spring:url value="/malades/list4" var="contactURL" />
<spring:url value="/rendezvous/list" var="list1URL" />
<spring:url value="/logout" var="logoutURL" />
<spring:url value="/malades/list2" var="profilURL" />
<spring:url value="/user/portfolio" var="portfolioURL" />
<spring:url value="/malades/list4" var="contactURL" />
<spring:url value="/news" var="newsURL" />
<spring:url value="/about" var="aboutURL" />

<html>

<head>
<meta name="viewport" content="width=device-width , initial-scale=1">
<title>List</title>
<link rel="stylesheet" href="bootstrap.min.css" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Abel|Montserrat|Patua+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,500"
	rel="stylesheet">
<link rel="stylesheet" href="${bootstrapMinCSS2URL }" type="text/css">
<link rel="stylesheet" href="${bootstrapMinCSS3URL }" type="text/css">
<link rel="stylesheet" href="${bootstrapMinCSSURL }" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

<style>
body {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/image7.png");
	height: 100%;
	font-family: Roboto;
}
</style>
</head>

<body>
	<div class="gradient"></div>
	<div class="container">
		<div class="nav">
			<div class="logo">Clinique</div>
			<ul class="mainMenu">
				<li class="subMenu"><a href="${profilURL }">Profil</a></li>
				<li class="subMenu"><a href="${homeURL }">Home</a></li>
			</ul>
			<button class="btn2" type="submit"
				style="text-decoration: none; color: #fff;"
				onClick="location.href='${logoutURL }'">LogOut</button>
		</div>

	</div>

	<h1
		style="color: white; position: absolute; top: 200px; left: 180px; text-decoration: underline;">Profil</h1>

	</br>
	</br>

	<form action="${pageContext.request.contextPath}/malades/list3/search"
		method="POST" id="searchForm">
		<div class="row">
			<div class="col-md-offset-1 col-md-4">
				<div class="form-group">
					<input type="text" class="form-control"
						placeholder="chercher profil" name="search"
						style="position: absolute; width: 450px; height: 50px;" />
				</div>
			</div>
			<div class="col-md-offset-1 col-md-4">
				<button type="submit" class="btn btn-success"
					style="position: absolute; right: 520px; height: 50px;width: 100px;">chercher</button>
			</div>
		</div>
	</form>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#searchForm')
									.bootstrapValidator(
											{

												fields : {

													search : {
														validators : {
															stringLength : {
																min : 8,
																message : 'Please Enter your number with minimum 8 letters/numbers length'
															},
															notEmpty : {
																message : 'Please Enter your number'
															}

														}
													},

												}
											});

						});
	</script>

</body>
</html>