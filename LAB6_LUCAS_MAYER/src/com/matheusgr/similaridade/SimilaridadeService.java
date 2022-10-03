package com.matheusgr.similaridade;

import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da l�gica de neg�cio relativa a similaridade.
 */
public class SimilaridadeService {

	private DocumentoService documentoService;

	/**
	 * Inicializa��o da l�gica de servi�o.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o c�lculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interse��o entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a uni�o entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade � o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhan�a entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		this.documentoService.recuperaDocumento(docId1);
		// PEGA DOCUMENTO 1
		// PEGA DOCUMENTO 2
		// COLOCA TERMOS DO DOCUMENTO 1 EM UM CONJUNTO
		// COLOCA TERMOS DO DOCUMENTO 2 EM OUTRO CONJUNTO
		// A SIMILARIDADE � DETERMINADA PELO...
		// --> (TAMANHO DA INTERSE��O) / (TAMANHO DA UNI�O DOS CONJUNTOS)
		throw new UnsupportedOperationException();
	}

}
