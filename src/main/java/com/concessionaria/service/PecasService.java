package com.concessionaria.service;

import com.concessionaria.model.Pecas;
import com.concessionaria.repository.PecasRepository;

import java.util.List;

public class PecasService {

    private final PecasRepository pecasRepository = new PecasRepository();

    // Salvar nova peça
    public void salvarPeca(Pecas peca) {
        pecasRepository.inserir(peca);
    }

    // Atualizar peça
    public void atualizarPeca(Pecas peca) {
        pecasRepository.atualizar(peca);
    }

    // Deletar peça por código
    public void deletarPeca(String codPeca) {
        pecasRepository.deletar(codPeca);
    }

    // Listar todas as peças
    public List<Pecas> listarTodas() {
        return pecasRepository.listar();
    }
}
