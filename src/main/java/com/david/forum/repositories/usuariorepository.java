package com.david.forum.repositories;

import com.david.forum.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface usuariorepository extends JpaRepository <Usuario, Long> {
    UserDetails findByEmail(String Email);
}
