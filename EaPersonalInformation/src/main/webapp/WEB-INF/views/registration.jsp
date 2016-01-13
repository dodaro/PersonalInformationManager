<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>EaKeyring Registration Page</title>

<!-- Bootstrap -->
<link href="/resources/lib/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/style/stylecolors.css" rel="stylesheet">
<link href="/resources/style/styleart.css" rel="stylesheet">
<link href="/resources/lib/bootstrap3/datepicker/css/bootstrap-datepicker3.min.css"
	rel="stylesheet">
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
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img alt="Brand" height="30px"
					src="/resources/img/logoV1.png">
				</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#about">About</a></li>
				</ul>

			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<div id="main" class="container">
		<img src="/resources/img/bannerV3.png" class="img-responsive"
			alt="Responsive image">
		<h2 id="titlelogin" class="text-center">Register here</h2>
		<c:if test="${not empty userexerror}">
			<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>Warning!</strong> Email already exists! Please change email address.
		</div>
		</c:if> 
		<form:form class="form-register" action="#" method="POST" commandName="userForm">
			<fieldset class="fsStyle">
				<legend class="legendStyle">Account Informations:</legend>
				<div class="row">
					<spring:bind path="email">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="inputEmail"> 
								Email address 
							</label> 
							<form:input path="email" type="email" id="inputEmail" class="form-control"
								placeholder="Email address" required="true" autofocus="true" /> 
							<form:errors path="email" id="error" class="help-block"/>
						</div>
					</spring:bind>
					<spring:bind path="confirmEmail">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="inputConfirmEmail">
								Confirm Email 
							</label> 
							<form:input path="confirmEmail" type="email" id="inputConfirmEmail"
								class="form-control" placeholder="Confirm Email" required="true" /> 
							<form:errors path="confirmEmail" id="error" class="help-block"/>
						</div>
					</spring:bind>
				</div>
				<div class="row">
					<spring:bind path="password">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="password">Password</label> 
							<form:input path="password" type="password" id="password" class="form-control"
								placeholder="Password" required="true" /> 
							<form:errors path="password" id="error" class="help-block" />
						</div>
					</spring:bind>
					<spring:bind path="confirmPassword">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="confirmPassword">
								Confirm Password
							</label> 
							<form:input path="confirmPassword" type="password" id="confirmPassword"
								class="form-control" placeholder="Confirm Password" required="true" />
							<form:errors path="confirmPassword" id="error" class="help-block" />
						</div>
					</spring:bind>
				</div>
			</fieldset>
			<fieldset class="fsStyle">
				<legend class="legendStyle">Personal Informations:</legend>
				<div class="row">
					<spring:bind path="firstname">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="firstname"> First Name </label>
							<form:input path="firstname" type="text" id="firstname" class="form-control"
								placeholder="First Name" required="true" /> 
							<form:errors path="firstname" id="error" class="help-block" />
						</div>
					</spring:bind>
					<spring:bind path="lastname">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="lastname"> Last Name </label> 
							<form:input path="lastname" type="text" id="lastname" class="form-control"
								placeholder="Last Name" required="true" /> 
							<form:errors path="lastname" id="error" class="help-block" />
						</div>
					</spring:bind>
				</div>
				<div class="row">
					<spring:bind path="dateOfBirth">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="birthDate">Birth Date</label>
							<div class="input-group date">
								<form:input path="dateOfBirth" type="text" id="birthDate" class="form-control"
									placeholder="Birth Date" required="true" /> 
								<span class="input-group-addon"> 
									<i class="glyphicon glyphicon-calendar"></i>
								</span>
							</div>
							<form:errors path="dateOfBirth" id="error" class="help-block" />
						</div>
					</spring:bind>
					<spring:bind path="gender">
						<div class="form-group col-xs-6 col-md-3 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="gender">Gender</label> 
							<form:select path="gender" id="gender" class="form-control">
								<form:option value="Male">Male</form:option>
								<form:option value="Female">Female</form:option>
							</form:select> 
							<form:errors path="gender" id="error" class="help-block" />
						</div>
					</spring:bind>
				</div>
				<div class="row">
					<spring:bind path="phonenumber">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="phoneNumber">Phone Number</label> 
								<form:input path="phonenumber" type="tel" id="phoneNumber" class="form-control"
									placeholder="Phone Number"/> 
								<form:errors path="phonenumber" id="error" class="help-block" />
						</div>
					</spring:bind>
					<spring:bind path="creditcard">
						<div class="form-group col-md-6 ${status.error ? 'has-error' : ''}">
							<label class="control-label" for="creditCard">Credit Card</label>
							<form:input path="creditcard" type="text" id="creditCard" class="form-control"
								placeholder="Credit Card" /> 
							<form:errors path="creditcard" id="error" class="help-block" />
						</div>
					</spring:bind>
				</div>

			</fieldset>
			
			<!--
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> Remember me
	          </label>
        	</div>
			-->
			<br>
			<button class="btn btn-lg btn-success btn-primary btn-group-justified"
				type="submit">Register</button>
		
<%-- 		<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<form:errors path="*" class="has-error" />
		</div> --%>
		</form:form>
		<%-- <div id="inner">${error}</div> --%>
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
	<script
		src="/resources/lib/bootstrap3/datepicker/js/bootstrap-datepicker.min.js"></script>
	<script
		src="/resources/lib/bootstrap3/datepicker/locales/bootstrap-datepicker.it.min.js"></script>
	<script src="/resources/js/scripts.js"></script>
</body>
</html>