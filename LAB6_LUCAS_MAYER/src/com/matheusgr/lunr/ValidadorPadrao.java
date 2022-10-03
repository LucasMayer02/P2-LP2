package com.matheusgr.lunr;

import java.util.Objects;

/**
 * Classe de valida��o padr�o para entidades b�sicas do sistema.
 * 
 * A classe por si � uma base para outros validadores.
 * 
 * No Lunr apenas o ID � uma entidade padr�o.
 */
public abstract class ValidadorPadrao {

	/**
	 * Opera��o de valida��o do ID.
	 * 
	 * As duas regras de valida��o � a de que o ID n�o pode ser nulo e n�o pode ser
	 * vazio.
	 * 
	 * � preciso ter cuidado que o sistema pode gerar alguns IDs automaticamente
	 * (MERGE) mas cabe ao usu�rio se quiser fazer uso (ou n�o) desses tipos de IDs.
	 * 
	 * @param id ID a ser validado.
	 */
	public void validacao(String id) {
		Objects.requireNonNull(id, "ID n�o pode ser nulo");
		if (id.isBlank()) {
			throw new IllegalArgumentException("ID n�o pode ser vazio");
		}
	}

}