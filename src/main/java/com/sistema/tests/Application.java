package com.sistema.tests;

import com.sistema.tests.entidades.Rol;
import com.sistema.tests.entidades.Usuario;
import com.sistema.tests.entidades.UsuarioRol;
import com.sistema.tests.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Usuario usuario = new Usuario();

		usuario.setNombre("Simón");
		usuario.setApellido("Cherry");
		usuario.setUsername("Saimonch16");
		usuario.setPassword("admin123");
		usuario.setEmail("simoncherry9@gmail.com");
		usuario.setTelefono("3416006068");
		usuario.setPerfil("foto.png");

		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());*/
	}
}
