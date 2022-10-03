package com.matheusgr.lunr.documento;

import java.util.Map;

/**
 * Documento representa um conjunto textual que ser� indexado pelo Lunr.
 */
public interface Documento {

	/**
	 * Retorna a quantidade de texto �til, sendo definido como a quantidade de
	 * caracteres �teis (sem caracteres estranhos e sem espa�os) sobre o total de
	 * caracteres original (incluindo espa�os).
	 * 
	 * @return Percentual de texto �til (entre 0 e 1, inclusives).
	 */
	double metricaTextoUtil();

	/**
	 * Retorna a identifica��o do documento. A documenta��o � definida pelo pr�prio
	 * documento e � uma String sem formata��o espec�fica. Todo documento gerado
	 * pelo Lunr come�a com o s�mbolo "_". O identificador n�o pode ser vazio ou
	 * nulo.
	 * 
	 * @return Identifica��o do documento.
	 * @throws NullPointerException Caso o ID seja nulo.
	 */
	String getId();

	/**
	 * Retorna os termos do texto em formato de String. N�o podem existir termos
	 * vazios (s� de espa�os, tabula��es ou string vazia).
	 * 
	 * @return Array de termos extra�dos do documento.
	 */
	String[] getTexto();

	/**
	 * Retorna metadados referente ao documento. Detalhes como seu tipo, autor, ou
	 * caracter�sticas pr�prias do documento.
	 * 
	 * Idealmente, todo metadado ter� como caracter�sticas:
	 * 
	 * LINHAS, TAMANHO (n�mero de caracteres), METADATADATE (hora atual do sistema
	 * na cria��o dos metadados, em ms), TIPO.
	 * 
	 * @return Mapa com os metadados descrito em forma textual.
	 */
	Map<String, String> getMetadados();

}
