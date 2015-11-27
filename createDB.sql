CREATE TABLE users (
	id serial NOT NULL,
	name character varying NOT NULL,
	phoneNumber character(17) NOT NULL,
	cpf character(14) NOT NULL, 
	email character varying NOT NULL,
	birthdayDate date NOT NULL,
	creationDate date NOT NULL,
	password character varying NOT NULL,
	CONSTRAINT usersPK PRIMARY KEY (id)
);
CREATE TABLE userBankAccounts(
	id serial NOT NULL,
	userId integer NOT NULL,
	accountToken character varying NOT NULL,	
	CONSTRAINT userAccountPK PRIMARY KEY(id),
	CONSTRAINT userForeingKey FOREIGN KEY (userId)
		REFERENCES users (id)
);
CREATE TABLE banks (
	id serial NOT NULL,
	name character varying NOT NULL,
	CONSTRAINT bankPK PRIMARY KEY (id)
);
CREATE TABLE bankAccounts (
	id serial NOT NULL,
	bankId integer NOT NULL,
	agencyNumber character(6) NOT NULL,
	accountNumber character(10) NOT NULL,
	accountOwnerName character varying NOT NULL,
	accountOwnerCPF character(14) NOT NULL,
	accountOwnerBirthdayDate date NOT NULL,
	token character varying NOT NULL,
	CONSTRAINT accountPK PRIMARY KEY (id),
	CONSTRAINT bankForeignKey FOREIGN KEY (bankId) REFERENCES banks (id)
);
CREATE TABLE transferIntentions (
	id serial NOT NULL,
	value numeric NOT NULL,
	recipientId integer NOT NULL,
	senderId integer NOT NULL,
	status integer NOT NULL,
	creationDate date NOT NULL,
	CONSTRAINT transferIntentionPK PRIMARY KEY (id),
	CONSTRAINT recipientForeignKey FOREIGN KEY (recipientId) REFERENCES userBankAccounts(id),
	CONSTRAINT senderForeingKey FOREIGN KEY (senderId) REFERENCES userBankAccounts(id)
);
CREATE TABLE deposits (
	id serial NOT NULL,
	bankId integer NOT NULL,
	accountToken character varying not null,
	transferIntentionId integer NOT NULL,
	value numeric NOT NULL,
	status integer NOT NULL,
	CONSTRAINT depositPK PRIMARY KEY (id),
	CONSTRAINT transferIntentionFK FOREIGN KEY (transferIntentionId) REFERENCES transferIntentions (id),
	CONSTRAINT bankFK FOREIGN KEY (bankId) REFERENCES banks (id)
);
CREATE TABLE withdraws (
	id serial NOT NULL,
	bankId integer NOT NULL,
	accountToken character varying not null,
	transferIntentionId integer NOT NULL,
	value numeric NOT NULL,
	status integer NOT NULL,
	CONSTRAINT withdrawPK PRIMARY KEY (id),
	CONSTRAINT transferIntentionFK FOREIGN KEY (transferIntentionId) REFERENCES transferIntentions (id),
	CONSTRAINT bankFK FOREIGN KEY (bankId) REFERENCES banks (id)
);
