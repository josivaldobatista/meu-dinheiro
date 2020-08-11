package com.jfb.meudinheiro.model.repositories;

import com.jfb.meudinheiro.model.entities.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
