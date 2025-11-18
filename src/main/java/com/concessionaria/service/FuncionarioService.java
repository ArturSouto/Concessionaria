package com.concessionaria.service;

import com.concessionaria.dao.FuncionarioDAO;
import com.concessionaria.model.Funcionario;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioDAO dao = new FuncionarioDAO();

    public void salvarFuncionario(Funcionario funcionario) {
        try {
            dao.inserir(funcionario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir funcionario: " + e.getMessage());
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        try {
            dao.atualizar(funcionario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar funcionario: " + e.getMessage());
        }
    }

    public void deletarFuncionario(String cpf) {
        try {
            dao.excluir(cpf);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar funcionario: " + e.getMessage());
        }
    }

    public List<Funcionario> listarTodos() {
        try {
            return dao.listar();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar funcionarios: " + e.getMessage());
        }
    }
}