<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/resources/css2/style.css" var="bootstrapMinCSSURL" />
<spring:url value="/resources/css/bootstrap-theme.min.css"
	var="bootstrapMinCSS2URL" />
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapMinCSS3URL" />

<spring:url value="/home" var="homeURL" />
<spring:url value="/malades/list" var="listURL" />
<spring:url value="/rendezvous/list" var="list1URL" />
<spring:url value="/logout" var="logoutURL" />
<spring:url value="/malades/list2" var="profilURL" />
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

<style>
body {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/image3.jpg");
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
			<button class="btn" type="submit">
				<a style="text-decoration: none; color: #fff;" href="${logoutURL }">Log
					Out</a>
			</button>
		</div>





	</div>
	<h1
		style="color: white; position: absolute; top: 180px; left: 80px; text-decoration: underline;">Health
		News</h1>
	<div class="container2"
		style="position: absolute; left: 80px; top: 280px;">


		<div class="row">
			<div class="col-md-4">
				<div class="single-blog">
					<p class="blog-meta">
						By Admin <span>April 29, 2020</span>
					</p>
					<img
						src="${pageContext.request.contextPath}/resources/images/news.png">
					<h2>
						<a href="#">Our first news</a>
					</h2>
					<p class="blog-text">This is our first news Click to learn more
					</p>
					<p>
						<a href="" class="read-more-btn">Read more</a>
					</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="single-blog">
					<p class="blog-meta">
						By Admin <span>April 29, 2020</span>
					</p>
					<img
						src="${pageContext.request.contextPath}/resources/images/news.png">
					<h2>
						<a href="#">Our first news</a>
					</h2>
					<p class="blog-text">This is our first news Click to learn more
					</p>
					<p>
						<a href="" class="read-more-btn">Read more</a>
					</p>
				</div>
			</div>
			<div class="col-md-4">
				<div class="single-blog">
					<p class="blog-meta">
						By Admin <span>April 29, 2020</span>
					</p>
					<img
						src="${pageContext.request.contextPath}/resources/images/news.png">
					<h2>
						<a href="#">Our first news</a>
					</h2>
					<p class="blog-text">This is our first news Click to learn more
					</p>
					<p>
						<a href="" class="read-more-btn">Read more</a>
					</p>
				</div>
			</div>
		</div>
		<br></br> <br></br>
	</div>

</body>

</html>