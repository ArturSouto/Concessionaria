package com.concessionaria.service;

import com.concessionaria.model.Veiculo;
import com.concessionaria.repository.VeiculoRepository;

import java.util.List;

public class VeiculoService {

    private final VeiculoRepository veiculoRepository = new VeiculoRepository();

    public void salvarVeiculo(Veiculo veiculo) {
        veiculoRepository.inserir(veiculo);
    }

    public void atualizarVeiculo(Veiculo veiculo) {
        veiculoRepository.atualizar(veiculo);
    }

    public void deletarVeiculo(int id) {
        veiculoRepository.deletar(id);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.listar();
    }
}
