<!DOCTYPE html>
<html>
	<head>
		<title>SATB - Sistema de Agendamento de Transferencias Bancarias</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" /> 
	</head>
	<body>
	    <div class="container-fluid">
	    <div class="row">
	    	<div class="col-md-12">
	    		<h1>My transfer intentions</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
		   			<ul class="nav nav-pills nav-stacked">
		   				<li role="presentation">
		   					<a href="javascript:void(0);" class="js-show-sent text-center">
		   						Sent
	   						</a>
	   					</li>
		   				<li role="presentation">
		   					<a href="javascript:void(0);" class="js-show-received text-center">
		   						Received
	   						</a>
	   					</li>
		   			</ul>
		   			<div class="sent-container">
		   				<h2>Transfers sent</h2>
		   				<table class="table table-hover">
		   					<thead>
		   						<tr>
		   							<th>Id</th>
		   							<th>Sent on</th>
		   							<th>Recipient's name</th>
		   							<th>Recipient's phone number</th>
		   							<th>Amount</th>
		   							<th>Status</th>
		   							<th>Actions</th>
		   						</tr>
		   					</thead>
		   					<tbody>
		   						<#list sent as transferIntention>
		   							<tr>
		   								<td>${transferIntention.id}</td>
		   								<td>${transferIntention.creationDateInString()}</td>
		   								<td>${transferIntention.recipientName}</td>
		   								<td>${transferIntention.recipientPhoneNumber}</td>
		   								<td>${transferIntention.value}</td>
		   								<td>${transferIntention.statusToHuman()}</td>
		   								<td>
		   									<#if transferIntention.canChangeStatus() >
		   										<#if transferIntention.canBeVoided() >
				   									<form action="/user/void-transfer" method="POST">
				   										<input type="hidden" value="${transferIntention.id}" name="transfer-id" />
				   										<input type="submit" value="Void transaction" class="btn btn-default btn-danger" />
				   									</form>
				   								</#if>
			   								<#else>
			   									No more actions to be done
			   								</#if>
		   								</td>
		   							</tr>
		   						</#list>
		   					</tbody>

		   				</table>
		   			</div>
		   			
		   			<div class="received-container">
		   				<h2>Transfers received</h2>
		   				<table class="table table-hover">
		   					<thead>
		   						<tr>
		   							<th>Id</th>
		   							<th>Received on</th>
		   							<th>Sender's name</th>
		   							<th>Sender's phone number</th>
		   							<th>Amount</th>
		   							<th>Status</th>
		   							<th>Actions</th>
		   						</tr>
		   					</thead>
		   					<tbody>
		   						<#list received as transferIntention>
		   							<tr>
		   								<td>${transferIntention.id}</td>
		   								<td>${transferIntention.creationDateInString()}</td>
		   								<td>${transferIntention.senderName}</td>
		   								<td>${transferIntention.senderPhoneNumber}</td>
		   								<td>${transferIntention.value}</td>
		   								<td>${transferIntention.statusToHuman()}</td>
		   								<td>
		   									<#if transferIntention.canChangeStatus() >
		   										<#if transferIntention.canBeDeclined() >
				   									<form action="/user/decline-transfer" method="POST">
				   										<input type="hidden" value="${transferIntention.id}" name="transfer-id" />
				   										<input type="submit" value="Decline transaction" class="btn btn-default btn-danger" />
				   									</form>
				   								</#if>
				   								<#if transferIntention.canBeAccepted() >
				   									<form action="/user/accept-transfer" method="POST">
				   										<input type="hidden" value="${transferIntention.id}" name="transfer-id" />
				   										<input type="submit" value="Accept transaction" class="btn btn-default btn-success" />
				   									</form>
				   								</#if>
				   								<#if transferIntention.canBeVoided() >
				   									<form action="/user/void-transfer" method="POST">
				   										<input type="hidden" value="${transferIntention.id}" name="transfer-id" />
				   										<input type="submit" value="Void transaction" class="btn btn-default btn-warning" />
				   									</form>
				   								</#if>
			   								<#else>
			   									No more actions to be done
			   								</#if>

		   								</td>
		   							</tr>
		   						</#list>

		   					</tbody>

		   				</table>
		   			</div>
		   		</div>
		   	</div>
	    </div>
	    <script type="text/javascript" src="/js/transfers-menu.js"></script>
	</body>
</html>