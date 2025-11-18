package com.concessionaria.controller;

import com.concessionaria.model.Carro;
import com.concessionaria.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private CarroService service = new CarroService();

    @PostMapping
    public String salvar(@RequestBody Carro carro) {
        service.inserir(carro);
        return "Carro inserido com sucesso!";
    }

    @GetMapping
    public List<Carro> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody Carro carro) {
        carro.setId(id);
        service.atualizar(carro);
        return "Carro atualizado!";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id) {
        service.deletar(id);
        return "Carro removido!";
    }
}


