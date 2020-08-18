package com.jfb.meudinheiro.exceptions;

public class UsuarioCadastradoExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsuarioCadastradoExceptions(String usuario) {
		super("Usuário já cadastrado para o Login: " + usuario  );
	}
}
