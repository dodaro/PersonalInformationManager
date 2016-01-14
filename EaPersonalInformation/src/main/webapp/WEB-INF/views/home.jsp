<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>EaKeyring Home Page</title>

	<!-- Bootstrap -->
	<link href="/resources/lib/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/style/stylecolors.css" rel="stylesheet">
	<link href="/resources/style/styleart.css" rel="stylesheet">
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" 
								data-target="#navbar" aria-expanded="false" 
								aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">
					<img alt="Brand" height="30px" src="/resources/img/logoV1.png">
				</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
            <li><a href="#about">About</a></li>
				</ul>
				<form:form class="navbar-form navbar-right" action="login" method="POST" commandName="userLogin">
					<div class="form-group">
						<form:input type="email" id="email" path="email" placeholder="Email" 
									 class="form-control" required="true" autofocus="true" />
					</div>
					<div class="form-group">
						<form:input path="password" id="password" type="password" 
								placeholder="Password" class="form-control" required="true" />
					</div>
					<button type="submit" class="btn btn-primary"> Login </button>
					<a class="btn btn-primary" href="/registration">Register</a>
				</form:form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div id="main" class="container">
		<img src="/resources/img/bannerV3.png" class="img-responsive"
				 alt="Responsive image">
		<div class="jumbotron">
			<h1>Welcome</h1>
				<p>This is a project made in the EA Course developed
						by:
				</p>
					<ul id="autList" class="list-unstyled">
						<strong>
							<li>Arturo Guerrisi</li>
							<li>You</li>
							<li>Somebody</li>
							<li>Everybody</li>
						</strong>
					</ul>
		</div> 
				<!--	jambotron-->
		<hr>
	</div> 	 
				<!--	/container -->
<!--
	<div class="container">
		 Example row of columns 
		<hr>
		</div>	
-->
	<!-- /container -->

		<footer class="footer">
      <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
      </div>
    </footer>
	

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/resources/lib/bootstrap3/jquery/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/resources/lib/bootstrap3/js/bootstrap.min.js"></script>
</body>
</html>