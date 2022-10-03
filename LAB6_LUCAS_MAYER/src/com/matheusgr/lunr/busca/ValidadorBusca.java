package com.matheusgr.lunr.busca;

import java.util.Objects;

import com.matheusgr.lunr.ValidadorPadrao;

/**
 * Classe para valida��o da busca, suas entidades e par�metros.
 */
class ValidadorBusca extends ValidadorPadrao {

	/**
	 * Valida os termos de busca. Os termos de busca n�o podem ser objetos nulos
	 * e pelo menos um termo deve ser n�o vazio.
	 * 
	 * @param termos Termos a serem buscados.
	 */
	public void valida(String[] termos) {
		Objects.requireNonNull(termos, "Conte�do n�o pode ser nulo");
		for (String t : termos) {
			if (!t.isBlank()) {
				return;
			}
		}
		throw new IllegalArgumentException("Pelo menos um termo n�o deve ser vazio");
	}

	/**
	 * Valida o n�mero do hist�rico de busca. Deve ser positivo.
	 * 
	 * @param numeroBusca N�mero de busca a ser validado.
	 */
	public void valida(int numeroBusca) {
		if (numeroBusca < 0) {
			throw new IllegalArgumentException("Apenas n�meros positivos s�o v�lidos para hist�rico de busca");
		}
	}

}
