package com.matheusgr.similaridade;

/**
 * Controller para opera��es de similaridade.
 */
public class SimilaridadeController {

	private SimilaridadeService similaridadeService;

	/**
	 * Construtor padr�o, inicializa com o service a ser usado pelo controller.
	 * 
	 * @param similaridadeService SimilaridadeService a ser utilizado.
	 */
	public SimilaridadeController(SimilaridadeService similaridadeService) {
		this.similaridadeService = similaridadeService;
	}

	/**
	 * Opera��o de similaridade entre dois documentos. Para gera��o da similaridade
	 * ser�o considerados os termos de cada um dos documentos realizando um c�lculo
	 * entre a quantiadde de termos em comum. A similaridade � um valor entre 0 e 1
	 * representando o percentual de semelhan�a.
	 * 
	 * @param docId1 Primeiro documento como base.
	 * @param docId2 Segundo documento como base.
	 * @return Valor entre 0 e 1 (inclusives) representando a similaridade entre os
	 *         documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		return similaridadeService.similaridade(docId1, docId2);
	}

}
