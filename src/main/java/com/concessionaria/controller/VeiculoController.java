package com.concessionaria.controller;

import com.concessionaria.model.Veiculo;
import com.concessionaria.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService = new VeiculoService();

    @PostMapping
    public String salvarVeiculo(@RequestBody Veiculo veiculo) {
        veiculoService.salvarVeiculo(veiculo);
        return "Veículo salvo com sucesso!";
    }

    @PutMapping
    public String atualizarVeiculo(@RequestBody Veiculo veiculo) {
        veiculoService.atualizarVeiculo(veiculo);
        return "Veículo atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletarVeiculo(@PathVariable int id) {
        veiculoService.deletarVeiculo(id);
        return "Veículo deletado com sucesso!";
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarTodos();
    }
}
