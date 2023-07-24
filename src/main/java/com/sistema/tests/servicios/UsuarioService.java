package com.sistema.tests.servicios;

import com.sistema.tests.entidades.Usuario;
import com.sistema.tests.entidades.UsuarioRol;

import java.util.Set;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    Usuario obtenerUsuario(String username);

    void eliminarUsuario(Long usuarioId);

    boolean existeNombreUsuario(String username);

    boolean existeEmail(String email);

    boolean existeTelefono(String telefono);
}
