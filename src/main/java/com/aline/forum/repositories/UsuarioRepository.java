package com.aline.forum.repositories;

import com.aline.forum.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String email);

    @Query("SELECT usu FROM Usuario usu WHERE usu.email =:email")
    Usuario findByUserEmail(String email);
}
