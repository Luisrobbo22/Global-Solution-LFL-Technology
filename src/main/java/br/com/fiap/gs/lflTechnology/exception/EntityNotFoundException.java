package br.com.fiap.gs.lflTechnology.exception;

public class EntityNotFoundException extends Exception {

	public EntityNotFoundException() {
		super("Entidade não encontrada");
	}

	public EntityNotFoundException(String msg) {
		super(msg);
	}

}

