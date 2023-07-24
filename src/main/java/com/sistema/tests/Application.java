package com.sistema.tests;

import com.sistema.tests.entidades.Rol;
import com.sistema.tests.entidades.Usuario;
import com.sistema.tests.entidades.UsuarioRol;
import com.sistema.tests.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
		// Aquí puedes agregar lógica adicional si es necesario
	}

	// Configuración para permitir CORS
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/usuarios/**") // Ajusta el patrón para tus rutas
						.allowedOrigins("http://localhost:4200") // Origen permitido (frontend)
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
						.allowedHeaders("Content-Type", "Authorization"); // Encabezados permitidos
			}
		};
	}
}
