package com.concessionaria.controller;

import com.concessionaria.model.Veiculo;
import com.concessionaria.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    private final VeiculoService veiculoService = new VeiculoService();

    @PostMapping
    public ResponseEntity<String> salvarVeiculo(@RequestBody Veiculo veiculo) {
    try {
        veiculoService.salvarVeiculo(veiculo);
        return ResponseEntity.ok("✅ Veículo salvo com sucesso!");

    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("❌ " + e.getMessage());

    } catch (SQLException e) {
        return ResponseEntity.internalServerError()
                .body("❌ Erro de banco ao inserir veículo: " + e.getMessage());

    } catch (Exception e) {
        return ResponseEntity.internalServerError()
                .body("❌ Erro inesperado: " + e.getMessage());
    }
}

    @PutMapping
    public ResponseEntity<String> atualizarVeiculo(@RequestBody Veiculo veiculo) {
        try {
            veiculoService.atualizarVeiculo(veiculo);
            return ResponseEntity.ok("✅ Veículo atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Erro ao atualizar veículo: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable int id) {
        try {
            veiculoService.deletarVeiculo(id);
            return ResponseEntity.ok("✅ Veículo deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ Erro ao deletar veículo: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        try {
            List<Veiculo> lista = veiculoService.listarTodos();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
