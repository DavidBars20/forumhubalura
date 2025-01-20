package com.david.forum.repositories;

import com.david.forum.entidades.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository <Topico, Long> {
    Optional<Topico> findByTituloAndMessagem (String titulo, String mensagem);
}
