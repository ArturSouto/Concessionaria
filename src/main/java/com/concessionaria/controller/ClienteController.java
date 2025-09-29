package com.concessionaria.controller;

import com.concessionaria.model.Cliente;
import com.concessionaria.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService = new ClienteService();

    @PostMapping
    public String salvarCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return "Cliente salvo com sucesso!";
    }

    @PutMapping
    public String atualizarCliente(@RequestBody Cliente cliente) {
        clienteService.atualizarCliente(cliente);
        return "Cliente atualizado com sucesso!";
    }

    @DeleteMapping("/{cpf}")
    public String deletarCliente(@PathVariable String cpf) {
        clienteService.deletarCliente(cpf);
        return "Cliente deletado com sucesso!";
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarTodos();
    }
}
