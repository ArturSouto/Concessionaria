create database concessionaria;
use concessionaria;

create table Funcionario(
    CPF varchar(14) primary key,
    salario float check (salario >= 0),
    cargo varchar(50) not null,
    contratacao varchar(50) not null,
    SupervisorCPF varchar(14),
    enderecoCEP varchar(50),
    enderecoBairro varchar(50),
    enderecoRua varchar(100),
    enderecoNumero varchar(50),
    constraint fk_Funcionario foreign key (SupervisorCPF) references Funcionario(CPF)
        on delete set null
);

create table Fornecedor(
    CNPJ varchar(18) primary key,
    Nome varchar(100) not null,
    Nome_Fantasia varchar(100) not null,
    Telefone char(15)
);
create table Veiculo(
    id int primary key,
    ano int,
    km int,
    cor varchar(20),
    estado varchar(20),
    preco decimal(10,2),
    modelo varchar(50),
    combustivel varchar(20),
    CNPJ varchar(18), 
    constraint fk_Veiculo foreign key (CNPJ) references Fornecedor(CNPJ)
        on update cascade
);



create table Carro(
    id int primary key,
    portas int check (portas > 0),
    cambio varchar(20) default 'Manual',
    constraint fk_Carro foreign key (id) references Veiculo(id)
);

create table Moto(
    id int primary key,
    cilindradas int check (cilindradas > 0),
    tipoMotor varchar(50) default 'Monocilíndrico',
    constraint fk_Moto foreign key (id) references Veiculo(id)
);

create table Cliente(
    CPF varchar(14) primary key,
    Nome varchar(100) not null,
    idade int check (idade > 0),
    enderecoCEP varchar(50),
    enderecoBairro varchar(50),
    enderecoRua varchar(100),
    enderecoNumero varchar(50)
);

create table Vende(
    idvenda varchar(10) primary key,
    id int,
    CPF varchar(14),
    CNPJ varchar(18),  
    DataVenda date,  
    valorVenda int check (valorVenda >= 0),
    formaPagamento varchar(20) default 'Dinheiro',
    constraint fk_Venda1 foreign key (id) references Veiculo(id),
    constraint fk_Venda2 foreign key (CPF) references Cliente(CPF),
    constraint fk_Venda3 foreign key (CNPJ) references Fornecedor(CNPJ)
);

create table Manutencao(
    idmanutencao varchar(10) primary key,
    id int,
    descricao varchar(255),
    custos int check (custos >= 0),
    dataManutencao date,
    constraint fk_Manutencao foreign key (id) references Veiculo(id)
);

create table Pecas(
	idmanutencao varchar(10),
    codPeca varchar(8) primary key,
    nome varchar(10) not null,
    material varchar(10) default 'metal',
    constraint fk_Pecas foreign key (idmanutencao) references Manutencao(idmanutencao)
);
