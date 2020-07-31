package com.jfb.meudinheiro.model.repositories;

import com.jfb.meudinheiro.model.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
