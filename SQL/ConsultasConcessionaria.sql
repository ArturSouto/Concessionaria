SELECT nome FROM Cliente;

SELECT modelo FROM Veiculo;

SELECT c.Nome, v.modelo
FROM Cliente c
JOIN Vende vd ON c.CPF = vd.CPF
JOIN Veiculo v ON vd.id = v.id;

SELECT AVG(salario) AS media_salario FROM Funcionario;
