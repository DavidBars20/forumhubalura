package com.david.forum.entidades.topico;

import jakarta.validation.constraints.NotNull;

public record AtualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        String curso
) {
}
