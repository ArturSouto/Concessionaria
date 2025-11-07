package com.concessionaria.service;

import com.concessionaria.model.Carro;
import com.concessionaria.repository.CarroRepository;

import java.util.List;

public class CarroService {

    private final CarroRepository carroRepository = new CarroRepository();

    public void salvarCarro(Carro carro) {
        carroRepository.inserir(carro);
    }

    public void atualizarCarro(Carro carro) {
        carroRepository.atualizar(carro);
    }

    public void deletarCarro(int id) {
        carroRepository.deletar(id);
    }

    public List<Carro> listarTodos() {
        return carroRepository.listar();
    }
}
