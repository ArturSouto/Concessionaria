package com.concessionaria.controller;

import com.concessionaria.model.Pecas;
import com.concessionaria.service.PecasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pecas")
public class PecasController {

    private final PecasService pecasService = new PecasService();

    @PostMapping
    public String salvarPeca(@RequestBody Pecas peca) {
        pecasService.salvarPeca(peca);
        return "Peça salva com sucesso!";
    }

    @PutMapping
    public String atualizarPeca(@RequestBody Pecas peca) {
        pecasService.atualizarPeca(peca);
        return "Peça atualizada com sucesso!";
    }

    @DeleteMapping("/{codPeca}")
    public String deletarPeca(@PathVariable String codPeca) {
        pecasService.deletarPeca(codPeca);
        return "Peça deletada com sucesso!";
    }

    @GetMapping
    public List<Pecas> listarPecas() {
        return pecasService.listarTodas();
    }
}
