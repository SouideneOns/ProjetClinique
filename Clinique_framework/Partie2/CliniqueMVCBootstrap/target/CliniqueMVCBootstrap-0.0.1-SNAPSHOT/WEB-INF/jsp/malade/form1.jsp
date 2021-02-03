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


<html>

<head>
<meta name="viewport" content="width=device-width , initial-scale=1">
<title>Form</title>
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
	font-family: Roboto;
}

.container {
	position: relative;
	top: 80px;
}

.container2 {
	width: 1020px;
	height: 20px;
	position: relative;
	margin: 0 auto;
}
</style>

</head>
<body>
	<spring:url value="/rendezvous/save" var="saveURL" />
	<div class="gradient"></div>
	<div class="container2">
		<div class="logo">Clinique</div>

	</div>
	<div class="container">
		<form:form class="form-horizontal" id="validateForm"
			action="${saveURL}" modelAttribute="rendezvousForm" method="post">
			<div class="row">
				<div class="col-md-offset-1 col-md-4">
					<div class="form-group">
						<form:input path="id" name="id" class="form-control" type="hidden" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Nom et Prénom :</label>

						<form:input path="full_name" name="full_name"
							placeholder="Nom et prénom" class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">CIN :</label>

						<form:input path="CIN" name="CIN" placeholder="carte d'identité"
							class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Date de
							naissance :</label>
						<form:input path="naissance" name="phone"
							placeholder="Date de naissance" class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Nom du docteur :</label>
						<form:textarea path="nom_doc" class="form-control" name="etat"
							placeholder="Nom du docteur" />
						</textarea>
					</div>


				</div>
				<div class="col-md-offset-1 col-md-4">

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Date de
							rendez_vous :</label>
						<form:input path="date" name="date"
							placeholder="date de rendez-vous" class="form-control"
							type="text" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Heure de
							rendez_vous:</label>
						<form:input path="heure" name="heure"
							placeholder="Heure de rendez-vous" class="form-control"
							type="text" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Type de
							rendez_vous :</label>
						<form:input path="type_rd" name="etat"
							placeholder="type de rendez_vous" class="form-control"
							type="text" />
					</div>

					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Etat :</label>
						<form:input path="etat" name="etat" placeholder="Etat du patient"
							class="form-control" type="text" />
					</div>
					<div class="form-group">
						<label class="control-label"
							style="color: #ecf9ec; font-size: 16px;">Question:</label>
						<form:input path="question" name="groupe"
							placeholder="Insérer votre question" class="form-control"
							type="text" />
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-success"
							style="background-color: #19713e; left: 100px;">Submit</button>
						<button type="submit" class="btn btn-success"
							style="background-color: #ca0037; left: 260px;">Back</button>
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

													heure : {
														validators : {
															stringLength : {
																message : 'Please enter a valid hour'
															},
															notEmpty : {
																message : 'Please Enter hour'
															}
														}
													},
													etat : {
														validators : {
															stringLength : {
																message : 'Please enter a valid state'
															},
															notEmpty : {
																message : 'Please Enter state'
															}
														}
													},
												}
											});

						});
	</script>
</body>

</html>