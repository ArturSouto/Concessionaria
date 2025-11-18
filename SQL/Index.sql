-- Índice pra buscar veículos por fornecedor
CREATE INDEX idx_veiculo_cnpj ON Veiculo(CNPJ);

-- Índice pra filtrar por modelo do veículo
CREATE INDEX idx_veiculo_modelo ON Veiculo(modelo);

-- Índice pra buscar vendas por CPF de cliente
CREATE INDEX idx_vende_cpf ON Vende(CPF);

-- Índice pra procurar manutenções pelo ID do veículo
CREATE INDEX idx_manutencao_id ON Manutencao(id);
