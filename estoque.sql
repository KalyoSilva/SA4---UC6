CREATE DATABASE estoque

CREATE SEQUENCE id_item_sequence
	  INCREMENT 1
	   MINVALUE 1
	   MAXVALUE 9223372036854775807
	      START 1
	      CACHE 1;
		  
CREATE SEQUENCE id_cliente_sequence
	  INCREMENT 1
	   MINVALUE 1
	   MAXVALUE 9223372036854775807
	      START 1
	      CACHE 1;	
		  
CREATE SEQUENCE id_funcionario_sequence
	  INCREMENT 1
	   MINVALUE 1
	   MAXVALUE 9223372036854775807
	      START 1
	      CACHE 1;	

CREATE TABLE public.Item (
	IDItem NUMERIC(5) NOT NULL DEFAULT NEXTVAL('id_item_sequence'::regclass),
	NomeItem VARCHAR(50) NOT NULL,
	QtdItem NUMERIC(10) NOT NULL,
	ValorItem NUMERIC(7,2) NOT NULL,
	DescricaoItem TEXT,
	PRIMARY KEY (IDItem)
)

CREATE TABLE public.Funcionario (
	IDFuncionario NUMERIC(5) NOT NULL DEFAULT NEXTVAL('id_funcionario_sequence'::regclass),
	NomeFuncionario VARCHAR(50) NOT NULL,
	SenhaFuncionario VARCHAR(30) NOT NULL,
	PRIMARY KEY(IDFuncionario)
)

CREATE TABLE public.Cliente (
	IDCliente NUMERIC(5) NOT NULL DEFAULT NEXTVAL('id_cliente_sequence'::regclass),
	NomeCliente VARCHAR(50) NOT NULL, 
	SenhaCliente VARCHAR(30) NOT NULL,
	PRIMARY KEY(IDCliente)
)



