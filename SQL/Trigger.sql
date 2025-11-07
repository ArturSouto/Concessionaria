use concessionaria;

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
