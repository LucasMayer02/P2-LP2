package com.matheusgr.lunr.busca;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoDTO;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaService � respons�vel por centralizar todas as opera��es de l�gica de
 * busca.
 * 
 * O BuscaService tem como atribui��es ordenar e limitar as buscas realizadas,
 * bem como cadastr�-las no hist�rico de buscas.
 * 
 * A busca em si � realizada por uma entidade recebida que deve retornar um mapa
 * de documentos que atende tais buscas e o valor de relev�ncia associado a cada
 * tipo de busca, onde o valor mais alto representa uma maior relev�ncia.
 */
public class BuscaService {

	private DocumentoService ds;
	private BuscaRepository br;

	/**
	 * Construtor padr�o, recebendo o DocumentoService para realizar as opera��es de
	 * documento, bem como preparar o reposit�rio de buscas.
	 * 
	 * @param ds DocumentoService a ser utilizado pelo BuscaService.
	 */
	public BuscaService(DocumentoService ds) {
		this.ds = ds;
		this.br = new BuscaRepository();
	}

	/**
	 * Realiza uma opera��o de busca simples. Toda busca deve retornar um documento
	 * e grau de relev�ncia (de maior para menor).
	 * 
	 * @param buscaSimples Busca a ser realizada.
	 * @return Resultado das buscas.
	 */
	public DocumentoDTO[] busca(BuscaSimples buscaSimples) {
		Map<Documento, Integer> respostaDocumento = buscaSimples.busca(this.ds);
		DocumentoDTO[] documentos = ordena(respostaDocumento);
		this.br.adicionaBusca(buscaSimples, documentos);
		return documentos;
	}

	/*
	 * Toda busca deve:
	 * - ordenar de acordo com o valor de relev�ncia (valor no mapa)
	 * - retornar at� 5 elementos (ou menos)
	 */
	private DocumentoDTO[] ordena(Map<Documento, Integer> respostaDocumento) {
		return respostaDocumento.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.limit(5)
				.map(Entry::getKey)
				.map(DocumentoDTO::new)
				.collect(Collectors.toList())
				.toArray(new DocumentoDTO[] {});
	}

	/**
	 * Recupera o hist�rico de busca a partir do n�mero de busca (onde zero
	 * representa a primeira busca).
	 * 
	 * @param numero N�mero da busca a ser recuperada do hist�rico.
	 * @return Hist�ricoBusca na ordem cadastrada.
	 */
	public HistoricoBusca recuperaHistorico(int numero) {
		return this.br.recuperar(numero);
	}

}
