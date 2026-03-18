package com.bn.authors.controllers;

import com.bn.authors.models.AutorModel;
import com.bn.authors.services.AutorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorModel> criarAutor(@RequestBody AutorModel autorModel) {
        AutorModel request = autorService.criarAutor(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> buscarTodosAutores() {
        List<AutorModel> request = autorService.buscarTodosAutores();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AutorModel>> buscarPorId(@PathVariable Long id) {
        Optional<AutorModel> request = autorService.buscarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id) {
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }

}
