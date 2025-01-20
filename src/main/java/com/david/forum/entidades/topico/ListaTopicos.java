package com.david.forum.entidades.topico;

import com.david.forum.entidades.Status;
import com.david.forum.entidades.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ListaTopicos(Long id,
                           String titulo,
                           String mensagem,
                           @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                          LocalDateTime dataCriacao,
                           Status status,
                           String autor,
                           String curso
)
{
    public ListaTopicos (Topico topico) {
    this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getDataCriacao(),
            topico.getStatus(),
            topico.getAutor().getNome(),
            topico.getCurso()
        );
    }
}
