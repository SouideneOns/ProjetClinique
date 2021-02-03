<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/rendezvous/" var="homeURL" />
<spring:url value="/rendezvous/add" var="addURL" />
<spring:url value="/rendezvous/list" var="listURL" />


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
				<li class="dropdown ${rendezvousActive }"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">Rendez-Vous<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="${rendezvousListActive }"><a href="${listURL }">Liste
								des rendez-vous</a></li>
						<li class="${rendezvousAddActive }"><a href="${addURL }">Ajouter
								nouveau rendez-vous</a></li>
					</ul></li>
				<li><a href="#settings">Settings</a></li>
				<li><a href="#about">About</a></li>
			</ul>
		</div>
	</div>
</nav>