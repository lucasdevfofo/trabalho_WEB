package com.br.demo.service;

import com.br.demo.model.Categoria;
import com.br.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository repository = new CategoriaRepository();

    public Categoria create(Categoria categoria) {
        return repository.save(categoria);
    }

    public Optional<Categoria> getById(Long id) {
        return repository.findById(id);
    }

    public List<Categoria> getAll() {
        return repository.findAll();
    }

    public Categoria update(Long id, Categoria categoria) {
        Optional<Categoria> existing = repository.findById(id);
        if (existing.isPresent()) {
            Categoria updated = existing.get();
            updated.setNome(categoria.getNome());
            updated.setDescricao(categoria.getDescricao());
            return updated;
        }
        return null;
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}