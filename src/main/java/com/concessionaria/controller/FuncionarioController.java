package com.concessionaria.controller;

import com.concessionaria.model.Funcionario;
import com.concessionaria.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService = new FuncionarioService();

    @PostMapping
    public String salvarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.salvarFuncionario(funcionario);
        return "Funcionario salvo com sucesso!";
    }

    @PutMapping
    public String atualizarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.atualizarFuncionario(funcionario);
        return "Funcionario atualizado com sucesso!";
    }

    @DeleteMapping("/{cpf}")
    public String deletarFuncionario(@PathVariable String cpf) {
        funcionarioService.deletarFuncionario(cpf);
        return "Funcionario deletado com sucesso!";
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarTodos();
    }
}
