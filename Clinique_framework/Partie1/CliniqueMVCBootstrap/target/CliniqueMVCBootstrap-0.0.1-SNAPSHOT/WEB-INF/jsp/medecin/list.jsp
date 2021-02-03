<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/resources/css/style.css" var="bootstrapMinCSSURL" />
<spring:url value="/resources/css/bootstrap-theme.min.css"
	var="bootstrapMinCSS2URL" />
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapMinCSS3URL" />
<spring:url value="/home" var="homeURL" />
<spring:url value="medecin/list" var="listURL" />
<spring:url value="/logout" var="logoutURL" />
<spring:url value="/medecin/list2" var="profilURL" />
<spring:url value="/user/portfolio" var="portfolioURL" />
<spring:url value="/news" var="newsURL" />
<spring:url value="/about" var="aboutURL" />
<spring:url value="/user/list4" var="RendezURL" />

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
			<li class="subMenu"><a href="#">Services<span class="arrow arrowDown"></span></a>
					<ul class="mainMenu">
						<li class="subMenu" style="width: 200px;"><a href="${listURL}">Liste des docteurs</a></li>
						<li class="subMenu" style="width: 200px;"><a href="${RendezURL}">Rendez-vous</a></li>
						<li class="subMenu" style="width: 200px;"><a href="${newsURL }">Actualité Corona</a>
					</ul></li>
			<li class="subMenu"><a href="${portfolioURL}">Portfolio</a></li>
			
			<li class="subMenu"><a href="${aboutURL }">About</a></li>
				<li class="subMenu"><a href="${homeURL }">Home</a></li>
			</ul>
			<button class="btn" type="submit">
				<a style="text-decoration: none; color: #fff;" href="${logoutURL }">Log Out</a>
			</button>
		</div>


	<h1 style="color:white;position: absolute; top:100px;left:180px;text-decoration: underline;;">Medecin List</h1>

		</br> </br>

		<form action="${pageContext.request.contextPath}/medecin/list/search"
			method="POST">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search"
					name="search" style="width: 300px;position: absolute; top:210px;left:180px;">
			</div>
			<button type="submit" class="btn btn-success"
				style="position: absolute; left: 500px; top:207px;">Find Doctor</button>
		</form>

		</br> </br> </br> </br>
		<div class="table-responsive"style="position: absolute; top:280px;width:75% ; left:180px;" >

			<table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col"style="color:black;border:1px solid black">Full_name</th>
						<th scope="col"style="color:black;border:1px solid black">Spécialité</th>
						<th scope="col"style="color:black;border:1px solid black">Phone N°1</th>
						<th scope="col"style="color:black;border:1px solid black">Phone N°2</th>
						<th scope="col"style="color:black;border:1px solid black">Mail</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listMedecin}" var="medecin">
						<tr>
							<td style="border:1px solid black">${medecin.full_name }</td>
							<td style="border:1px solid black">${medecin.specialité }</td>
							<td style="border:1px solid black">${medecin.phone }</td>
							<td style="border:1px solid black">${medecin.phone2 }</td>
							<td style="border:1px solid black">${medecin.mail }</td>

						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script type="text/javascript">
		$(function() {
			setTimeout(function() {
				$('.fly-in-text').removeClass('hidden');
			}, 500);
		})();
	</script>
</body>

</html>