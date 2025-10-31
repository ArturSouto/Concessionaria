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