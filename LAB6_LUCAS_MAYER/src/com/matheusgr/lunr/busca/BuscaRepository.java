package com.matheusgr.lunr.busca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.matheusgr.lunr.documento.DocumentoDTO;

/**
 * Entidade de reposit�rio para os hist�ricos de busca.
 * 
 * N�o h� necessidade de otimizar as buscas ou acesso para al�m da inser��o
 * ordenada e acesso a partir de um �ndice espec�fico.
 */
class BuscaRepository {

	private List<HistoricoBusca> buscas;
	private ValidadorBusca validador;

	/**
	 * Construtor padr�o para inicializa��o das entidades b�sicas.
	 */
	BuscaRepository() {
		this.buscas = new ArrayList<>();
		this.validador = new ValidadorBusca();
	}

	/**
	 * Cadastra uma busca no hist�rico.
	 * 
	 * @param buscaSimples Opera��o de busca realizada.
	 * @param documentos   Documentos resultantes dessa busca.
	 */
	public void adicionaBusca(BuscaSimples buscaSimples, DocumentoDTO[] documentos) {
		String[] ids = Stream.of(documentos)
			.map(DocumentoDTO::getId)
			.collect(Collectors.toList())
			.toArray(new String[] {});
		this.buscas.add(new HistoricoBusca(buscaSimples, ids));
	}

	/**
	 * Retorna um hist�rico de busca. O hist�rico � inserido na ordem em que as
	 * buscas s�o realizadas, associados a posi��o da busca na lista de buscas.
	 * 
	 * @param numero Posi��o (a partir de 0) do hist�rico de busca a ser retornado.
	 * @return Hist�rico de busca a ser retornado.
	 */
	public HistoricoBusca recuperar(int numero) {
		this.validador.valida(numero);
		if (numero > this.buscas.size()) {
			throw new IllegalArgumentException("Hist�rico inexistente: " + numero);
		}
		return this.buscas.get(numero);
	}

}