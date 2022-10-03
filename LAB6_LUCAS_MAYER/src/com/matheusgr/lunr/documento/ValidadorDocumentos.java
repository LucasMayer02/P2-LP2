package com.matheusgr.lunr.documento;

import java.util.Objects;

import com.matheusgr.lunr.ValidadorPadrao;

/**
 * Classe de valida��o de documento. Os documentos s�o v�lidos se todos os seus
 * termos n�o forem nulos. Nem deve ser poss�vel ter IDs nulos ou vazios.
 */
class ValidadorDocumentos extends ValidadorPadrao {

	/**
	 * Opera��o padr�o de valida��o de ID e de conte�do (texto a ser processado). O
	 * conte�do n�o pode ser nulo ou vazio, bem como o ID deve ser v�lido.
	 * 
	 * @param id       ID a ser validado.
	 * @param conteudo Conte�do a ser validado.
	 */
	public void validacao(String id, String conteudo) {
		validacao(id);
		Objects.requireNonNull(conteudo, "Conte�do n�o pode ser nulo");
		if (conteudo.isBlank()) {
			throw new IllegalArgumentException("Conte�do n�o pode ser vazio");
		}
	}

	/**
	 * Valida o ID e os termos de um documento. Nenhum termo pode ser vazio/nulo.
	 * 
	 * @param id    ID do documento a ser validado.
	 * @param texto Termos do documento.
	 */
	public void validacao(String id, String[] texto) {
		validacao(id);
		Objects.requireNonNull(texto, "Conte�do n�o pode ser nulo");
		int i = 0;
		for (String t : texto) {
			i += 1;
			if (t.isBlank()) {
				throw new IllegalArgumentException("Termo n�o pode ser vazio: termo " + i + " de " + texto.length);
			}
		}
	}

}
