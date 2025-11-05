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

--  2. PROCEDIMENTOS

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


--  3. TRIGGERS

CREATE TABLE IF NOT EXISTS LogVendas (
                                         idLog INT AUTO_INCREMENT PRIMARY KEY,
                                         idVenda VARCHAR(10),
    dataAcao DATETIME,
    tipoAcao VARCHAR(10),
    valorAnterior DECIMAL(10,2),
    valorNovo DECIMAL(10,2)
    );


-- vai mostrar quando vender um novo veiculo
DELIMITER //
CREATE TRIGGER log_venda_nova
    AFTER INSERT ON Vende
    FOR EACH ROW
BEGIN
    INSERT INTO LogVendas (idVenda, dataAcao, tipoAcao, valorAnterior, valorNovo)
    VALUES (NEW.idVenda, NOW(), 'INSERT', NULL, NEW.valorVenda);
END//
DELIMITER ;


-- nega a inserção de veiculos antigos demais
DELIMITER //
CREATE TRIGGER deny_insert_antig_veicu
    BEFORE INSERT ON Veiculo
    FOR EACH ROW
BEGIN
    IF NEW.ano < 2010 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ano do veículo inválido (não pode ser anterior a 2010).';
END IF;
END//
DELIMITER ;

-- negar update de antigos veiculos
DELIMITER //
CREATE TRIGGER deny_update_antig_veicu
    BEFORE UPDATE ON Veiculo
    FOR EACH ROW
BEGIN
    IF NEW.ano < 2010 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ano do veículo inválido (não pode ser anterior a 2010).';
END IF;
END//
DELIMITER ;

