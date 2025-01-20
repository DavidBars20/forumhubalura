package com.david.forum.controller;

import com.david.forum.entidades.Usuario;
import com.david.forum.entidades.usuario.CadastroUsuario;
import com.david.forum.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroUsuario dados) {
        if (repository.findByEmail(dados.email()) != null) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }

        var usuario = new Usuario(dados);
        usuario.setSenha(passwordEncoder.encode(dados.senha()));
        repository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
