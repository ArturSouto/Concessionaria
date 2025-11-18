package com.concessionaria.service;

import com.concessionaria.dao.CarroDAO;
import com.concessionaria.model.Carro;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class CarroService {

    private CarroDAO dao = new CarroDAO();

    public void inserir(Carro c) {
        dao.inserir(c);
    }

    public List<Carro> listar() {
        return dao.listar();
    }

    public void atualizar(Carro c) {
        dao.atualizar(c);
    }

    public void deletar(int id) {
        dao.deletar(id);
    }
}