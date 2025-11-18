package com.concessionaria.service;

import com.concessionaria.dao.MotoDAO;
import com.concessionaria.model.Moto;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MotoService {

    private final MotoDAO dao = new MotoDAO();

    public void salvarMoto(Moto m) {
        try {
            dao.inserir(m);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar moto: " + e.getMessage(), e);
        }
    }

    public List<Moto> listarTodos() {
        try {
            return dao.listarTodas();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar motos: " + e.getMessage(), e);
        }
    }

    public Moto buscarPorId(int id) {
        try {
            return dao.buscarPorId(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar moto: " + e.getMessage(), e);
        }
    }

    public void atualizarMoto(Moto m) {
        try {
            dao.atualizar(m);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar moto: " + e.getMessage(), e);
        }
    }

    public void deletarMoto(int id) {
        try {
            dao.deletar(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar moto: " + e.getMessage(), e);
        }
    }
}
