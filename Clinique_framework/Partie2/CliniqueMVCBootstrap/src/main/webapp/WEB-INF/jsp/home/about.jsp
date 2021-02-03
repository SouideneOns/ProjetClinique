<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/resources/css2/style2.css" var="bootstrapMinCSSURL" />
<spring:url value="/resources/css/bootstrap-theme.min.css"
	var="bootstrapMinCSS2URL" />
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapMinCSS3URL" />
<spring:url value="/home" var="homeURL" />
<spring:url value="/malades/list" var="listURL" />
<spring:url value="/malades/add" var="addURL" />
<spring:url value="/rendezvous/list" var="list1URL" />
<spring:url value="/logout" var="logoutURL" />
<spring:url value="/malades/list2" var="profilURL" />
<spring:url value="/malades/list4" var="contactURL" />
<spring:url value="/user/portfolio" var="portfolioURL" />
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
				<li class="subMenu"><a href="#">Services<span
						class="arrow arrowDown"></span></a>
					<ul class="mainMenu">
						<li class="subMenu" style="width: 200px;"><a
							href="${listURL}">Malades</a></li>
						<li class="subMenu" style="width: 200px;"><a
							href="${list1URL }">Rendez-vous</a></li>
						<li class="subMenu" style="width: 200px;"><a
							href="${contactURL }">Contact</a>
						<li class="subMenu" style="width: 200px;"><a
							href="${newsURL }">Actualité Corona</a>
					</ul></li>
				<li class="subMenu"><a href="${portfolioURL}">Portfolio</a></li>

				<li class="subMenu"><a href="${aboutURL }">About</a></li>
				<li class="subMenu"><a href="${homeURL }">Home</a></li>
			</ul>
			<button class="btn2" type="submit">
				<a style="text-decoration: none; color: #fff;" href="${logoutURL }">Log
					Out</a>
			</button>
		</div>





	</div>
	<h1
		style="color: white; position: absolute; top: 230px; left: 80px; text-decoration: underline;">About
		Us</h1>
	<div class="container2"
		style="position: absolute; left: 80px; top: 280px; width: 85%">


		<section id="aboutus">

			<br></br>
			<div class="container3" style="color: black;">
				<div class="row">
					<div class="col-sm-7">
						<h4 style="color: black; font-weight: bold;">Clinique
							Intelligent</h4>
						<p>Hypertext Markup Language (HTML) is the standard markup
							language for documents designed to be displayed in a web browser.
							It can be assisted by technologies such as Cascading Style Sheets
							(CSS) and scripting languages such as JavaScript.</p>
						<p>Hypertext Markup Language (HTML) is the standard markup
							language for documents designed to be displayed in a web browser.
							It can be assisted by technologies such as Cascading Style Sheets
							(CSS) and scripting languages such as JavaScript.</p>
					</div>
					<div class="col-sm-5">
						<div class="img-wrap">
							<img
								src="${pageContext.request.contextPath}/resources/images/hospital.png">
						</div>
					</div>
				</div>
			</div>
		</section>
		<section
			style="position: absolute; top: 500px; width: 90%; left: 70px;">
			<div class="contact-info">
				<div class="card">
					<i class="card-icon far fa-envelope"></i>
					<p>clinique@domain.com</p>
				</div>

				<div class="card">
					<i class="card-icon fas fa-phone"></i>
					<p>+216 000 000 00</p>
				</div>

				<div class="card">
					<i class="card-icon fas fa-map-marker-alt"></i>
					<p>Sousse , Tunisie</p>
				</div>

			</div>
			<br></br> <br></br>


		</section>

	</div>

</body>

</html>