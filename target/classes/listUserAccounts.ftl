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
	    		<h1>My accounts</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
		   			<#list userAccounts as userAccount>
		   				<form class="form-horizontal" action="/user/remove-account" method="POST">
			   				<div class="form-group">
				   				<span>Account ${userAccount.id} token ${userAccount.accountToken}</span>
				   				<input type="hidden" value="${userAccount.id}" name="account-id"/>
				   				<input type="submit" value="Remove" class="btn btn-danger btn-default" />
				   			</div>
			   			</form>
		   			</#list>
		   		</div>
		   	</div>
	    </div>
	</body>
</html>