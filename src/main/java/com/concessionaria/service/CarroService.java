package com.concessionaria.service;

import com.concessionaria.dao.CarroDAO;
import com.concessionaria.model.Carro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarroService {

    private final CarroDAO carroDAO;

    public CarroService(CarroDAO carroDAO) {
        this.carroDAO = carroDAO;
    }

    public void inserirCarro(Carro carro) {
        try {
            carroDAO.inserir(carro);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir carro", e);
        }
    }

    public List<Carro> listarCarros() {
        try {
            return carroDAO.listar();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar carros", e);
        }
    }

    public void atualizarCarro(Carro carro) {
        try {
            carroDAO.atualizar(carro);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar carro", e);
        }
    }

    public void deletarCarro(int id) {
        try {
            carroDAO.deletar(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar carro", e);
        }
    }
}
