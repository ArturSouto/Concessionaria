package com.concessionaria.service;

import com.concessionaria.dao.ManutencaoDAO;
import com.concessionaria.model.Manutencao;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ManutencaoService {

    private final ManutencaoDAO dao = new ManutencaoDAO();

    public void salvarManutencao(Manutencao m) {
        try {
            dao.inserir(m);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar manutenção: " + e.getMessage(), e);
        }
    }

    public List<Manutencao> listarTodas() {
        try {
            return dao.listarTodas();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar manutenções: " + e.getMessage(), e);
        }
    }

    public Manutencao buscarPorId(String id) {
        try {
            return dao.buscarPorId(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar manutenção: " + e.getMessage(), e);
        }
    }

    public void atualizarManutencao(Manutencao m) {
        try {
            dao.atualizar(m);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar manutenção: " + e.getMessage(), e);
        }
    }

    public void deletarManutencao(String id) {
        try {
            dao.deletar(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar manutenção: " + e.getMessage(), e);
        }
    }
}