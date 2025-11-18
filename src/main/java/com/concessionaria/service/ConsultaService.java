package com.concessionaria.service;
import org.springframework.stereotype.Service;
import com.concessionaria.dao.ConsultaDAO;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaDAO dao = new ConsultaDAO();

    public List<String> listarCarros() {
        try {
            return dao.listarCarros();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listarClientes() {
        try {
            return dao.listarClientes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listarFuncionarios() {
        try {
            return dao.listarFuncionarios();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listarVendas() {
        try {
            return dao.listarVendas();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listarVeiculos() {
        try {
            return dao.listarVeiculos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}