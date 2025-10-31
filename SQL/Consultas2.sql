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