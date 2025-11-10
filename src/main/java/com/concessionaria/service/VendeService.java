package com.concessionaria.service;

import com.concessionaria.model.Vende;
import com.concessionaria.repository.VendeRepository;

import java.util.List;

public class VendeService {

    private final VendeRepository vendeRepository = new VendeRepository();

    public void salvarVenda(Vende vende) {
        vendeRepository.inserir(vende);
    }

    public void atualizarVenda(Vende vende) {
        vendeRepository.atualizar(vende);
    }

    public void deletarVenda(String idvenda) {
        vendeRepository.deletar(idvenda);
    }

    public List<Vende> listarTodas() {
        return vendeRepository.listar();
    }
}
