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
	    		<h1>New Transfer Intention</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
			   		<form class="form-horizontal" action="/user/new-transfer-intention" method="POST">
			   			<#list formfields as formField>
			   				<div class="form-group">
				   				<label for="${formField.formFieldId}" class="col-md-2 control-label">
				   				${formField.formFieldCaption}
				   				</label>
				   				<div class="col-md-10">
				   					<#if ForeignKeyField.isInstance(formField)>
				   						<select name=${formField.formFieldId} id="${formField.formFieldId}" class="form-control">
				   							<#list formField.options?keys as bankId>
				   								<option value="${bankId}" label="${formField.options[bankId]}">${formField.options[bankId]}</option>
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