USE concessionaria;
-- Questao 1 pede 2 indices fiz 4 importantes.
-- Índice pra buscar veículos por fornecedor
CREATE INDEX idx_veiculo_cnpj ON Veiculo(CNPJ);

-- Índice pra filtrar por modelo do veículo
CREATE INDEX idx_veiculo_modelo ON Veiculo(modelo);

-- Índice pra buscar vendas por CPF de cliente
CREATE INDEX idx_vende_cpf ON Vende(CPF);

-- Índice pra procurar manutenções pelo ID do veículo
CREATE INDEX idx_manutencao_id ON Manutencao(id);

-- questão 2 consultas:
-- anti join: mostra os clientes que nunca compraram nada.
SELECT c.CPF, c.Nome, c.idade
FROM Cliente c
LEFT JOIN Vende v ON c.CPF = v.CPF
WHERE v.CPF IS NULL;

-- outer join:
-- Junta fornecedores e vendas, mesmo que um dos lados não exista.
SELECT f.CNPJ AS fornecedor_cnpj, f.Nome AS fornecedor_nome, v.idvenda, v.id AS veiculo_id, v.DataVenda, v.valorVenda
FROM Fornecedor f
LEFT JOIN Vende v ON f.CNPJ = v.CNPJ

UNION

SELECT f.CNPJ AS fornecedor_cnpj, f.Nome AS fornecedor_nome, v.idvenda, v.id AS veiculo_id, v.DataVenda, v.valorVenda
FROM Fornecedor f
RIGHT JOIN Vende v ON f.CNPJ = v.CNPJ;

-- 2 Subconsultas:
-- subconsulta 1: Mostra os veículos que custam MAIS que a média dos veículos do msm combustível.
SELECT v.id, v.modelo, v.combustivel, v.preco
FROM Veiculo v
WHERE v.preco > (
    SELECT AVG(v2.preco)
    FROM Veiculo v2
    WHERE v2.combustivel = v.combustivel
)
ORDER BY v.combustivel, v.preco DESC;

-- subconsulta 2: mostra os fornecedores que tiveram vendas de valor total foi maior que a média geral de vendas de todos os fornecedores.
SELECT f.CNPJ, f.Nome, SUM(v.valorVenda) AS total_vendido
FROM Fornecedor f
JOIN Veiculo ve ON ve.CNPJ = f.CNPJ
JOIN Vende v ON v.id = ve.id
GROUP BY f.CNPJ, f.Nome
HAVING total_vendido > (
    SELECT AVG(total_por_fornecedor)
    FROM (
        SELECT SUM(v2.valorVenda) AS total_por_fornecedor
        FROM Fornecedor f2
        JOIN Veiculo ve2 ON ve2.CNPJ = f2.CNPJ
        JOIN Vende v2 ON v2.id = ve2.id
        GROUP BY f2.CNPJ
    ) AS medias
)
ORDER BY total_vendido DESC;

-- 3. visões:
-- 3.1 View de vendas (junta tudo que importa pra ver uma venda)
CREATE OR REPLACE VIEW venda_detalhada AS
SELECT
  vnd.idvenda,
  vnd.DataVenda,
  vnd.valorVenda,
  vnd.formaPagamento,
  ve.id AS veiculo_id,
  ve.modelo,
  ve.ano,
  ve.km,
  ve.preco AS preco_cadastrado,
  f.CNPJ AS fornecedor_cnpj,
  f.Nome AS fornecedor_nome,
  c.CPF AS cliente_cpf,
  c.Nome AS cliente_nome,
  crr.portas,
  mto.cilindradas
FROM Vende vnd
JOIN Veiculo ve ON vnd.id = ve.id
LEFT JOIN Fornecedor f ON ve.CNPJ = f.CNPJ
LEFT JOIN Cliente c ON vnd.CPF = c.CPF
LEFT JOIN Carro crr ON ve.id = crr.id
LEFT JOIN Moto mto ON ve.id = mto.id;

-- 3.2 View de manutenção completa
CREATE OR REPLACE VIEW manutencao_completa AS
SELECT
  m.idmanutencao,
  m.id AS veiculo_id,
  ve.modelo,
  ve.ano,
  ve.CNPJ AS fornecedor_cnpj,
  f.Nome AS fornecedor_nome,
  m.descricao AS manutencao_descricao,
  m.custos,
  m.dataManutencao,
  p.codPeca,
  p.nome AS peca_nome,
  p.material AS peca_material
FROM Manutencao m
JOIN Veiculo ve ON m.id = ve.id
LEFT JOIN Fornecedor f ON ve.CNPJ = f.CNPJ
LEFT JOIN Pecas p ON p.idmanutencao = m.idmanutencao;