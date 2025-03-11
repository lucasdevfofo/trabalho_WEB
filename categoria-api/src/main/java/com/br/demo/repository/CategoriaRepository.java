package com.br.demo.repository;

import com.br.demo.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaRepository {
    private List<Categoria> categorias = new ArrayList<>();
    private Long idCounter = 1L;

    public Categoria save(Categoria categoria) {
        categoria.setId(idCounter++);
        categorias.add(categoria);
        return categoria;
    }

    public Optional<Categoria> findById(Long id) {
        return categorias.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public List<Categoria> findAll() {
        return categorias;
    }

    public void delete(Long id) {
        categorias.removeIf(c -> c.getId().equals(id));
    }
}