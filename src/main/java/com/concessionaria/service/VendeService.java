package com.concessionaria.service;

import com.concessionaria.dao.VendeDAO;
import com.concessionaria.model.Vende;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VendeService {

    private VendeDAO vendeDAO = new VendeDAO();

    public void inserir(Vende venda) throws Exception {
        vendeDAO.inserir(venda);
    }

    public List<Vende> listarTodos() throws Exception {
        return vendeDAO.listarTodos();
    }

    public Vende buscarPorId(String idvenda) throws Exception {
        return vendeDAO.buscarPorId(idvenda);
    }

    public void atualizar(Vende venda) throws Exception {
        vendeDAO.atualizar(venda);
    }

    public void deletar(String idvenda) throws Exception {
        vendeDAO.deletar(idvenda);
    }
}