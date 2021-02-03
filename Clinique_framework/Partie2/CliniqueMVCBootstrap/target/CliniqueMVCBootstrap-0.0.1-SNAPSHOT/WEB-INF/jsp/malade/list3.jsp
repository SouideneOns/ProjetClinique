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
<spring:url value="/rendezvous/list" var="list1URL" />
<spring:url value="/logout" var="logoutURL" />
<spring:url value="/malades/list4" var="profilURL" />
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
				<li class="subMenu"><a href="#">Services<span
						class="arrow arrowDown"></span></a>
					<ul class="mainMenu">
						<li class="subMenu" style="width: 200px;"><a
							href="${listURL}">Malades</a></li>
						<li class="subMenu" style="width: 200px;"><a
							href="${list1URL }">Rendez-vous</a></li>
						<li class="subMenu" style="width: 200px;"><a
							href="${contactURL }">Contact</a></li>
						<li class="subMenu" style="width: 200px;"><a
							href="${newsURL }">Actualité Corona</a></li>
					</ul></li>
				<li class="subMenu"><a href="${portfolioURL}">Portfolio</a></li>

				<li class="subMenu"><a href="${aboutURL }">About</a></li>
				<li class="subMenu"><a href="${homeURL }">Home</a></li>
			</ul>
			<button class="btn2" type="submit"
				style="text-decoration: none; color: #fff;"
				onClick="location.href='${logoutURL }'">LogOut</button>
		</div>

	</div>
	
		<h1 style="color: white; position: absolute; top: 150px; left: 80px; text-decoration: underline;">Profil</h1>

		<div class="container" style="top: 60px;">
		<div class="table-responsive"
			style="position: absolute; width: 95%">
			<table class="table table-bordered table-striped">
				<thead class="thead-dark">
						<tr>					
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">CIN</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Full_name</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Gender</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Date</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Place</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Age</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Phone N°1</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Phone N°2</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Adress</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Mail</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Specialité</th>
						<th scope="col"style="border: 1px solid black; color: #DBE2E4; text-align: center">Immatricule</th>
						
						

					</tr>
				</thead>
			<tbody>
					<c:forEach items="${listMedecin}" var="medecin">
						<tr>
							<td style="border:1px solid black">${medecin.CIN }</td>
							<td style="border:1px solid black">${medecin.full_name }</td>
							<td style="border:1px solid black">${medecin.gender }</td>
							<td style="border:1px solid black">${medecin.date }</td>
							<td style="border:1px solid black">${medecin.age }</td>
							<td style="border:1px solid black">${medecin.place }</td>
							<td style="border:1px solid black">${medecin.phone }</td>
							<td style="border:1px solid black">${medecin.phone2 }</td>
							<td style="border:1px solid black">${medecin.mail }</td>
							<td style="border:1px solid black">${medecin.address }</td>
							<td style="border:1px solid black">${medecin.specialité }</td>
							<td style="border:1px solid black">${medecin.immatricule }</td>
							

						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</body>
</html>