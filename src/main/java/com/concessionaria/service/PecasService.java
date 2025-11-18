package com.concessionaria.service;

import com.concessionaria.dao.PecasDAO;
import com.concessionaria.model.Pecas;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PecasService {

    private final PecasDAO dao = new PecasDAO();

    public void salvarPeca(Pecas p) {
        try {
            dao.inserir(p);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar peça: " + e.getMessage(), e);
        }
    }

    public List<Pecas> listarTodas() {
        try {
            return dao.listarTodas();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar peças: " + e.getMessage(), e);
        }
    }

    public Pecas buscarPorId(String codPeca) {
        try {
            return dao.buscarPorId(codPeca);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar peça: " + e.getMessage(), e);
        }
    }

    public void atualizarPeca(Pecas p) {
        try {
            dao.atualizar(p);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar peça: " + e.getMessage(), e);
        }
    }

    public void deletarPeca(String codPeca) {
        try {
            dao.deletar(codPeca);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar peça: " + e.getMessage(), e);
        }
    }
}