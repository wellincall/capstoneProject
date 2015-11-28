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
		   			<h1>Bank's page</h1>
		   		</div>
		   		<div class="col-md-12">
			   		<form class="form-horizontal" action="/user/banks" method="POST">
			   			<div class="form-action">
				   			<input type="submit" value="Show me all registered banks" class="btn btn-default btn-primary" />
			   			</div>
			   		</form>
		   		</div>
		   	</div>
	    </div>
	</body>
</html>