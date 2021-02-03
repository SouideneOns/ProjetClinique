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
	<spring:url value="/malades/save" var="saveURL" />
	<div class="gradient"></div>
	<div class="container2">
		<div class="logo">Clinique</div>
		<div class="header">
		
		</div>
	</div>
	<div class="container">
		<form:form class="form-horizontal" id="validateForm"
			action="${saveURL}" modelAttribute="maladeForm" method="post">
			<div class="row">
				<div class="col-md-offset-1 col-md-4">
					<div class="form-group">
						<form:input path="id" name="id"
							 class="form-control" type="hidden" />
					</div>
					
					<div class="form-group">
						<label class="control-label">Nom et Prénom :</label>
						<form:input path="full_name" name="full_name"
							placeholder="Nom et prénom" class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label class="control-label">CIN :</label>
						<form:input path="CIN" name="cin_num" placeholder="CIN"
							class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label>Sex</label>
						<div class="radio">
							<label><form:radiobutton path="gender" value="MALE" />MALE</label>
						</div>
						<div class="radio">
							<label><form:radiobutton path="gender" value="FEMALE" />FEMALE</label>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label">Date et place de naissance :</label>
						<form:input path="date_place" name="date"
							placeholder="Date de naissance" class="form-control" type="text" />
					</div>
					<div class="form-group">
						<label class="control-label">Age :</label>
						<form:input path="age" name="age" placeholder="Votre Age"
							class="form-control" type="text" />
					</div>

					<div class="form-group">
						<label class="control-label">Address :</label>
						<form:textarea path="address" class="form-control" name="address"
							placeholder="Address..." />
						</textarea>
					</div>



				</div>

				<div class="col-md-offset-1 col-md-4">

					<div class="form-group">
						<label class="control-label">No de télèphone1 :</label>
						<form:input path="phone1" name="phone"
							placeholder="No de télèphone1" class="form-control" type="text" />
					</div>
					<div class="form-group">
						<label class="control-label">No de télèphone2 :</label>
						<form:input path="phone2" name="phone"
							placeholder="No de télèphone2" class="form-control" type="text" />
					</div>




					<div class="form-group">
						<label class="control-label">Groupe Sanguin :</label>
						<form:input path="grs" name="groupe"
							placeholder="Insérer votre groupr sanguin" class="form-control"
							type="text" />
					</div>

					<div class="form-group">
						<label class="control-label">Maladies :</label>
						<form:textarea path="maladies" class="form-control" name="etat"
							placeholder="Maladies" />
						</textarea>
					</div>
					<div class="form-group">
						<label class="control-label">Traitements :</label>
						<form:textarea path="traitements" class="form-control" name="etat"
							placeholder="Traitements" />
						</textarea>
					</div>
					<div class="form-group">
						<label class="control-label">Remarques :</label>
						<form:textarea path="question" class="form-control" name="etat"
							placeholder="vos remarques" />
						</textarea>
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
													username_name : {
														validators : {
															stringLength : {
																min : 5,
																message : 'Please Enter your Full name with minimum 5 letters length'
															},
															notEmpty : {
																message : 'Please Enter your username'
															}
														}
													},
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
													phone : {
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
													
																message : 'Please Enter your Full age'
															},
															notEmpty : {
																message : 'Please Enter your CIN'
															}
														}
													},
												}
											});

						});
	</script>
</body>

</html>