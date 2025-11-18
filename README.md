# 🚗 *Concessionária*
### Projeto Acadêmico — Banco de Dados (MOD02)

---

## 🌟 *Visão Geral*

O sistema *Concessionária* é uma aplicação Java desenvolvida com *JDBC puro*, totalmente integrada a um banco de dados relacional e atendendo a todos os requisitos do módulo.  
A aplicação fornece CRUD completo, consultas avançadas, views, funções, procedures, triggers e um dashboard estatístico alimentado diretamente pelo banco de dados.

A arquitetura do projeto está organizada de forma modular, permitindo manutenção simples e clara, seguindo o padrão:


---

# 🏛 *Arquitetura da Aplicação*

### ✔ *Model*
Contém as classes que representam as entidades do sistema, como Carro, Cliente, Venda.  
Inclui apenas atributos, construtor e getters/setters.

### ✔ *DAO (Data Access Object)*
- Toda a comunicação com o banco acontece aqui.  
- SQL *100% puro*, sem uso de JPA, Hibernate ou qualquer ORM.  
- Métodos essenciais:
  - inserir()
  - listar()
  - atualizar()
  - deletar()
  - consultas específicas, views, procedimentos e funções.

### ✔ *Service*
- Camada intermediária entre Controller e DAO.  
- Isola regras de negócio, validações e cálculos.  
- Evita que o Controller precise lidar com SQL ou regras internas.

### ✔ *Controller (API REST)*
- Recebe requisições HTTP e retorna respostas para o frontend/dashboard.  
- Exemplo de rotas:
  - POST /carros
  - GET /carros
  - PUT /carros/{id}
  - DELETE /carros/{id}

---

# 🗄 *Banco de Dados*

O banco possui tabelas essenciais ao domínio da concessionária, como:

- carro
- cliente
- venda
- funcionario

Toda a integração usa:

- *JDBC puro*
- *SQL explícito*
- *PreparedStatement*
- Classe ConexaoBD responsável pela conexão.

---

# 🔍 *Consultas Avançadas — Etapa 04*

O projeto implementa:

### ✔ 1 Anti Join  
Carros que *nunca foram vendidos* via LEFT JOIN filtrando NULL.

### ✔ 1 Full Outer Join  
Combina informações de funcionários e vendedores mesmo quando não existe correspondência.

### ✔ 2 Subconsultas  
Exemplos:  
- Carros acima da média geral de preços  
- Clientes que compraram mais de X veículos

### ✔ Índices Otimizados  
Ao menos dois índices realmente úteis criados em campos críticos.

### ✔ Views Elaboradas  
Views com *mínimo 3 joins*, como:  
- vw_relatorio_vendas_completo  
- vw_carros_detalhados

---

# ⚙ *Funções, Procedimentos e Triggers — Etapa 05*

### ✔ *Funções*
- Duas funções criadas com justificativa semântica  
- Uma delas com *estrutura condicional*

### ✔ *Procedures*
- Uma para atualização de dados  
- Uma usando *cursor real*, com lógica que não pode ser substituída apenas com UPDATE

### ✔ *Triggers*
- Uma trigger para log (auditoria)  
- Uma trigger para consistência dos dados

---

# 📊 *Dashboard Estatístico — Etapa 06*

Conectado diretamente ao banco, exibindo:

### ✔ Indicadores  
- Total de clientes  
- Total de carros  
- Total de vendas  
- Média, desvio padrão, variância etc.

### ✔ Gráficos Dinâmicos (mínimo 6)  
Ex.: barras, pizza, linha, radar, histograma, comparativo por período.

### ✔ Visualizações Interativas  
Com filtros, categorias e períodos.

---

# 📁 *Estrutura de Pastas*

---

# 🚀 *Como Rodar o Projeto*

## ✅ 1. *Instale os requisitos*
- Java *17 ou superior*
- Driver JDBC do banco (MySQL ou PostgreSQL)
- IDE como IntelliJ, Eclipse ou VS Code com extensão Java
- Banco de dados criado e rodando

---

## ✅ 2. *Configure o Banco de Dados*

Edite o arquivo:

E insira:

```java
private static final String URL = "jdbc:mysql://localhost:3306/concessionaria";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";

Basta executar o arquivo principal:

src/com/concessionaria/ConcessionariaApplication.java