package com.david.forum.controller;

import com.david.forum.entidades.Topico;
import com.david.forum.entidades.topico.CadastrarTopico;
import com.david.forum.entidades.topico.DetalhesTopico;
import com.david.forum.entidades.topico.ListaTopicos;
import com.david.forum.repositories.TopicoRepository;
import com.david.forum.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid CadastrarTopico dados, UriComponentsBuilder builder) {
        var topico = new Topico(dados, usuarioRepository);
        repository.save(topico);

        var uri = builder.path("/topicos/{id}")
                .buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListaTopicos>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = repository.findAll(paginacao)
                .map(ListaTopicos::new);

        return ResponseEntity.ok(page);
    }
}
