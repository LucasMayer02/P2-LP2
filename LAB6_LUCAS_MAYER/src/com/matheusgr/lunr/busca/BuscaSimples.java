package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaSimples realiza uma opera��o de busca a partir de termos.
 * 
 * Dado os termos, deve se buscar por tais documentos e orden�-los de acordo com
 * a quantidade de termos que s�o atendidos pela busca.
 * 
 * Quanto mais termos da busca est�o presentes, mais relev�ncia tem o documento.
 * 
 * N�o importa a quantidade de vezes que um termo aparece no documento, apenas
 * se o documento tem ou n�o o termo pelo menos uma vez.
 * 
 * Os documentos que n�o tem nenhum dos termos pesquisados, n�o devem ser
 * retornados.
 */
class BuscaSimples {

	private String[] termos;

	/**
	 * Construtor padr�o com os termos a serem encontrados.
	 * 
	 * Os termos n�o vazios s�o ignorados. Pelo menos 1 termo deve ser n�o vazio.
	 * 
	 * @param termos Termos a serem pesquisados.
	 */
	public BuscaSimples(String[] termos) {
		(new ValidadorBusca()).valida(termos);
		this.termos = termos;
	}

	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * O DocumentoService realiza apenas opera��es simples de busca, mas sem
	 * ordena��o ou tratamento da l�gica de relev�ncia.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relev�ncia de cada
	 *         opera��o.
	 */
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (String termo : this.termos) {
			if (termo.isBlank()) {
				continue;
			}
			for (Documento d : ds.busca(termo)) {
				respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
			}
		}
		return respostaDocumento;
	}

	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descri��o da busca, onde cada linha representa um par�metro de busca
	 *         e as colunas representam um detelhamento de cada par�metro.
	 */
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.termos.length][];
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = new String[] {"TERMO " + (i + 1), this.termos[i]};
		}
		return resultado;
	}
	
}

