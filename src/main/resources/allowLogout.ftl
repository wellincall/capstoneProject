<!DOCTYPE html>
<html>
	<head>
		<title>SATB Test</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" /> 
	</head>
	<body>
	    <div class="container-fluid">
	    <div class="row">
	    	<div class="col-md-12">
	    		<h1>You are logged in as:</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
		   		<table class="table">
		   			<tr><th>Name:</th><td class="text-right">${user.name}</td></tr>
		   			<tr><th>Email:</th><td class="text-right">${user.email}</td></tr>
		   			<tr><th>Phone number:</th><td class="text-right">${user.phoneNumber}</td></tr>
		   		</table>
		   		</div>
		   		<div class="col-md-12">
			   		<form class="form-horizontal" action="/deauthenticate" method="POST">
			   			<div class="form-action">
				   			<input type="submit" value="I want to logout" class="btn btn-default btn-primary" />
			   			</div>
			   		</form>
		   		</div>
		   	</div>
	    </div>
	    <script type="text/javascript" src="/js/bootstrap.min.js" /> 
	</body>
</html>