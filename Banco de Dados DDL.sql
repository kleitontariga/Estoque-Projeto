create database estoque;

use estoque;

create table Produtos (
  idProduto smallint primary key not null auto_increment,
  nome varchar(20) not null,
  quantidade int not null,
  fornecedor varchar(50) not null,
  dataValidade date not null,
  id_cliente smallint not null,
  id_estoque smallint not null,
  id_fornecedores smallint not null,
  constraint fk_id_cliente foreign key (id_cliente) references Cliente(idCliente),
  constraint fk_id_estoque foreign key (id_estoque) references Estoques(idEstoque),
  constraint fk_id_fornecedores foreign key (id_fornecedores) references Forncedores(idFornecedor)
);

create table Fornecedores (
  idFornecedor smallint primary key not null,
  nome varchar(20) not null,
  endereço varchar(20) not null,
  telefone varchar(20) not null,
  cnpj char(14) not null,
  id_cliente smallint not null,
  constraint fk_id_cliente foreign key (id_cliente) references Cliente(idCliente)
);

create table Encomendas (
  idEncomenda smallint primary key not null auto_increment,
  data date not null,
  status varchar(50) not null,
  quantidade int not null,
  id_produtos smallint not null,
  id_cliente smallint not null,
  id_fornecedores smallint not null,
  id_estoque smallint not null,
  constraint fk_id_produtos foreign key (id_produtos) references Produtos(idProduto),
  constraint fk_id_cliente foreign key (id_cliente) references Cliente(idCliente),
  constraint fk_id_fornecedores foreign key (id_fornecedores) references Fornecedores(idFornecedor),
  constraint fk_id_estoque foreign key (id_estoque) references Estoque(idEstoque)
);

create table Estoque (
  idProduto smallint primary key not null auto_increment,
  quantidade int not null,
  id_cliente smallint not null,
  constraint fk_id_cliente foreign key (id_cliente) references Cliente(idCliente)
);

create table Cliente (
  idCliente smallint primary key not null auto_increment,
  nome varchar(20) not null,
  endereço varchar(20) not null,
  telefone varchar(20) not null
  );
  
  select * from Produtos;