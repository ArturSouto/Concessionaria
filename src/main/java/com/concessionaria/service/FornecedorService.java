package com.concessionaria.service;

import com.concessionaria.model.Fornecedor;
import com.concessionaria.repository.FornecedorRepository;

import java.util.List;

public class FornecedorService {

    private final FornecedorRepository fornecedorRepository = new FornecedorRepository();

    public void salvarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.inserir(fornecedor);
    }

    public void atualizarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.atualizar(fornecedor);
    }

    public void deletarFornecedor(String cnpj) {
        fornecedorRepository.deletar(cnpj);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.listar();
    }

    public Fornecedor buscarPorCnpj(String cnpj) {
        return fornecedorRepository.buscarPorCnpj(cnpj);
    }
}
