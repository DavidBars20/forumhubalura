package com.david.forum.entidades.topico;

import com.david.forum.entidades.Resposta;
import com.david.forum.entidades.Status;
import com.david.forum.entidades.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record DetalhesTopico(
        Long id,
        String titulo,
        String mensagem,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,
        Status status,
        String autor,
        String curso,
        List<Resposta> respostas
)
{
    public DetalhesTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getNome(),
                topico.getCurso(),
                topico.getRespostas()
        );
    }
}
