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
	
<spring:url value="/logout" var="logoutURL" />
<spring:url value="/home" var="homeURL" />
<spring:url value="/medecin/list" var="listURL" />
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
		url("${pageContext.request.contextPath}/resources/images/image6.jpg");
	font-family: Roboto;
}

.container {
	position: relative;
	top: 60px;
	width:1024px;
	height: 50%;
}
.container2 {
    width: 100%;
    height: 180px;
    position: relative;
    margin: 0 auto;

}
   .btn {
    width: 100px;
    height: 40px;
    background: #237730;
    font-size: 16px;
    font-weight: bold;
    font-family: 'Abel', sans-serif;
    border: none;
    border-radius: 5px;
   
    text-align: center;
    top: 10px;
    position: absolute;
    right: 10px;
}

</style>
</head>

<body>

	<div class="gradient"></div>
   <div class="container2">
	<div class="nav">
			<div class="logo">Clinique</div>
			<ul class="mainMenu">
			<li class="subMenu"><a href="${profilURL }">Profil</a></li>
			<li class="subMenu"><a href="#">Services<span class="arrow arrowDown"></span></a>
					<ul class="mainMenu">
						<li class="subMenu" style="width: 200px;"><a href="${listURL}">Liste des docteurs</a></li>
						<li class="subMenu" style="width: 200px;"><a href="${RendezURL}">Rendez-vous</a></li>
						<li class="subMenu" style="width: 200px;"><a href="${newsURL }">Actualit� Corona</a>
					</ul></li>
			<li class="subMenu"><a href="${portfolioURL}">Portfolio</a></li>
			
			<li class="subMenu"><a href="${aboutURL }">About</a></li>
				<li class="subMenu"><a href="${homeURL }">Home</a></li>
			</ul>
			<button class="btn" type="submit">
				<a style="text-decoration: none; color: #fff;" href="${logoutURL }">Log Out</a>
			</button>
		</div>
        </div>
	<div class="container">
		<h1 style="color:black;text-decoration: underline;">Profil</h1>

		</br> </br>

		<form action="${pageContext.request.contextPath}/medecin/list3/search"
			method="POST" id="searchForm">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Veuillez entrer le N� Dossier"
					name="search" style="width: 500px;">
			</div>
		
			<button type="submit" class="btn btn-success"
				style="position: absolute; left: 15px; top:200px">Find </button>
		</form>

	
	

	</div>
	
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