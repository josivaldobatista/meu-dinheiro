package com.jfb.meudinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jfb.meudinheiro.model.entities.Usuario;
import com.jfb.meudinheiro.model.repositories.UsuarioRepository;

@Service
public class UsuarioService  implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
		return User.builder()
				   .username(usuario.getUsuario())
				   .password(usuario.getSenha())
				   .roles("USER").build();
	}

}
