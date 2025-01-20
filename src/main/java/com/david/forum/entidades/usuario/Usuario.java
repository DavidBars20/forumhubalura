package com.david.forum.entidades.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Usuario(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String senha) {
}
