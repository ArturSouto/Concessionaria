package com.concessionaria.service;

import com.concessionaria.model.Fornecedor;
import com.concessionaria.repository.FornecedorRepository;

import java.util.List;

public class FornecedorService {

    private final FornecedorRepository fornecedorRepository = new FornecedorRepository();

    // Salvar novo fornecedor
    public void salvarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.inserir(fornecedor);
    }

    // Atualizar fornecedor
    public void atualizarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.atualizar(fornecedor);
    }

    // Deletar fornecedor por CNPJ
    public void deletarFornecedor(String cnpj) {
        fornecedorRepository.deletar(cnpj);
    }

    // Listar todos os fornecedores
    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.listar();
    }

    // Buscar fornecedor por CNPJ
    public Fornecedor buscarPorCnpj(String cnpj) {
        return fornecedorRepository.buscarPorCnpj(cnpj);
    }
}
