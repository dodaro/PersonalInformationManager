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
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary navbar-btn" 
						data-toggle="modal" data-target="#myModal">
		  				Add Account
				</button>
				<a class="btn btn-primary navbar-btn navbar-right" href="/logout">Logout</a>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div id="main" class="container">
		<img src="/resources/img/bannerV3.png" class="img-responsive"
			alt="Responsive image">
		<div class="text-center">
			<h1>Welcome ${username}</h1>
		</div>
		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
			<br />
			<spring:hasBindErrors name="accountForm">
				<c:forEach var="error" items="${errors.allErrors}">
					<b><spring:message message="${error}" /></b>
					<br />
				</c:forEach>
    		</spring:hasBindErrors>
		    </div>
		</c:if>
		 
		<form:form method="POST" commandName="accountForm">
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">Add New Account</h4>
		      </div>
		      <div class="modal-body">
		      	<div class="row">
	        		<div class="form-group col-md-3">
						<label class="control-label" for="accname">Name of Account:</label> 
						<form:input type="text" path="accountname" class="form-control" id="accname" 
							required="true" autofocus="true" />
					</div>
						<%-- <div class="form-group col-xs-6 col-md-3 ${status.error ? 'has-error' : ''}"> --%>
					<div class="form-group col-md-3">
						<label class="control-label" for="type">Account type</label> 
						<form:select path="type" id="type" class="form-control">
							<form:option value="facebook">Facebook</form:option>
							<form:option value="twitter">Twitter</form:option>
						</form:select> 
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-3">
						<label class="control-label" for="usr">Username:</label> 
						<form:input path="username" type="text" class="form-control" id="usr" />
					</div>
					<div class="form-group col-md-3">
						<label for="pwd">Password:</label> 
						<form:input path="password" type="password" class="form-control" id="pwd" />
					</div>
				</div>
				<div class="form-horizontal">
					<div class="form-group">
						<div class="col-md-6">
							<form:textarea path="notes" class="form-control" rows="3" placeholder="Notes" />
						</div>
					</div>
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <input type="submit" class="btn btn-primary" value="Save" /> 
		      </div>
		    </div>
		  </div>
		</div>
		</form:form>
		
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