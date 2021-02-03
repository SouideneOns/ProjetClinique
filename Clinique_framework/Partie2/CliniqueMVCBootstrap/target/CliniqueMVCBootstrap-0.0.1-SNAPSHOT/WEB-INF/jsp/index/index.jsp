<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/logout" var="logoutURL"/>

<html>
<head>
<title>Landing Page</title>
<link
	href="https://fonts.googleapis.com/css?family=Abel|Montserrat|Patua+One"
	rel="stylesheet">

<style>
* {
	padding: 0;
	margin: 0;
}

body {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/image.jpg");
}

.gradient {
	width: 100%;
	height: 600px;
	background: #000;
	position: absolute;
	/* Permalink - use to edit and share this gradient: https://colorzilla.com/gradient-editor/#000000+0,000000+100&1+3,0+100 */
	background: -moz-linear-gradient(top, rgba(0, 0, 0, 1) 0%,
		rgba(0, 0, 0, 1) 3%, rgba(0, 0, 0, 0) 100%);
	/* FF3.6-15 */
	background: -webkit-linear-gradient(top, rgba(0, 0, 0, 1) 0%,
		rgba(0, 0, 0, 1) 3%, rgba(0, 0, 0, 0) 100%);
	/* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to bottom, rgba(0, 0, 0, 1) 0%,
		rgba(0, 0, 0, 1) 3%, rgba(0, 0, 0, 0) 100%);
	/* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#000000',
		endColorstr='#00000000', GradientType=0);
	/* IE6-9 */
}

.container {
	width: 1350px;
	height: 600px;
	position: relative;
	margin: 0 auto;
}

.header {
	width: 960px;
	padding: 20px;
}

nav>ul {
	position: absolute;
	right: 250px;
}

nav>ul>li {
	list-style: none;
	float: left;
	height: 40px;
	line-height: 40px;
}

nav>ul>li>a {
	text-decoration: none;
	font-family: 'Abel', sans-serif;
	color: #fff;
	font-weight: bold;
	font-size: 14px;
	padding: 0 20px 0 20px;
}

.btn {
	width: 130px;
	height: 40px;
	background: #237730;
	font-size: 16px;
	font-weight: bold;
	font-family: 'Abel', sans-serif;
	border: none;
	border-radius: 5px;
	color: #fff;
	position: absolute;
	right: 200;
}

.logo {
	color: #fff;
	font-family: 'Abel', sans-serif;
	font-size: 30px;
	position: absolute;
	right: 1100;
	padding: 20px;
}

.quote {
	color: #fff;
	font-family: 'Patua One', cursive;
	font-size: 50px;
	padding-left: 600px;
	position: relative;
	top: 100px;
}

.para {
	width: 500px;
	font-family: 'Montserrat', sans-serif;
	color: #fff;
	position: relative;
	top: 120px;
	padding-left: 600px;
}

.fly-in-text {
	list-style: none;
	position: absolute;
	left: 68%;
	top: 45%;
	font-size: 20px;
	transform: translateX(-50%) translateY(-50%);
}

.fly-in-text li {
	display: inline-block;
	margin-right: 30px;
	color: #fff;
	font-family: 'Patua One', cursive;
	font-weight: 300;
	font-size: 3em;
	opacity: 1;
	transition: all 2.5s ease;
}

.fly-in-text li:last-child {
	margin-right: 0;
}

.fly-in-text.hidden li {
	opacity: 0;
}

.fly-in-text.hidden li:nth-child(1) {
	transform: translateX(-200px) translateY(-200px);
}

.fly-in-text.hidden li:nth-child(2) {
	transform: translateX(20px) translateY(100px);
}

.fly-in-text.hidden li:nth-child(3) {
	transform: translateX(-150px) translateY(-80px);
}

.fly-in-text.hidden li:nth-child(4) {
	transform: translateX(10px) translateY(-200px);
}

.fly-in-text.hidden li:nth-child(5) {
	transform: translateX(-300px) translateY(200px);
}

.fly-in-text.hidden li:nth-child(6) {
	transform: translateX(-20px) translateY(-20px);
}

.fly-in-text.hidden li:nth-child(7) {
	transform: translateX(30px) translateY(200px);
}
</style>
</head>

<body>
	<div class="gradient"></div>
	<div class="container">
		<div class="logo">Clinique</div>
		<div class="header">
			<nav>
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Portfolio</a></li>
					<li><a href="#">About</a></li>
					<li><a href="${logoutURL }" style="position:relative;left:150px">Logout</a></li>
				</ul>
			</nav>
			<button class="btn">Contacts</button>
		</div>
		<ul class="fly-in-text hidden">
			<li style="color: #19713e;">B</li>
			<li style="color: #19713e;">E</li>
			<li style="color: #19713e;">.</li>
			<li>S</li>
			<li>A</li>
			<li>F</li>
			<li>E</li>

		</ul>
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