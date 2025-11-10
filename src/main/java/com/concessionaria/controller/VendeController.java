package com.concessionaria.controller;

import com.concessionaria.model.Vende;
import com.concessionaria.service.VendeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendeController {

    private final VendeService vendeService = new VendeService();

    @PostMapping
    public String salvarVenda(@RequestBody Vende vende) {
        vendeService.salvarVenda(vende);
        return "Venda salva com sucesso!";
    }

    @PutMapping
    public String atualizarVenda(@RequestBody Vende vende) {
        vendeService.atualizarVenda(vende);
        return "Venda atualizada com sucesso!";
    }

    @DeleteMapping("/{idvenda}")
    public String deletarVenda(@PathVariable String idvenda) {
        vendeService.deletarVenda(idvenda);
        return "Venda deletada com sucesso!";
    }

    @GetMapping
    public List<Vende> listarVendas() {
        return vendeService.listarTodas();
    }
}
