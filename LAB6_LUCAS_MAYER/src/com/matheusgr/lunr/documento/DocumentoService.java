package com.matheusgr.lunr.documento;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DocumentoService � a base de l�gica de opera��es sobre o documento. Demais
 * classes devem fazer uso desse servi�o para acessar e operar sobre documentos.
 * 
 * Deve existir apenas um �nico objeto do tipo DocumentoService em todo o
 * sistema para garantir unicidade dos documentos e das opera��es realizadas.
 */
public class DocumentoService {

	/*
	 * Reposit�rio. Configurado externamente para que essa classe n�o se
	 * responsabilize por sua inicializa��o.
	 */
	private DocumentoRepository dr;

	/**
	 * Construtor padr�o do documento service.
	 * 
	 * @param dr DocumentRepository a ser usado pelo service.
	 */
	public DocumentoService() {
		this.dr = new DocumentoRepository(); 
	}
	
	/**
	 * Adiciona um documento. O documento j� deve ter um ID. Este ID ser� usado para
	 * registro no sistema. Caso o documento j� exista, o documento ser�
	 * sobrescrito.
	 * 
	 * @param d Documento a ser inserido.
	 */
	public void adicionaDocumento(Documento d) {
		this.dr.adiciona(d);
	}

	/**
	 * Recupera um documento. Caso um documento n�o exista, isso � retornado na
	 * forma de um Optional.
	 * 
	 * @param id ID do documento a ser recuperado.
	 * @return Retorna o documento recuperado do documento.
	 */
	public Optional<Documento> recuperaDocumento(String id) {
		return this.dr.recupera(id);
	}

	/*
	 * GAMBARE SENPAI! SE N�O DER CERTO.... GRITE!
	 */
	private Documento recuperaDocumentoOuFalhe(String id) {
		Optional<Documento> optional = this.dr.recupera(id);
		if (optional.isEmpty()) {
			throw new NoSuchElementException("Documento n�o existe");
		}
		return optional.get();
	}
	

	/**
	 * Contabiliza o total de documentos cadastrados na base de dados.
	 * 
	 * @return O total de documentos presentes. Documentos s�o identificados
	 *         unicamente pelo ID, e n�o por seus textos.
	 */
	public int totalDocumentos() {
		return this.dr.totalDocumentos();
	}

	/**
	 * Concatena dois documentos. Os documentos passam a ter uma nova identidade
	 * gerada no formato: _MERGE + ID1 + | + ID2.
	 * 
	 * O merge � feito a partir do texto extra�do do documento.
	 * 
	 * @param id1 ID do primeiro documento a ser mergeado.
	 * @param id2 ID do segundo documeto a ser mergeado.
	 * @return O ID do novo documento gerado a partir da concatena��o.
	 */
	public String concatena(String id1, String id2) {
		Documento d1 = this.recuperaDocumentoOuFalhe(id2);
		Documento d2 = this.recuperaDocumentoOuFalhe(id2);
		String novoId = "_MERGE" + id1 + "|" + id2;
		String novoTexto = Stream
				.concat(Stream.of(d1.getTexto()), Stream.of(d2.getTexto()))
				.collect(Collectors.joining())
				.toString();
		this.adicionaDocumento(new DocumentoTexto(novoId, novoTexto));
		return novoId;
	}

	/**
	 * Sumariza um documento pegando as 5 palavras mais comuns com mais de 5 letras.
	 * Em caso de empate entre os elementos mais comuns, n�o h� garantia de ordem.
	 * 
	 * @param id Id do documento a ser sumarizado.
	 * @return Lista de sumariza��o do documento com at� 5 palavras.
	 */
	public String[] sumariza(String id) {
		Documento d = this.recuperaDocumentoOuFalhe(id);
		List<String> collected = Stream.of(d.getTexto())
			.filter((x) -> x.length() > 5)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue())
			.limit(5)
			.map(Entry::getKey)
			.collect(Collectors.toList());
		return collected.toArray(new String[] {});
	}

	/**
	 * Realiza uma busca simples por documentos que possuem determinado termo. A
	 * busca implementada pelo DocumentoService n�o deve ser complexa.
	 * 
	 * @param termo Termo a ser buscado
	 * @return Documentos que possuem o termo.
	 */
	public Set<Documento> busca(String termo) {
		return this.dr.busca(termo);
	}

}
