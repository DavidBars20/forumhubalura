package com.david.forum.entidades.usuario;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuario(
        @NotBlank
        String email,

        @NotBlank
        String nome,

        @NotBlank
        String senha
) { }
