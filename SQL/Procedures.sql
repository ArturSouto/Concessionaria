use concessionaria;

-- Procedimento 1: atualiza o preço de um veículo
DELIMITER //
CREATE PROCEDURE atualizar_preco_veiculo(
    IN veiculo_id INT,
    IN novo_preco DECIMAL(10,2)
)
BEGIN
UPDATE Veiculo
SET preco = novo_preco
WHERE id = veiculo_id;
END//
DELIMITER ;


-- Procedimento 2: usa um CURSOR para calcular e exibir o total de manutenção por veículo
DELIMITER //
CREATE PROCEDURE listar_totais_manutencao()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE vid INT;
    DECLARE total INT;
    DECLARE cur CURSOR FOR
SELECT id FROM Veiculo;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    CREATE TEMPORARY TABLE IF NOT EXISTS TotaisManutencao(
        id_veiculo INT,
        total_custos INT
    );

TRUNCATE TABLE TotaisManutencao;

OPEN cur;
read_loop: LOOP
        FETCH cur INTO vid;
        IF done THEN
            LEAVE read_loop;
END IF;

SELECT IFNULL(SUM(custos),0) INTO total
FROM Manutencao
WHERE id = vid;

INSERT INTO TotaisManutencao VALUES (vid, total);
END LOOP;

CLOSE cur;

SELECT * FROM TotaisManutencao;
END//
DELIMITER ;
