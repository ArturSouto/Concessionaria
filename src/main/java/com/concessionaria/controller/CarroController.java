package com.concessionaria.controller;

import com.concessionaria.model.Carro;
import com.concessionaria.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService = new CarroService();

    @PostMapping
    public String salvarCarro(@RequestBody Carro carro) {
        carroService.salvarCarro(carro);
        return "Carro salvo com sucesso!";
    }

    @PutMapping
    public String atualizarCarro(@RequestBody Carro carro) {
        carroService.atualizarCarro(carro);
        return "Carro atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletarCarro(@PathVariable int id) {
        carroService.deletarCarro(id);
        return "Carro deletado com sucesso!";
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.listarTodos();
    }
}
