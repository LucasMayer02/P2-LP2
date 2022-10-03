package com.matheusgr.lunr.documento;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * O DocumentoController � respons�vel por receber requisi��es do usu�rio e do
 * sistema e converter em opera��es l�gicas (DocumentoService).
 * 
 * A responsabilidade de valida��o das entradas � tamb�m operacionalizada aqui.
 */
public class DocumentoController {

	private DocumentoService ds;
	private ValidadorDocumentos validador;

	/**
	 * Construtor padr�o de DocumentoController. Manter um controller por sistema.
	 * 
	 * @param ds DocumentService a ser utilizado pelo controller.
	 */
	public DocumentoController(DocumentoService ds) {
		this.ds = ds;
		this.validador = new ValidadorDocumentos();
	}

	/**
	 * Adiciona um documento texto, validando o ID e conte�do para objetos n�o nulos
	 * e vazios.
	 * 
	 * @param id  ID do documento a ser adicionado.
	 * @param txt Texto do documento a ser adicionado.
	 */
	public void adicionaDocumentoTxt(String id, String txt) {
		this.validador.validacao(id, txt);
		this.ds.adicionaDocumento(new DocumentoTexto(id, txt));
	}

	/**
	 * Adiciona um documento HTML, validando o ID e o conte�do para objetos n�o
	 * nulos e vazios.
	 * 
	 * O HTML n�o define um padr�o gramatical correto para sua leitura. Assim, a
	 * extra��o de texto do HTML pode n�o operar corretamente.
	 * 
	 * @param id   ID do documento a ser inserido.
	 * @param html HTML do documento a ser adicionado.
	 */
	public void adicionaDocumentoHtml(String id, String html) {
		this.validador.validacao(id, html);
		this.ds.adicionaDocumento(new DocumentoHtml(id, html));		
	}

	/**
	 * Adiciona um documento java, validando o ID e o conte�do para objetos n�o
	 * nulos e vazios.
	 * 
	 * N�o se pretende aqui implementar um analisador l�xico de java para realizar a
	 * extra��o, mas sim identificar as principais palavras utilizadas no texto,
	 * eliminando palavras-chave.
	 * 
	 * @param id   ID do documento a ser inserido
	 * @param java C�digo java do documento a ser adicionado.
	 */
	public void adicionaDocumentoJava(String id, String java) {
		this.validador.validacao(id, java);
		this.ds.adicionaDocumento(new DocumentoJava(id, java));		
	}

	/**
	 * Recupera um documento retornando um Optional<Documento> vazio caso o
	 * documento n�o seja encontrado.
	 * 
	 * @param id ID do documento a ser recuperado.
	 * @return Optional com o documento encontrado (ou vazio caso contr�rio).
	 */
	public Optional<DocumentoDTO> recuperarDocumento(String id) {
		this.validador.validacao(id);
		Optional<Documento> dOpt = this.ds.recuperaDocumento(id);
		if (dOpt.isEmpty()) {
			return Optional.empty();
		}
		Documento d = dOpt.get();
		return Optional.of(new DocumentoDTO(d));
	}

	/**
	 * Retorna o total de documentos cadastrados no sistema. Os documentos s�o
	 * identificado unicamente a partir dos seus IDs.
	 * 
	 * @return Retorna o total de documentos no sistema.
	 */
	public int totalDocumentos() {
		return this.ds.totalDocumentos();
	}

	/**
	 * Retorna o valor de m�trica �til de um documento. A m�trica �til � calculada
	 * como propor��o do texto �til (extra�do) em rela��o ao texto original. Por
	 * isso � um valor que vai de 0 a 1 (inclusivos).
	 * 
	 * @param id ID do documento a ser verificado.
	 * @return O valor de m�trica de texto �til recuperada.
	 */
	public double recuperaMetricaTextoUtil(String id) {
		this.validador.validacao(id);
		Optional<Documento> recuperaDocumento = this.ds.recuperaDocumento(id);
		if (recuperaDocumento.isEmpty()) {
			throw new NoSuchElementException("Documento inexistente");
		}
		return recuperaDocumento.get().metricaTextoUtil();
	}

	/**
	 * Concatena dois documentos a partir do texto �til de ambos. Os documentos
	 * originais n�o s�o alterados. A chave do documento � identificada por _MERGE +
	 * ID1 + | + ID2.
	 * 
	 * @param id1 ID do primeiro documento a ser concatenado.
	 * @param id2 ID do segundo documento a ser concatenado.
	 * @return O ID do documento concatenado que foi cadastrado no sistema.
	 */
	public String concatenaDocumentos(String id1, String id2) {
		this.validador.validacao(id1);
		this.validador.validacao(id2);
		return this.ds.concatena(id1, id2);
	}

	/**
	 * Rertona um array de palavras �teis mais utilizadas no documento que tenha
	 * mais de 5 letras.
	 * 
	 * @param id ID do documento a ser sumarizado.
	 * @return Sumariza��o do documento em palavras mais utilizadas.
	 */
	public String[] sumariza(String id) {
		this.validador.validacao(id);
		return this.ds.sumariza(id);
	}

}
