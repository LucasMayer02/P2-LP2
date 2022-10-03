package com.matheusgr.lunr.busca;

/**
 * Armazena o hist�rico de uma busca realizada. O hist�rico n�o deve ter custo
 * computacional e deve ser gen�rico para diferentes tipos de busca.
 */
public class HistoricoBusca {

	private BuscaSimples busca;
	private String[] documentosIds;

	/**
	 * Constru��o do hist�rico a partir dos par�metros de busca (definido pelo
	 * objeto de busca) e resultado da consulta.
	 * 
	 * @param busca      Objeto de busca realizado.
	 * @param documentos Resultado da pesquisa.
	 */
	public HistoricoBusca(BuscaSimples busca, String[] documentosIds) {
		this.busca = busca;
		this.documentosIds = documentosIds;
	}

	/**
	 * Depura uma busca onde cada linha representa um par�metro de busca e cada
	 * coluna representa esse par�metro em detalhes.
	 * 
	 * @return Depura��o da busca. Cada linha representa um par�metro de busca e
	 *         cada coluna um detalhamento desse par�metro (ex.: NOME_DO_PARAMETRO e
	 *         VALOR).
	 */
	public String[][] debug() {
		return this.busca.descreveConsulta();
	}

	/**
	 * Retorna os IDs dos documentos retornados da busca.
	 * 
	 * @return Array de string com IDs dos documentos retornados.
	 */
	public String[] ids() {
		return documentosIds;
	}

}