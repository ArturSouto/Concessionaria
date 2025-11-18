package com.concessionaria.controller;

import com.concessionaria.model.Vende;
import com.concessionaria.service.VendeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
@CrossOrigin(origins = "*")
public class VendeController {

    private final VendeService vendeService = new VendeService();

    @PostMapping
    public ResponseEntity<String> salvarVenda(@RequestBody Vende vende) {
        try {
            vendeService.inserir(vende);
            return ResponseEntity.ok("✅ Venda salva com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("❌ Erro ao salvar venda: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarVenda(@RequestBody Vende vende) {
        try {
            vendeService.atualizar(vende);
            return ResponseEntity.ok("✅ Venda atualizada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("❌ Erro ao atualizar venda: " + e.getMessage());
        }
    }

    @DeleteMapping("/{idvenda}")
    public ResponseEntity<String> deletarVenda(@PathVariable String idvenda) {
        try {
            vendeService.deletar(idvenda);
            return ResponseEntity.ok("🗑️ Venda deletada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("❌ Erro ao deletar venda: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Vende>> listarVendas() {
        try {
            List<Vende> lista = vendeService.listarTodos();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{idvenda}")
    public ResponseEntity<Vende> buscarPorId(@PathVariable String idvenda) {
        try {
            Vende venda = vendeService.buscarPorId(idvenda);

            if (venda == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(venda);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}