use concessionaria;

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
