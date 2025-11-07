package com.concessionaria.controller;

import com.concessionaria.model.Moto;
import com.concessionaria.service.MotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    private final MotoService motoService = new MotoService();

    @PostMapping
    public String salvarMoto(@RequestBody Moto moto) {
        motoService.salvarMoto(moto);
        return "Moto salva com sucesso!";
    }

    @PutMapping
    public String atualizarMoto(@RequestBody Moto moto) {
        motoService.atualizarMoto(moto);
        return "Moto atualizada com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletarMoto(@PathVariable int id) {
        motoService.deletarMoto(id);
        return "Moto deletada com sucesso!";
    }

    @GetMapping
    public List<Moto> listarMotos() {
        return motoService.listarTodos();
    }
}
