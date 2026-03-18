package com.bn.authors.services;

import com.bn.authors.models.AutorModel;
import com.bn.authors.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorModel criarAutor(AutorModel autorModel) {
        return autorRepository.save(autorModel);
    }

    public List<AutorModel> buscarTodosAutores() {
        return autorRepository.findAll();
    }

    public Optional<AutorModel> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public void deletarAutor(Long id) {
        autorRepository.deleteById(id);
    }

}