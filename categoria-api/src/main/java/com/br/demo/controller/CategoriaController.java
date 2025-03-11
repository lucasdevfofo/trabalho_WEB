package com.br.demo.controller;

import com.br.demo.model.Categoria;
import com.br.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return service.create(categoria);
    }

    @GetMapping
    public List<Categoria> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.update(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}