package com.veterinaria.mascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MascotasApiApplication {

	public static void main(String[] args) { //Este metodo iniciliza el servidor Tomcat de manera automatica
		SpringApplication.run(MascotasApiApplication.class, args);
	}

}
