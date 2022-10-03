package com.matheusgr.lunr.busca;

import java.util.Map;

import com.matheusgr.lunr.documento.DocumentoDTO;

/**
 * Controller para opera��es de busca. A busca representa uma entidade b�sica do
 * sistema mais complexa do que apenas um casamento de padr�es de termos de
 * busca.
 * 
 * Quando a busca envolve alguma l�gica mais complexa, cabe as entidades de
 * busca realizar tais opera��es.
 */
public class BuscaController {

	private BuscaService bs;
	private ValidadorBusca bv;

	/**
	 * Construtor padr�o do BuscaController.
	 * 
	 * � importante manter um �nico controllador de busca por sistema.
	 * 
	 * @param bs BuscaService a ser utilizado pelo controller.
	 */
	public BuscaController(BuscaService bs) {
		this.bs = bs;
		this.bv = new ValidadorBusca();
	}

	/**
	 * Busca documentos de acordo com os termos.
	 * 
	 * Os documentos retornados devem ter pelo menos 1 dos termos, mas n�o todos. Os
	 * documentos s�o ordenados de acordo com os que tiverem mais termos presentes
	 * at� os que tiverem menos termos.
	 * 
	 * @param termos Termos a serem procurado. Pelo menos 1 dos termos deve estar
	 *               presente nos documentos retornados.
	 * @return Array com DocumentoDTO com os resultados da busca, dos documentos que
	 *         mais tem mais termos, at� os que tem menos termos.
	 */
	public DocumentoDTO[] busca(String[] termos) {
		this.bv.valida(termos);
		return this.bs.busca(new BuscaSimples(termos));
	}

	/**
	 * Busca documentos a partir dos metadados existentes.
	 * 
	 * Os documentos retornados precisam ter todos os metadados listados como
	 * par�metro.
	 * 
	 * @param metadados Metadados que devem estar todos presentes nos documentos
	 *                  retornados.
	 * @return Array com DocumentoDTO. N�o h� ordena��o definida.
	 */
	public DocumentoDTO[] busca(Map<String, String> metadados) {
		// TODO
		throw new UnsupportedOperationException("TODO");
	}

	/**
	 * Retorna o hist�rico de buscas do usu�rio. A primeira busca tem n�mero 0, e
	 * assim segue o hist�rico de busca sucessivamente. Na depura��o, cada linha
	 * representa um par�metro de busca e cada coluna o detalhamento desse
	 * par�metro.
	 * 
	 * @param numero N�mero da busca a ser retornado seu hist�rico.
	 * @return Depura��o da busca.
	 */
	public String[][] recuperaHistoricoDepuracao(int numero) {
		this.bv.valida(numero);
		return this.bs.recuperaHistorico(numero).debug();
	}

	/**
	 * Retorna o hist�rico de buscas do usu�rio. A primeira busca tem n�mero 0, e
	 * assim segue o hist�rico de busca sucessivamente.
	 * 
	 * @param numero N�mero da busca a ser retornado seu hist�rico.
	 * @return Ids dos documentos de resultado.
	 */
	public String[] recuperaHistoricoIds(int numero) {
		this.bv.valida(numero);
		return this.bs.recuperaHistorico(numero).ids();
	}
	
}