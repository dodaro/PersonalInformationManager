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
	<link href="/resources/lib/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
	<link href="/resources/style/stylecolors.css" rel="stylesheet">
	<link href="/resources/style/styleart.css" rel="stylesheet">
	<link href="/resources/lib/bootstrap3/datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet">
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
		<img src="/resources/img/bannerV2.png" class="img-responsive" alt="Responsive image">
		<h2 id="titlelogin" class="text-center">Register here</h2>
		<form class="form-register">
			<div class="form-group col-md-6">
				<label for="firstname">
					First Name
				</label>
				<input type="text" id="firstname" class="form-control" placeholder="First Name" required autofocus>
			</div>
			
			<div class="form-group col-md-6">
				<label for="lastname">
					Last Name
				</label>
				<input type="text" id="lastname" class="form-control" placeholder="Last Name" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="inputEmail">
					Email address
				</label>
				<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required >
			</div>
			
			<div class="form-group col-md-6">
				<label for="inputConfirmEmail">
					Confirm Email
				</label>
				<input type="email" id="inputConfirmEmail" class="form-control" placeholder="Confirm Email" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="password">Password</label>
				<input type="password" id="password" class="form-control" placeholder="Password" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="confirmPassword">Confirm Password</label>
				<input type="password" id="confirmPassword" class="form-control" placeholder="Confirm Password" required>
			</div>
			
			<div class="form-group col-md-6">
				<label for="phoneNumber">Phone Number</label>
				<input type="tel" id="phoneNumber" class="form-control"
							 placeholder="Phone Number" required>
			</div>
				<div class="form-group col-xs-6 col-md-3">
					<label for="gender">Gender</label>
					<select id="gender" class="form-control">
						<option>Male</option>
						<option>Female</option>
					</select>
				</div>
<!--
			<div id="genderCheckbox" class="form-group col-md-6">
				<label class="col-sm-4">Gender:</label>
						<div id="checkborder" class="col-sm-2">
							<div class="radio">
								<label>
									<input type="radio" name="optionsRadios" id="maleRadio"
												 value="male" checked> 
										Male
								</label>
							</div>
							<div class="radio">
								<label>
									<input type="radio" name="optionsRadios" id="femaleRadio"
												 value="Female"> 
										Female
								</label>
							</div>
						</div>
			</div>
-->				
			<div class="form-group col-xs-6 col-md-3">
				<label for="phone">I dont konw</label>
				<input type="tel" id="phoneNumber" class="form-control"
							 placeholder="Phone Number">
			</div>
			<div class="form-group col-md-6">
				<label for="birthDate">Birth Date</label>
				<div class="input-group date">
    				<input type="text" id="birthDate" class="form-control" 
							 placeholder="Birth Date">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-calendar"></i>
					</span>
				</div>
			</div>
			<div class="form-group col-md-6">
				<label for="creditCard">Credit Card</label>
				<input type="text" id="creditCard" class="form-control"
							 placeholder="Credit Card">
			</div>
			<!--
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
-->
<!--
			
-->
		<br>
			<button class="btn btn-lg btn-success btn-primary btn-group-justified" type="submit">
				Register
			</button>
			</form>
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
	<script src="/resources/lib/bootstrap3/datepicker/js/bootstrap-datepicker.min.js"></script>
	<script src="/resources/lib/bootstrap3/datepicker/locales/bootstrap-datepicker.it.min.js"></script>
	<script src="/resources/js/scripts.js"></script>
</body>
</html>