<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/malades/" var="homeURL" />
<spring:url value="/malades/add" var="addURL" />
<spring:url value="/malades/list" var="listURL" />


<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">

			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle Navigation</span> <span class="sr-only">Toggle
					navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>

		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown ${maladeActive }"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">Malades<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="${maladeListActive }"><a href="${listURL }">Liste
								Malades</a></li>
						<li class="${maladeAddActive }"><a href="${addURL }">Ajouter
								nouveau malade</a></li>
					</ul></li>
				<li><a href="#settings">Settings</a></li>
				<li><a href="#about">About</a></li>
			</ul>
		</div>
	</div>
</nav>