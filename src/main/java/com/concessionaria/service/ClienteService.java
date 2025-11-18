package com.concessionaria.service;

import com.concessionaria.dao.ClienteDAO;
import com.concessionaria.model.Cliente;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> listarClientes() {
        try {
            return clienteDAO.listar();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
    }

    public void inserirCliente(Cliente cliente) {
        try {
            clienteDAO.inserir(cliente);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public void atualizarCliente(Cliente cliente) {
        try {
            clienteDAO.atualizar(cliente);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void deletarCliente(String cpf) {
        try {
            clienteDAO.deletar(cpf);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar cliente: " + e.getMessage());
        }
    }
}
