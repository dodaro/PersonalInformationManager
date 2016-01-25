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
<link href="/resources/style/social-buttons-3.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

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
				<a href="<c:url value='/userhome?edit=new' />"
					class="btn btn-primary navbar-btn">Add Account</a>
				<button type="button" class="btn btn-primary navbar-btn"
					data-toggle="modal" data-target="#userDetailsModal">User
					Details</button>

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
				<strong>${msg}</strong> <br />
				<spring:hasBindErrors name="accountForm">
					<c:forEach var="error" items="${errors.allErrors}">
						<b><spring:message message="${error}" /></b>
						<br />
					</c:forEach>
				</spring:hasBindErrors>
			</div>
		</c:if>

		<div id="status"></div>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">ID</th>
						<th class="text-center">Account Type</th>
						<th class="text-center">Account Name</th>
						<th class="text-center">Account Username</th>
						<th class="text-center">--- ---</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${not empty accounts}">
						<c:forEach var="account" items="${accounts}">
							<tr>
								<td>${account.id}</td>
								<td>${account.type}</td>
								<td>${account.accountname}</td>
								<td>${account.username}</td>
								<td>
									<button type="button" class="btn btn-primary loginbutton">login</button>
									<a href="<c:url value='/userhome?accountEditId=${account.id}&edit=edit' />"
										class="btn btn-success custom-width">edit</a> 
									<a href="<c:url value='/userhome/delete-account-${account.id}' />"
										class="btn btn-danger custom-width">delete</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>

		<form:form id="accountForm" method="POST" commandName="accountForm">
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<a href="<c:url value='/userhome?edit=false' />" class="close"
								data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</a>
							<h4 class="modal-title" id="myModalLabel">${modalTitle}</h4>
						</div>
						<div class="modal-body">
							<div class="tabbable">
								<!-- Only required for left/right tabs -->
								<ul class="nav nav-tabs">
									<li class="active"><a class="tab1" href="#tab1"
										data-toggle="tab">User</a></li>
									<li><a href="#tab2" data-toggle="tab">Password</a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab1">
										<div class="row">
											<div class="form-group col-md-3">
												<label class="control-label" for="type">Account type</label>
												<form:select path="account.type" id="type"
													class="form-control" required="true">
													<form:option value="facebook">Facebook</form:option>
													<form:option value="twitter">Twitter</form:option>
												</form:select>
											</div>
											<div class="form-group col-md-3">
												<label class="control-label" for="accname">Account name:</label>
												<form:input type="text" path="account.accountname"
													class="form-control" id="accname" required="true"
													autofocus="true" />
											</div>
											<div class="form-group col-md-3">
												<label class="control-label" for="usr">Username or Email:</label>
												<form:input path="account.username" type="text"
													class="form-control" id="usr" required="true" />
											</div>
										</div>
										<div class="form-horizontal">
											<div class="form-group">
												<div class="col-md-6">
													<form:textarea path="account.notes" class="form-control"
														rows="3" placeholder="Notes" />
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<a href="<c:url value='/userhome?edit=false' />"
												class="btn btn-default" data-dismiss="modal">Close</a>
										</div>
									</div>
									<!-- Fine Primo tab Form -->
									<div class="tab-pane" id="tab2">

										<div class="row">
											<div class="form-group col-md-6">
												<label class="control-label" for="pwdGen">Password
													Generator</label>
												<div class="input-group">
													<form:select path="passType" id="pwdGen"
														class="form-control">
														<form:option value="0" label="--- Select ---" />
														<form:option value="1" label="Letters Only" />
														<form:option value="2" label="Letters and Digits" />
														<form:option value="3" label="Letters Digits Special" />
														<form:option value="4" label="Words + Random Char" />
													</form:select>
													<span id="genButton" class="input-group-btn"> <input
														type="submit" class="btn btn-warning" name="action2"
														value="Generate" />
													</span>
												</div>
											</div>
										</div>
										<div class="row">
											<spring:bind path="word1">
												<div class="form-group col-md-3">
													<label class="control-label" for="word1">Word1</label>
													<form:input path="word1" type="text" class="form-control"
														id="word1" disabled="true" />
												</div>
											</spring:bind>
											<spring:bind path="word2">
												<div class="form-group col-md-3">
													<label class="control-label" for="word2">Word2</label>
													<form:input path="word2" type="text" class="form-control"
														id="word2" disabled="true" />
												</div>
											</spring:bind>
										</div>

										<div class="row">
											<div class="form-group col-md-6">
												<label class="control-label" for="password">Password:</label>
												<form:input path="account.password" type="password"
													class="form-control" id="password" />
											</div>
										</div>
										<c:if test="${not empty genPassword}">
											<div class="alert alert-warning" role="alert">
												<label class="control-label">Generated Password:</label>
												${genPassword}
											</div>
										</c:if>
										<div class="modal-footer">
											<a href="<c:url value='/userhome?edit=false' />"
												class="btn btn-default" data-dismiss="modal">Close</a> <input
												type="submit" class="btn btn-primary" value="Save" />
										</div>
									</div>
									<!-- Fine Secondo tab Form -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>

		<!-- Modal -->
		<div class="modal fade" id="userDetailsModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalDetails">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">User Details</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<label class="col-sm-3">ID</label>
							<div class="col-sm-6">${user.id}</div>
						</div>

						<div class="row">
							<label class="col-sm-3">Name</label>
							<div class="col-sm-6">${user.firstname} ${user.lastname}</div>
						</div>

						<div class="row">
							<label class="col-sm-3">Email</label>
							<div class="col-sm-6">${user.email}</div>
						</div>

						<div class="row">
							<label class="col-sm-3">Phone Number</label>
							<div class="col-sm-6">${user.phonenumber}</div>
						</div>

						<div class="row">
							<label class="col-sm-3">Gender</label>
							<div class="col-sm-6">${user.gender}</div>
						</div>

						<div class="row">
							<label class="col-sm-3">Date of Birth</label>
							<div class="col-sm-6">${user.dateOfBirth}</div>
						</div>

						<div class="row">
							<label class="col-sm-3">Credit Card</label>
							<div class="col-sm-6">${user.creditcard}</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--	/container -->

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
	<script src="/resources/js/scripts.js"></script>
	<script src="/resources/js/password.js"></script>
	<script>
		$('#password').password();
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$.ajaxSetup({cache : true});
			$.getScript('//connect.facebook.net/it_IT/sdk.js',
					function() {
						FB.init({
							appId : '927332304015673',
							version : 'v2.5' // or v2.0, v2.1, v2.2, v2.3
							});
						$('#loginbutton,#feedbutton').removeAttr('disabled');
						FB.getLoginStatus(updateStatusCallback);
					});
					$('.loginbutton').click(function() {
						FB.login(function() {
							FB.getLoginStatus(function(response) {
								if (response.status === 'connected') {
									document.getElementById('status').innerHTML = 'Thanks for logging in';
									window.open('http://www.facebook.com','_blank');
								}
							});
						});
						//alert("ciao");
					});
		});
	</script>
</body>
<c:if test="${edit == 'edit'}">
	<script>
		/* alert("Calling my function ..."); */
		$("#accname").prop('disabled', true);
		$("#type").prop('disabled', true);
		$('#myModal').modal('show');
		$('#accountForm').bind('submit', function() {
			$(this).find(':input').prop('disabled', false);
		});
	</script>
</c:if>
<c:if test="${edit == 'new'}">
	<script>
		/* alert("Calling my function ..."); */
		$('#myModal').modal('show');
	</script>
</c:if>
<c:if test="${editPwd}">
	<script>
		/* alert("Calling my function ...");  */
		$('.nav-tabs li:eq(1) a').tab('show');
		$('#myModal').modal('show');
	</script>
</c:if>
</html>