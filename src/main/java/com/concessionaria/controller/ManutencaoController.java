package com.concessionaria.controller;

import com.concessionaria.model.Manutencao;
import com.concessionaria.service.ManutencaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    private final ManutencaoService manutencaoService = new ManutencaoService();

    @PostMapping
    public String salvarManutencao(@RequestBody Manutencao manutencao) {
        manutencaoService.salvarManutencao(manutencao);
        return "Manutenção salva com sucesso!";
    }

    @PutMapping
    public String atualizarManutencao(@RequestBody Manutencao manutencao) {
        manutencaoService.atualizarManutencao(manutencao);
        return "Manutenção atualizada com sucesso!";
    }

    @DeleteMapping("/{idmanutencao}")
    public String deletarManutencao(@PathVariable String idmanutencao) {
        manutencaoService.deletarManutencao(idmanutencao);
        return "Manutenção deletada com sucesso!";
    }

    @GetMapping
    public List<Manutencao> listarManutencoes() {
        return manutencaoService.listarTodas();
    }
}
