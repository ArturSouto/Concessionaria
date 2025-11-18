package com.concessionaria.controller;

import com.concessionaria.model.Cliente;
import com.concessionaria.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.inserirCliente(cliente);
            return ResponseEntity.ok("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.atualizarCliente(cliente);
            return ResponseEntity.ok("Cliente atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deletarCliente(@PathVariable String cpf) {
        try {
            clienteService.deletarCliente(cpf);
            return ResponseEntity.ok("Cliente deletado com sucesso!");
        } catch (Exception e) {
            if (e.getMessage().contains("foreign key") ||
                    e.getMessage().contains("a foreign key constraint fails")) {
                return ResponseEntity.status(400)
                        .body("Não é possível deletar: este cliente possui vendas associadas.");
            }
            return ResponseEntity.status(500).body("Erro ao deletar cliente: " + e.getMessage());
        }
    }
}
