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

	@Bean
	public CommandLineRunner run(@Autowired ClienteRepository repository) {
		return args -> {
			Cliente cliente = Cliente.builder()
					.cpf("76392763066")
					.nome("Ana Clara Batista")
					.build();
			repository.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MeuDinheiroApplication.class, args);
	}

}
