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
		   					<a href="javascript:void(0);" class="js-show-recieved text-center">
		   						Recieved
	   						</a>
	   					</li>
		   			</ul>
		   			<div class="sent-container container">
		   				<h2>Transfers sent</h2>
		   				<table class="table table-hover">
		   					<thead>
		   						<tr>
		   							<th>Id</th>
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
		   								<td>${trasnferIntention.id}</td>
		   								<td>${trasnferIntention.recipientName}</td>
		   								<td>${trasnferIntention.recipientPhoneNumber}</td>
		   								<td>${transferIntention.value}</td>
		   								<td>${transferIntention.statusToHuman()}</td>
		   								<td></td>
		   							</tr>
		   						</#list>
		   					</tbody>

		   				</table>
		   			</div>
		   			
		   			<div class="recieved-container container">
		   				<h2>Transfers recieved</h2>
		   				<table class="table table-hover">
		   					<thead>
		   						<tr>
		   							<th>Id</th>
		   							<th>Sender's name</th>
		   							<th>Sender's phone number</th>
		   							<th>Amount</th>
		   							<th>Status</th>
		   							<th>Actions</th>
		   						</tr>
		   					</thead>
		   					<tbody>
		   						<#list recieved as transferIntention>
		   							<tr>
		   								<td>${transferIntention.id}</td>
		   								<td>${transferIntention.senderName}</td>
		   								<td>${transferIntention.senderPhoneNumber}</td>
		   								<td>${transferIntention.value}</td>
		   								<td>${transferIntention.statusToHuman()}</td>
		   								<td></td>
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