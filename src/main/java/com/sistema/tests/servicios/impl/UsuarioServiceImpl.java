package com.sistema.tests.servicios.impl;

import com.sistema.tests.entidades.Usuario;
import com.sistema.tests.entidades.UsuarioRol;
import com.sistema.tests.repositorios.RolRepository;
import com.sistema.tests.repositorios.UsuarioRepository;
import com.sistema.tests.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioExistente = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioExistente != null) {
            throw new Exception("El nombre de usuario ya existe");
        }

        usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new Exception("El email ya está en uso");
        }

        usuarioExistente = usuarioRepository.findByTelefono(usuario.getTelefono());
        if (usuarioExistente != null) {
            throw new Exception("El teléfono ya está en uso");
        }

        for (UsuarioRol usuarioRol : usuarioRoles) {
            rolRepository.save(usuarioRol.getRol());
        }

        usuario.getUsuarioRoles().addAll(usuarioRoles);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public boolean existeNombreUsuario(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        return usuario != null;
    }

    @Override
    public boolean existeEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null;
    }

    @Override
    public boolean existeTelefono(String telefono) {
        Usuario usuario = usuarioRepository.findByTelefono(telefono);
        return usuario != null;
    }
}
