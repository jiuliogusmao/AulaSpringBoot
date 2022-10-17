package br.ufsc.cursofs.AulaSpringBoot.controllers.exceptions;

public class ObjectNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ObjectNaoEncontradoException(Object id) {
		super("Objeto não encontrado: " + id);
	}
}
