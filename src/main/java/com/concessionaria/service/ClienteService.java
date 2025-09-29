package com.concessionaria.service;

import com.concessionaria.model.Cliente;
import com.concessionaria.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private final ClienteRepository clienteRepository = new ClienteRepository();

    // Salvar novo cliente
    public void salvarCliente(Cliente cliente) {
        clienteRepository.inserir(cliente);
    }

    // Atualizar cliente
    public void atualizarCliente(Cliente cliente) {
        clienteRepository.atualizar(cliente);
    }

    // Deletar cliente por CPF
    public void deletarCliente(String cpf) {
        clienteRepository.deletar(cpf);
    }

    // Listar todos os clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.listar();
    }
}
