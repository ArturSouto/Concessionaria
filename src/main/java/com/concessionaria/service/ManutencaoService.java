package com.concessionaria.service;

import com.concessionaria.model.Manutencao;
import com.concessionaria.repository.ManutencaoRepository;

import java.util.List;

public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository = new ManutencaoRepository();

    public void salvarManutencao(Manutencao manutencao) {
        manutencaoRepository.inserir(manutencao);
    }

    public void atualizarManutencao(Manutencao manutencao) {
        manutencaoRepository.atualizar(manutencao);
    }

    public void deletarManutencao(String idmanutencao) {
        manutencaoRepository.deletar(idmanutencao);
    }

    public List<Manutencao> listarTodas() {
        return manutencaoRepository.listar();
    }
}
