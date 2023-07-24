package com.sistema.tests.controladores;

import com.sistema.tests.entidades.Rol;
import com.sistema.tests.entidades.Usuario;
import com.sistema.tests.entidades.UsuarioRol;
import com.sistema.tests.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        usuario.setPerfil("default.png");
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);

        // Validar la existencia de usuario por nombre de usuario, email y teléfono
        if (usuarioService.existeNombreUsuario(usuario.getUsername())) {
            throw new Exception("El nombre de usuario ya existe");
        }

        if (usuarioService.existeEmail(usuario.getEmail())) {
            throw new Exception("El email ya está en uso");
        }

        if (usuarioService.existeTelefono(usuario.getTelefono())) {
            throw new Exception("El teléfono ya está en uso");
        }

        return usuarioService.guardarUsuario(usuario, usuarioRoles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
        usuarioService.eliminarUsuario(usuarioId);
    }
}
