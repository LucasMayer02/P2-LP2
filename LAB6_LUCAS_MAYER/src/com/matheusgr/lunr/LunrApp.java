package com.matheusgr.lunr;

import com.matheusgr.lunr.busca.BuscaController;
import com.matheusgr.lunr.busca.BuscaService;
import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.lunr.documento.DocumentoService;
import com.matheusgr.similaridade.SimilaridadeController;
import com.matheusgr.similaridade.SimilaridadeService;

/**
 * O Lunr � um sistema de cadastro e busca de documentos, bem como de realiza��o
 * de opera��es de similaridade entre os documentos cadastrados.
 * 
 * O LunrApp por sua vez � respons�vel por centralizar todas as inicializa��es
 * de todos os objetos de controller e servi�os existentes.
 * 
 * O Controller � respons�vel por ser uma interface com o usu�rio, e os servi�os
 * s�o respons�veis pela l�gica de neg�cio.
 * 
 * Por centralizar a inicializa��o dos objetos principais de l�gica do sistema,
 * � importante que o LunrFacade seja a �nica fote de acesso as demais
 * opera��es.
 */
public class LunrApp {

	private DocumentoController documentoController;
	private BuscaController buscaController;
	private SimilaridadeController similaridadeController;

	/**
	 * Inicializador do LunrApp.
	 * 
	 * Todas as entidades de intera��o no sistema devem ser obtidas a partir
	 * do LunrApp. Isto garante a correta inicializa��o das entidades.
	 */
	public LunrApp() {
		var documentoService = new DocumentoService();
		var buscaService = new BuscaService(documentoService);
		var similaridadeService = new SimilaridadeService(documentoService);
		
		this.documentoController = new DocumentoController(documentoService);
		this.buscaController = new BuscaController(buscaService);
		this.similaridadeController = new SimilaridadeController(similaridadeService);
	}
	
	/**
	 * Obtem o controller de documentos para intera��o com os usu�rios.
	 * 
	 * @return DocumentoController para receber requisi��es do usu�rio sobre os
	 *         documentos.
	 */
	public DocumentoController getDocumentoController() {
		return this.documentoController;
	}
	
	/**
	 * Obtem o controller de buscas para intera��o com os usu�rios.
	 * 
	 * @return BuscaController para receber requisi��es do usu�rio sobre as
	 *         buscas.
	 */
	public BuscaController getBuscaController() {
		return this.buscaController;
	}
	
	/**
	 * Obtem o controller de similaridade para intera��o com os usu�rios.
	 * 
	 * @return SimilaridadeController para receber requisi��es do usu�rio sobre as
	 *         opera��es de similaridades entre documentos.
	 */
	public SimilaridadeController getSimilaridadeController() {
		return this.similaridadeController;
	}
	
}