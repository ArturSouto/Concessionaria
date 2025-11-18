package com.concessionaria.service;

import com.concessionaria.dao.ClienteDAO;
import com.concessionaria.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteDAO dao = new ClienteDAO();

    public void salvarCliente(Cliente c) {
        try {
            dao.inserir(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> listarTodos() {
        try {
            return dao.listar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarCliente(Cliente c) {
        try {
            dao.atualizar(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarCliente(String cpf) {
        try {
            dao.deletar(cpf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        try {
            return dao.buscarPorCpf(cpf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
