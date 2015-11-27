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
	    		<h1>Register new user</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
			   		<form class="form-horizontal" action="/register-user" method="POST">
			   			<#list formfields as formField>
			   				<div class="form-group">
				   				<label for="${formField.formFieldId}" class="col-md-2 control-label">
				   				${formField.formFieldCaption}
				   				</label>
				   				<div class="col-md-10">
				   					<input id="${formField.formFieldId}" name="${formField.formFieldId}" type="${formField.formFieldType}" class="form-control" />
				   				</div>
			   				</div>
			   			</#list>
			   			<div class="form-action">
				   			<input type="submit" value="Submit" class="btn btn-default btn-primary pull-right" />
				   			<input type="reset" value="Clean form" class="btn btn-default btn-danger pull-right" />
			   			</div>
			   		</form>
		   		</div>
		   	</div>
	    </div>
	    <script type="text/javascript" src="/js/bootstrap.min.js" /> 
	</body>
</html>