package com.jfb.meudinheiro;

import com.jfb.meudinheiro.model.entities.Cliente;
import com.jfb.meudinheiro.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MeuDinheiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuDinheiroApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {
		return args -> {
			Cliente cliente = new Cliente(null, "Maria Clara Batista",
					"96136026074", null); 
			repository.save(cliente);
		};
	}

}
