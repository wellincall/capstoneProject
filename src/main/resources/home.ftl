<!DOCTYPE html>
<html>
	<head>
		<title>Sistema de Agendamento de Transferencia Bancarias - Home</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" /> 
	</head>
	<body>
	    <div class="container-fluid">
	    <div class="row">
	    	<div class="col-md-12">
	    		<h1>Home Page:</h1>
	    	</div>
	    </div>
		   	<div class="row">
		   		<div class="col-md-12">
		   			<h2>Com autenticacao</h2>
		   			<p>Todas as respostas sao JSON</p>
		   			<ul>
	   					<li><a href="/verify-account">Verificar conta</a></li>
	   					<li><a href="/user/new-bank-account">Cadastrar conta bancaria</a></li>
	   					<li><a href="/user/reset-password">Editar senha</a></li>
	   					<li><a href="/user/import-contacts">Importar contatos</a></li>
	   					<li><a href="/user/ask-banks">Solicitar todos os bancos registrados na plataforma</a></li>
	   					<li><a href="/user/new-account">Associar conta bancaria ao perfil</a></li>
	   					<li><a href="/user/import-contacts">Importar contatos</a></li>
	   					<li><a href="/user/ask-accounts">Listar contas associadas ao usuario</a></li>
	   					<li><a href="/user/list-accounts">Lista de contas para remocao</a></li>
	   					<li><a href="/user/new-transfer">Nova transferencia</a></li>
	   					<li><a href="user/ask-transfer-intentions-list">Lista de transferencias recebidas/enviadas</a></li>
	   					<li><a href="/user/transfer-intentions-menu">Area do usuario</a></li>



	   				</ul>	
		   		</div>
		   		<div class="col-md-12">
		   			<h2>Sem autenticacao</h2>
		   			<p>Direciona para paginas que geram requisicao POST</p>
	   				<ul>
	   					<li><a href="/new-bank">Cadastrar Banco</a></li>
	   					<li><a href="/new-bank-account">Cadastrar conta bancaria</a></li>
	   					<li><a href="/new-user">Cadastrar novo usuario</a></li>
	   					<li><a href="/login">Login</a></li>
	   					<li><a href="/allow-logout">Logout</a></li>
	   					<li><a href="/ask-to-consolidate">Consolidar transacoes confirmadas</a></li>
	   				</ul>	   				
		   		</div>
		   	</div>
	    </div>
	</body>
</html>