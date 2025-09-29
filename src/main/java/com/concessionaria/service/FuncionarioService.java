package com.concessionaria.service;

import com.concessionaria.model.Funcionario;
import com.concessionaria.repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public void salvarFuncionario(Funcionario funcionario) {
        funcionarioRepository.salvar(funcionario);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        funcionarioRepository.atualizar(funcionario);
    }

    public void deletarFuncionario(String cpf) {
        funcionarioRepository.deletar(cpf);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.listarTodos();
    }
}
