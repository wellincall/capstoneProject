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
	    		<h1>Accept Transfer Intention</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
			   		<form class="form-horizontal" action="/user/accept-transfer" method="POST">
			   			<div class="transfer-info">
			   					<div class="info-group">
			   						<div class="col-md-2">
			   							<p class="bold">Sender's name:</p>
			   						</div>
			   						<div class="col-md-10">
			   							<p class="text-right">
			   								${transfer.senderName}
			   							</p>
			   						</div>
			   					</div>
			   					<div class="info-group">
			   						<div class="col-md-2">
			   							<p class="bold">Sender's phone number:</p>
			   						</div>
			   						<div class="col-md-10">
			   							<p class="text-right">
			   								${transfer.senderPhoneNumber}
			   							</p>
			   						</div>
			   					</div>
			   					<div class="info-group">
			   						<div class="col-md-2">
			   							<p class="bold">Amount: </p>
			   						</div>
			   						<div class="col-md-10">
			   							<p class="text-right">
			   								${transfer.value}
			   							</p>
			   						</div>
			   					</div>
			   			</div>
			   			<#list formfields as formField>
			   				<div class="form-group">
				   				<label for="${formField.formFieldId}" class="col-md-2 control-label">
				   				${formField.formFieldCaption}
				   				</label>
				   				<div class="col-md-10">
				   					<#if ForeignKeyField.isInstance(formField)>
				   						<select name=${formField.formFieldId} id="${formField.formFieldId}" class="form-control">
				   							<#list formField.options?keys as accountId>
				   								<option value="${accountId}" label="${formField.options[accountId]}">${formField.options[accountId]}</option>
				   							</#list>
				   						</select>
				   					<#else>
				   						<input id="${formField.formFieldId}" name="${formField.formFieldId}" type="${formField.formFieldType}" class="form-control" />
				   					</#if>
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
	</body>
</html>