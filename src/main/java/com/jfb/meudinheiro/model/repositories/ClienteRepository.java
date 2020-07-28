package com.jfb.meudinheiro.model.repositories;

import com.jfb.meudinheiro.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
