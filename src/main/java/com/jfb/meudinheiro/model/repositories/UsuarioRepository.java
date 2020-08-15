package com.jfb.meudinheiro.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfb.meudinheiro.model.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario	, Integer> {
}
