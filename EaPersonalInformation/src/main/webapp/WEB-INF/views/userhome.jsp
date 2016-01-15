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
<link href="/resources/lib/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/style/stylecolors.css" rel="stylesheet">
<link href="/resources/style/styleart.css" rel="stylesheet">
<link href="/resources/style/social-buttons-3.css" rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
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
				
			</div>
		</div>
		<button type="button" class="btn btn-default pull-left"
			data-toggle="modal" data-target="#myModal">Add Account</button>

		<a id='delete_row' class="pull-right btn btn-default">Delete
			Account</a>

		<div id="myModal" class="modal fade" role="dialog">
			<div class="modal-dialog ">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<!--  <a id="add_row" class="btn btn-default pull-right">Add Row</a>-->
						<p>Add Your Account Here</p>
						<!--	/container -->
						<div id="contact_page">
							<div class="container">
								<div class="row">
									<div class="form-group col-md-6">
										<label for="usr">URL:</label> <input type="text"
											class="form-control" id="usr">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-3">
										<label for="usr">Username:</label> <input type="text"
											class="form-control" id="usr">
									</div>
									<div class="form-group col-md-3">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" id="pwd">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-3">
										<label for="usr">Name of Account:</label> <input type="text"
											class="form-control" id="usr">
									</div>
								</div>


								<div class="form-horizontal">
									<div class="form-group">
										<div class="col-md-6">
											<textarea class="form-control" rows="3"
												placeholder="Notes" required></textarea>
										</div>
									</div>
								</div>
						
						<button type="button" class="btn btn-default" data-dismiss="modal">Add</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						
							</div>
						</div>
					</div>


					<!--  <a class="btn btn-social-icon btn-twitter">
  <span class="fa fa-twitter"></span>
</a>
      -->
				</div>
				<div class="modal-footer">
					
				</div>
			</div>

		</div>
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