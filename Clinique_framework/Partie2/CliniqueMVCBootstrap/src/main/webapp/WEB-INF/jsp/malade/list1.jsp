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
<spring:url value="/rendezvous/add" var="add1URL" />
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

	<h1
		style="color: white; position: absolute; top: 140px; left: 80px; text-decoration: underline;">Liste
		des rendez-vous</h1>
<div class="container" style="top: 50px;">
	<form
		action="${pageContext.request.contextPath}/rendezvous/list/search"
		method="POST">
		<div class="row">
			<div class="col-md-offset-1 col-md-4">
				<div class="form-group">
					<input type="text" class="form-control"
						placeholder="chercher rendez-vous" name="search"
						style="position: absolute; width: 380px; height: 50px;" />
				</div>
			</div>
			<div class="col-md-offset-1 col-md-4">
				<button type="submit" class="btn btn-success"
					style="position: absolute; right: 480px;">chercher</button>
			</div>
			<div class="col-md-offset-1 col-md-4">
				<button type="button" class="btn btn-success"
					style="position: absolute; right: 370px;"
					onClick="location.href='${add1URL }'">Ajouter</button>
			</div>
		</div>
	</form>

	<div class="container">
		<div class="table-responsive"
			style="position: absolute; top: 50px; width: 95%">
			<table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>

						<th scope="col"
							style="border: 1px solid black; color: #DBE2E4; text-align: center">Full_name</th>

						<th scope="col"
							style="border: 1px solid black; color: #DBE2E4; text-align: center">Date</th>
						<th scope="col"
							style="border: 1px solid black; color: #DBE2E4; text-align: center">Heure</th>
						<th scope="col"
							style="border: 1px solid black; color: #DBE2E4; text-align: center">Etat</th>

						<th colspan="2"
							style="border: 1px solid black; color: #DBE2E4; text-align: center">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listRendezVous }" var="rendezvous">
						<tr>

							<td>${rendezvous.full_name }</td>
							<td>${rendezvous.date }</td>
							<td>${rendezvous.heure }</td>
							<td>${rendezvous.etat }</td>

							<td><spring:url value="/rendezvous/update/${rendezvous.id }"
									var="updateURL" />
								<button type="button" class="btn btn-link"
									onClick="location.href='${updateURL }'">Modifier</button></td>
							<td><spring:url value="/rendezvous/delete/${rendezvous.id }"
									var="deleteURL" />
								<button type="button" class="btn btn-danger"
									onClick="location.href='${deleteURL }'">Supprimer</button></td>

						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</div>
</body>

</html>