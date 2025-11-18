package com.concessionaria.controller;

import com.concessionaria.model.Cliente;
import com.concessionaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public String salvar(@RequestBody Cliente cliente) throws SQLException {
        service.salvarCliente(cliente);;
        return "Cliente inserido com sucesso!";
    }

    @GetMapping
    public List<Cliente> listar() throws SQLException {
        return service.listarTodos();
    }

    @GetMapping("/{cpf}")
    public Cliente buscarPorCpf(@PathVariable String cpf) throws SQLException {
        return service.buscarPorCpf(cpf);
    }

    @PutMapping("/{cpf}")
    public String atualizar(@PathVariable String cpf, @RequestBody Cliente cliente) throws SQLException {
        cliente.setCpf(cpf);
        service.atualizarCliente(cliente);
        return "Cliente atualizado com sucesso!";
    }

    @DeleteMapping("/{cpf}")
    public String deletar(@PathVariable String cpf) throws SQLException {
        service.deletarCliente(cpf);
        return "Cliente removido com sucesso!";
    }
}