<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="us">
<head>
<meta charset="utf-8">
<title>Login Page</title>

<link rel="stylesheet" type="text/css" href="/resources/style/styleEa.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/jquery-ui-1.11.4/jquery-ui.css">
<script src="/resources/lib/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="/resources/lib/jquery-ui-1.11.4/jquery-ui.js"></script>

<link type="text/css" href="/resources/jquery-ui-ea/jquery-ui.css" rel="stylesheet">
<link type="text/css" href="/resources/style/normalize.css" rel="stylesheet">
<link type="text/css" href="/resources/style/styleNew.css" rel="stylesheet">
<script type="text/javascript" src="/resources/lib/jquery-ui-ea/external/jquery/jquery.js"></script>
<script type="text/javascript" src="/resources/lib/jquery-ui-ea/jquery-ui.js"></script>
<script type="text/javascript" src="/resources/js/scripts.js"></script>

</head>
<body>
	<header>
		<div class="banner">
			<img src="/resources/images/logo_unical.png" alt="Logo" />
			<div>Personal Information Manager</div>
		</div>
	</header>
	<div class="wrapper">
		<div class="front-page">
			<div class="center">
				<div class="front-welcome">
					<div class="front-welcome-text">
								<h1>Welcome on Idontknow.</h1>
						<div class="front-information-text">
								<p>Project Developed by:</p>
								Me<br>
								You<br>
								Him<br>
								Him
						</div>
					</div>
				</div>
					<div class="front-signin">
						<form class="loginform" action="#">
							<div class="username">
								<input class="text-field" type="text" name="username" placeholder="Username"/>
							</div>
							<div class="password">
								<input class="text-field" type="password" name="password" placeholder="Password"/>
								<a class="forgot" href="#">forgot your password?</a>
							</div>
							<div class="loginbutton">
								<input class="login" type="submit" value="login"/>
							</div>
							<div class="rememberforgot"> 
								<input type="checkbox" id="check" name="checkbox"> 
								<label for="checkbox">Remember</label>
							 </div>
						</form>
					</div> 
					<div class="front-register">
						<div class="text-register">
							If you want to register a new account click on the button below:
						</div>
							<div class="register-button">
								<button class="register">register</button>
							</div>
						
					</div>
				
			</div>
		</div>
	</div>
</body>
</html>