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
				<ul class="nav navbar-nav">
					<li><a href="#about">About</a></li>
				</ul>
				<a class="btn btn-primary navbar-btn navbar-right" href="/logout">Logout</a>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div id="main" class="container">
		<img src="/resources/img/bannerV3.png" class="img-responsive"
			alt="Responsive image">
		<h1>Welcome ${username}</h1>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table table-bordered table-hover" id="tab_logic">
					<thead>
						<tr>
							<th class="text-center">#</th>
							<th class="text-center">Account type</th>
							<th class="text-center">Username/Mail</th>
							<th class="text-center">Password</th>
						</tr>
					</thead>
					<tbody>
						<tr id='addr0'>
							<td>1</td>
							<td><input type="text" name='name0' placeholder='Name'
								class="form-control" /></td>
							<td><input type="text" name='mail0' placeholder='Mail'
								class="form-control" /></td>
							<td><input type="text" name='mobile0' placeholder='Mobile'
								class="form-control" /></td>
						</tr>
						<tr id='addr1'></tr>
					</tbody>
				</table>
			</div>
		</div>
		<a id="add_row" class="btn btn-default pull-left">Add Row</a>
		<a id='delete_row' class="pull-right btn btn-default">Delete Row</a>
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
	
	<script src="/resources/js/scriptuserhome.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/resources/lib/bootstrap3/js/bootstrap.min.js"></script>
	
</body>
</html>