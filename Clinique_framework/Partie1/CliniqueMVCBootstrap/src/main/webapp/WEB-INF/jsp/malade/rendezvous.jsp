<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/resources/css/style3.css" var="bootstrapMinCSSURL" />
<spring:url value="/resources/css/bootstrap-theme.min.css"
	var="bootstrapMinCSS2URL" />
<spring:url value="/resources/css/bootstrap.min.css"
	var="bootstrapMinCSS3URL" />
	
		<spring:url value="/medecin/list" var="listURL" />
<spring:url value="/home" var="homeURL" />

<spring:url value="/logout" var="logoutURL" />
<spring:url value="/medecin/list2" var="profilURL" />
<spring:url value="/user/portfolio" var="portfolioURL" />
<spring:url value="/news" var="newsURL" />
<spring:url value="/about" var="aboutURL" />
<spring:url value="/user/list4" var="RendezURL" />



<html>

<head>
<meta name="viewport" content="width=device-width , initial-scale=1">
<title>Rendez-vous</title>
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
		url("${pageContext.request.contextPath}/resources/images/image5.jpg");
	height: 100%;
	font-family: Roboto;
}
</style>
</head>

<body>
	<spring:url value="/user/submit2" var="submitURL" />
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
							href="${listURL}">Liste des docteurs</a></li>
						<li class="subMenu" style="width: 200px;"><a href="${RendezURL}">Rendez-vous</a></li>
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
		<h1
			style="color: white; position: absolute; top: 100px; left: 100px; text-decoration: underline;">Rendez-vous</h1>
		<form:form class="form-horizontal" id="validateForm"
			action="${submitURL}" modelAttribute="rendezForm" method="post"
			style="position:relative;top:200px;">
			
			<div class="row">
				<div class="col-md-offset-1 col-md-4"">
                      <form:hidden path="id"/>
					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;"
							class="control-label">CIN :</label>
						<p></p>
						<form:input path="CIN" name="num_cin" placeholder="CIN "
							class="form-control" type="text" />
					</div>
					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;"
							class="control-label">Full Name :</label>
						<p></p>
						<form:input path="full_name" name="full_name"
							placeholder="Full Name" class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="font-size: 16px; font-weight: bold;">Date de
							naissance :</label>
						<p></p>
						<form:input path="naissance" name="naissance"
							placeholder="Date de naissance" class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;">Rendez-vous
							?</label>
						<p></p>
						<div class="radio">
							<label><form:radiobutton path="type_rd"
									value="Appointment" />Appointment</label> <label
								style="margin-left: 10px;"><form:radiobutton
									path="type_rd" value="Analyzing" />Analyzing</label> <label
								style="margin-left: 20px;"><form:radiobutton
									path="type_rd" value="X-ray" />X-ray</label>
						</div>
					</div>

					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;"
							class="control-label">Nom Doctor :</label>
						<p></p>
						<form:input path="nom_doc" name="nom_doc" placeholder="Nom Doctor"
							class="form-control" type="text" />
					</div>









				</div>

				<div class="col-md-offset-1 col-md-4"">
					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;"
							class="control-label">Date :</label>
						<p></p>
						<form:input path="date" name="date"
							placeholder="Choisir un date et on va repondre"
							class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;"
							class="control-label">Heure :</label>
						<p></p>
						<form:input path="heure" name="heure"
							placeholder="Choisir l'heure et on va repondre"
							class="form-control" type="text" />
					</div>
					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;"
							class="control-label">Question : Vous avez quelq'un qui
							vit ailleurs et ou ? </label>
						<p></p>
						<form:textarea path="question" class="form-control"
							name="question" placeholder="Question : ..." />
						</textarea>
					</div>

					<div class="form-group">
						<label style="font-size: 16px; font-weight: bold;"
							class="control-label">Etat patient : </label>
						<p></p>
						<form:textarea path="etat" class="form-control" name="etat"
							placeholder="Etat patient" />
						</textarea>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-success"
							style="background-color: #19713e; postion: relative; top: 418px;">Submit</button>
							</div>
						<div class="form-group">
						<button type="submit" class="btn btn-success"
							style="background-color: #ca0037; position: relative; left: 200px;">Back</button>
					</div>


				</div>
			</div>

		</form:form>
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
							$('#validateForm')
									.bootstrapValidator(
											{

												fields : {

													cin_num : {
														validators : {
															numeric : {
																min : 8,
																message : 'Please Enter your Full cin with minimum 8 number'
															},
															notEmpty : {
																message : 'Please Enter your CIN'
															}
														}
													},
													full_name : {
														validators : {
															stringLength : {
																min : 5,
																message : 'Please Enter your Full name with minimum 5 letters length'
															},
															notEmpty : {
																message : 'Please Enter your Full name'
															}
														}
													},

													nom_doc : {
														validators : {

															notEmpty : {
																message : 'Please Enter the doctor name'
															}
														}
													},

													phone1 : {
														validators : {
															numeric : {
																message : 'The phone no must be a number'
															},
															notEmpty : {
																message : 'Please Enter your phone number'
															}
														}
													},
													phone2 : {
														validators : {
															numeric : {
																message : 'The phone no must be a number'
															},
															notEmpty : {
																message : 'Please Enter your phone number'
															}
														}
													},
													date : {
														validators : {
															stringLength : {
																message : 'Please enter a valid date'
															},
															notEmpty : {
																message : 'Please Enter date'
															}
														}
													},
													address : {
														validators : {
															stringLength : {
																min : 15,
																max : 100,
																message : 'Please enter at least 15 characters and no more than 100'
															},
															notEmpty : {
																message : 'Please Enter Address'
															}
														}
													},

													question : {
														validators : {

															notEmpty : {
																message : 'Please Answer the question'
															}
														}
													},

													gender : {
														validators : {
															notEmpty : {
																message : 'The gender option is required'
															}
														}
													},

													date : {
														validators : {
															stringLength : {
																message : 'Please enter a valid place'
															},
															notEmpty : {
																message : 'Please Enter date'
															}
														}
													},

													age : {
														validators : {
															numeric : {
																message : 'The age no must be a number'
															},
															notEmpty : {
																message : 'Please Enter your age'
															}
														}
													},
												}
											});

						});
	</script>
</body>

</html>