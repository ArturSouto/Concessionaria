package com.concessionaria.service;

import com.concessionaria.dao.FornecedorDAO;
import com.concessionaria.model.Fornecedor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorDAO dao = new FornecedorDAO();

    public void salvarFornecedor(Fornecedor fornecedor) {
        try {
            dao.inserir(fornecedor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir fornecedor: " + e.getMessage());
        }
    }

    public void atualizarFornecedor(Fornecedor fornecedor) {
        try {
            dao.atualizar(fornecedor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar fornecedor: " + e.getMessage());
        }
    }

    public void deletarFornecedor(String cnpj) {
        try {
            dao.excluir(cnpj);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar fornecedor: " + e.getMessage());
        }
    }

    public List<Fornecedor> listarTodos() {
        try {
            return dao.listar();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar fornecedores: " + e.getMessage());
        }
    }

    public Fornecedor buscarPorCnpj(String cnpj) {
        try {
            return dao.buscarPorCnpj(cnpj);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar fornecedor por CNPJ: " + e.getMessage());
        }
    }
}