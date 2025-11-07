USE concessionaria;

-- 1. FUNÇÕES


-- Se o valor da venda for maior que 100000, aplica 5% de desconto
DELIMITER //
CREATE FUNCTION calcular_valor_final(valor DECIMAL(10,2))
    RETURNS DECIMAL(10,2)
    DETERMINISTIC
BEGIN
    DECLARE valor_final DECIMAL(10,2);

    IF valor > 100000 THEN
        SET valor_final = valor * 0.95; -- desconto de 5%
ELSE
        SET valor_final = valor;
END IF;

RETURN valor_final;
END//
DELIMITER ;


-- Função 2: retorna a média de preço dos veículos por combustível
DELIMITER //
CREATE FUNCTION media_preco_combustivel(tipo_combustivel VARCHAR(20))
    RETURNS DECIMAL(10,2)
    DETERMINISTIC
BEGIN
    DECLARE media DECIMAL(10,2);
SELECT AVG(preco) INTO media
FROM Veiculo
WHERE combustivel = tipo_combustivel;
RETURN media;
END//
DELIMITER ;


