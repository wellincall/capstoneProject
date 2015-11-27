<!DOCTYPE html>
<html>
	<head>
		<title>SATB Test</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css" /> 
	</head>
	<body>
	    <div class="container-fluid">
	    <div class="row">
	    	<div class="col-md-12">
	    		<h1>Logout</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
			   		<form class="form-horizontal" action="/deauthenticate" method="DELETE">
			   			<div class="form-action">
				   			<input type="submit" value="I want to logout" class="btn btn-default btn-primary pull-right" />
			   			</div>
			   		</form>
		   		</div>
		   	</div>
	    </div>
	    <script type="text/javascript" src="js/bootstrap.min.js" /> 
	</body>
</html>