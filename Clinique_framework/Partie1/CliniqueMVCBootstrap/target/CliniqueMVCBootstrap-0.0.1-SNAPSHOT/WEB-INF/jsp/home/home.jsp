<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/logout" var="logoutURL" />
<spring:url value="/home" var="homeURL" />
<spring:url value="medecin/list" var="listURL" />

<spring:url value="/medecin/list2" var="profilURL" />
<spring:url value="/user/portfolio" var="portfolioURL" />
<spring:url value="/news" var="newsURL" />
<spring:url value="/about" var="aboutURL" />
<spring:url value="/user/list4" var="RendezURL" />

<html>

<head>
<title>Landing Page</title>
<link
	href="https://fonts.googleapis.com/css?family=Abel|Montserrat|Patua+One"
	rel="stylesheet">

<style>
* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
	text-decoration: none;
	outline: none;
	border: none;
}

body {
	background-image:
		url("${pageContext.request.contextPath}/resources/images/image.jpg");
	height: 100%;
	font-family: Roboto;
}

.gradient {
	width: 100%;
	height: 600px;
	background: #000;
	position: absolute;
	/* Permalink - use to edit and share this gradient: https://colorzilla.com/gradient-editor/#000000+0,000000+100&1+3,0+100 */
	/* Permalink - use to edit and share this gradient: https://colorzilla.com/gradient-editor/#000000+0,000000+100&0.6+7,0+100 */
	background: -moz-linear-gradient(top, rgba(0, 0, 0, 0.6) 0%,
		rgba(0, 0, 0, 0.6) 7%, rgba(0, 0, 0, 0) 100%); /* FF3.6-15 */
	background: -webkit-linear-gradient(top, rgba(0, 0, 0, 0.6) 0%,
		rgba(0, 0, 0, 0.6) 7%, rgba(0, 0, 0, 0) 100%);
	/* Chrome10-25,Safari5.1-6 */
	background: linear-gradient(to bottom, rgba(0, 0, 0, 0.6) 0%,
		rgba(0, 0, 0, 0.6) 7%, rgba(0, 0, 0, 0) 100%);
	/* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#99000000',
		endColorstr='#00000000', GradientType=0); /* IE6-9 */
}

.container {
	width: 1020px;
	height: 600px;
	position: relative;
	margin: 0 auto;
}

nav>ul {
	position: absolute;
	right: 150px;
}

ul>li {
	position: relative;
}

nav>ul>li {
	list-style: none;
	height: 40px;
	line-height: 40px;
	display: inline-block;
}

nav>ul>li>a {
	text-decoration: none;
	font-family: 'Abel', sans-serif;
	color: #fff;
	font-weight: bold;
	font-size: 14px;
	padding: 0 20px 0 20px;
	display: inline-block;
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
	right: 0;
}

.logo {
	color: #fff;
	font-family: 'Abel', sans-serif;
	font-size: 30px;
	position: absolute;
	padding: 20px;
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
	width: 100%;
	height: 600px;
	position: relative;
	margin: 0 auto;
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

* {
	margin: 0;
	padding: 0;
}

.logo {
	color: #fff;
	font-family: 'Abel', sans-serif;
	font-size: 30px;
	position: absolute;
	padding: 10px;
	left: 20px
}

.nav {
	width: 100%;
	height: 60px;
	background-color: transparent;
	box-shadow: rgba(0, 0, 0, 0.2) 0 2px 6px 0;
}

.mainMenu {
	list-style-type: none;
}

.mainMenu .subMenu {
	float: right;
	width: 100px;
	height: 60px;
	font-size: 20px;
	line-height: 60px;
	text-align: center;
	right: 120px;
}

.mainMenu .subMenu a {
	text-decoration: none;
	color: #fff;
	display: block;
	font-family: 'Abel', sans-serif;
}

.mainMenu .subMenu a:hover {
	background-color: #237730;
	transition: 1s all ease;
}

.mainMenu .subMenu .mainMenu .subMenu {
	display: none;
	background-color: #000;
	box-shadow: rgba(0, 0, 0, 0.2) 0 2px 6px 0;
	height: 60px;
	transition: 1s all;
	font-family: 'Abel', sans-serif;
	left: 0px;
}

.mainMenu .subMenu:hover .mainMenu .subMenu {
	display: block;
	transition: 1s all;
	animation: drop 1s ease;
}

@
keyframes drop { 0%{
	transform: scale(2, 2) rotateX(90deg);
}

100%{
transform
:
 
scale
(1
,
1)
rotateX
(0deg);

        
}
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
	color: #fff;
	text-align: center;
	top: 10px;
	position: absolute;
	right: 10px;
}
.nav .arrow{
display:inline-block;
border: 2px solid white;
width:8px;
height:8px;
border-left:none;
border-bottom:none;
position : relative;
right:0;
margin-left:10px;
}
.nav .arrow.arrowDown{
transform:rotateZ(135deg) translate(0px , 3px);
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
		 <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			setTimeout(function() {
				$('.fly-in-text').removeClass('hidden');
			}, 500);
		})();
	</script>
</body>

</html>