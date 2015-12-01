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
	    		<h1>Verify your account</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
			   		<form class="form-horizontal" action="/verify-account" method="POST">
		   				<div class="form-group">
			   				<label for="verification-code" class="col-md-2 control-label">
			   				Verification Code
			   				</label>
			   				<div class="col-md-10">
			   					<input id="verification-code" name="verification-code" type="text" class="form-control" />
			   				</div>
		   				</div>
			   			<div class="form-action">
				   			<input type="submit" value="Submit" class="btn btn-default btn-primary pull-right" />
				   			<input type="reset" value="Clean form" class="btn btn-default btn-danger pull-right" />
			   			</div>
			   		</form>
		   		</div>
		   	</div>
	    </div>
	</body>
</html>