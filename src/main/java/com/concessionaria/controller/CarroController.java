package com.concessionaria.controller;

import com.concessionaria.model.Carro;
import com.concessionaria.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
@CrossOrigin("*")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public void inserir(@RequestBody Carro carro) {
        carroService.inserirCarro(carro);
    }

    @GetMapping
    public List<Carro> listar() {
        return carroService.listarCarros();
    }

    @PutMapping
    public void atualizar(@RequestBody Carro carro) {
        carroService.atualizarCarro(carro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        carroService.deletarCarro(id);
    }
}
