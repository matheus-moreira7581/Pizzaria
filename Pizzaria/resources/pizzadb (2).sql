-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pizzaDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pizzaDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `pizzaDB` ;

-- -----------------------------------------------------
-- Table `pizzaDB`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaDB`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(11) not null,
  `nome` VARCHAR(50) NOT NULL,
  `sobrenome` varchar(100) not null,
  `email` varchar(100) not null,
  `bairro` varchar(70) not null,
  `endereco` varchar(100) not null,
  `numEndereco` int not null,
  `senha` varchar(50) not null,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;

-- ----------------------------------------------------
-- table `capa pedido`
-- ----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaDB`.`pedido`  (
`id_ped` INT NOT NULL auto_increment,
`id_cliente` INT NOT NULL,
`nome` VARCHAR (50) NOT NULL,
`bairro` varchar(70) NOT NULL,
`endereco` varchar(100) NOT NULL,
`numEndereco` INT NOT NULL,
`data_emi` TIMESTAMP DEFAULT now()  not null,
`forma_PGT` ENUM('Dinheiro','Cartao') not null,
primary key (`id_ped`))
ENGINE = InnoDB;

-- ----------------------------------------------------
-- table `item do pedido`
-- ----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaDB`.`item_ped`  (
`id_item`INT NOT NULL AUTO_INCREMENT,
`id_ped` int not null,
`codigo_produto` int not null,
`qtd_item` integer unsigned not null,
`nome` varchar(50) not null,
`preco` decimal(5,2)not null,
`desconto`decimal(5,2)not null,
CONSTRAINT PK_Person PRIMARY KEY (id_item,id_ped,codigo_produto) )
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `pizzaDB`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaDB`.`produto` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `preco` decimal(5,2) not null,
  `desconto` decimal(5,2) not null,
  `descricao` varchar(250),
  `image_source` varchar(150),
  `tipo` enum('Pizza','Hamburguer') not null,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `pizzaDB`.`admin`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `pizzaDB`.`administrator` (
  `codAdm` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `user` VARCHAR(50) NOT NULL,
  `senha` varchar(50) not null,
  `email` varchar(100) not null,
  PRIMARY KEY (`codAdm`))
ENGINE = InnoDB;

-- Primary Key

-- alter table item_ped
-- 	add constraint item_ped_pk primary key(codigo,id_ped);

-- Foreign Key 

alter table pedido
    add constraint fk_pedido_cliente foreign key(id_cliente) references cliente(id_cliente),
    auto_increment=2555;
    
 alter table item_ped 
    add constraint fk_pedido_item foreign key(id_ped) references pedido(id_ped),
    add constraint fk_item_ped_pedido foreign key(codigo_produto) references produto(codigo);
    

    




insert into administrator values(null, 'matheus', 'matheus123', 'm123456','matheus@hotmail.com');

insert into cliente values(null, '14575678924', 'Gabriel', 'Ferreira', 'gabriel@hotmail.com', 'Vila Mariana', 'R. Joaquim Távora', 255,'123pass123');
insert into cliente values(null, '45678915492', 'Igor', 'Silva', 'igor@hotmail.com', 'Vila Madalena', 'R. Cordeiro Galvão', 1255,'senha478745');
insert into cliente values(null, '68742397412', 'João', 'Lopes', 'joão@hotmail.com', 'Vila Formosa', 'R. Tirana', 415,'minhasenha1231454');

insert into produto values(null, 'Calabresa', 69.99, 0, 'Borda com catupiry, Calabresa, Cebola, Molho de tomate.', 'test.jpg', 'Pizza');
insert into produto values(null, 'Mussarela', 69.99, 0, 'Borda com catupiry, Mussarela, Molho de tomate.', 'test.jpg','Pizza');
insert into produto values(null, 'Frango', 69.99, 0, 'Frango, Cobertura de catupiry, Molho de tomate.', 'test.jpg','Pizza');
insert into produto values(null, 'Picanha', 34.99, 0, '1 Hamburgue de picanha 180g, Molho da casa, Alface, Picles, Cheddar', 'test.jpg','Hamburguer');

-- select * from Cliente where email='gabriel@hotmail.com' and senha='123pass123';

select * from administrator;

select * from produto;

select * from cliente;

select * from pedido;

select * from item_ped;

-- delete from produto where codigo = 7;

-- update cliente set bairro='Vila Formosa',endereco='R. Tirana' where cpf = 4;

-- drop database pizzadb;



