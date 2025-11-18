package com.concessionaria.controller;

import com.concessionaria.model.Fornecedor;
import com.concessionaria.service.FornecedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService = new FornecedorService();

    @PostMapping
    public String salvarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.salvarFornecedor(fornecedor);
        return "Fornecedor salvo com sucesso!";
    }

    @PutMapping
    public String atualizarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.atualizarFornecedor(fornecedor);
        return "Fornecedor atualizado com sucesso!";
    }

    @DeleteMapping("/delete")
    public String deletarFornecedor(@RequestParam String cnpj) {
        fornecedorService.deletarFornecedor(cnpj);
        return "Fornecedor deletado com sucesso!";
    }

    @GetMapping
    public List<Fornecedor> listarFornecedores() {
        return fornecedorService.listarTodos();
    }

    @GetMapping("/{cnpj}")
    public Fornecedor buscarPorCnpj(@PathVariable String cnpj) {
        return fornecedorService.buscarPorCnpj(cnpj);
    }
}
