package com.concessionaria.service;

import com.concessionaria.model.Moto;
import com.concessionaria.repository.MotoRepository;

import java.util.List;

public class MotoService {

    private final MotoRepository motoRepository = new MotoRepository();

    public void salvarMoto(Moto moto) {
        motoRepository.inserir(moto);
    }

    public void atualizarMoto(Moto moto) {
        motoRepository.atualizar(moto);
    }

    public void deletarMoto(int id) {
        motoRepository.deletar(id);
    }

    public List<Moto> listarTodos() {
        return motoRepository.listar();
    }
}
