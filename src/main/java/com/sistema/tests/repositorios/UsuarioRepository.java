package com.sistema.tests.repositorios;

import com.sistema.tests.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByUsername(String username);
}
