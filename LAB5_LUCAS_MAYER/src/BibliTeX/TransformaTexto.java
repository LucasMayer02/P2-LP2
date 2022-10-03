package BibliTeX;

import java.util.*;

/**
 * Uma classe que representa todas as ações possíveis em relação a 
 * manipulação e transformação de strings
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class TransformaTexto {
	private ArrayList<String> mensagensOriginais = new ArrayList<>();
	private HashMap<Integer, String> historico = new HashMap<>();
	private HashMap<String, AlgoritmoTransformacao> algoritmos = new HashMap<>();
	private int transformacoesRealizadas;
	private ArrayList<String> nomesAlgoritmos = new ArrayList<>();
	private Logger logger;
	boolean loggerAtivado;
	
	public TransformaTexto() {
		this.algoritmos = new HashMap<>();
		this.algoritmos.put("CaMeLcAsEfY", new CamelCasefy());
		this.algoritmos.put("clean", new Clean());
		this.mensagensOriginais = new ArrayList<>();
		this.historico = new HashMap<>();
		this.transformacoesRealizadas = 0;
		this.nomesAlgoritmos = new ArrayList<>();
		this.logger = null;
		this.loggerAtivado = false;
	}
	
	public TransformaTexto(Logger log) {
		this.algoritmos = new HashMap<>();
		this.algoritmos.put("CaMeLcAsEfY", new CamelCasefy());
		this.algoritmos.put("clean", new Clean());
		this.mensagensOriginais = new ArrayList<>();
		this.historico = new HashMap<>();
		this.transformacoesRealizadas = 0;
		this.nomesAlgoritmos = new ArrayList<>();
		this.logger = log;
		this.loggerAtivado = true;
	}
	
	/**
	 * Cadastra uma nova forma de transformação
	 * 
	 * @param nome Nome que sera dado para a chave ligada ao novo algoritmo
	 * @param algoritmo Algoritmo que modifica a String
	 */
	public void cadastraTransformacao(String nome, AlgoritmoTransformacao algoritmo) {
		this.algoritmos.put(nome, algoritmo);
	}
	
	/**
	 * Transforma uma string por meio de um algoritmo escolhido
	 * 
	 * @param nomeAlgoritmo Algoritmo usado na String
	 * @param original String original
	 * @return Retorna a string modificada
	 */
	public String transforma(String nomeAlgoritmo, String original) {
		AlgoritmoTransformacao algoritmo = this.algoritmos.get(nomeAlgoritmo);
		String transformado = algoritmo.transforma(original);
		boolean possui = false;
		for(int i = 0; i < this.mensagensOriginais.size(); i++) {
			if(original.equals(this.mensagensOriginais.get(i))) {
				possui = true;
			}
		}
		if(!possui) {
			this.mensagensOriginais.add(original);
		}
		String mensagemHistorico = original + " -> " + nomeAlgoritmo +  " -> " + transformado;
		this.historico.put(this.transformacoesRealizadas, mensagemHistorico);
		this.transformacoesRealizadas += 1;
		if(this.loggerAtivado) {
			String metodo = "transforma";
			String resultado = logger.invocaLogger(metodo, nomeAlgoritmo);
			return resultado + "\n" + transformado;
		}else {
			return transformado;
		}
	}
	/**
	 * Conta quantas transformações de string foram feitas
	 * 
	 * @return Retorna um inteiro que é a quantidade de transformações
	 */
	public String contaTransformacao(){
		String quantidade = String.valueOf(this.transformacoesRealizadas);
		if(this.loggerAtivado) {
			String metodo = "contaTransformacao";
			String parametro = "";
			String resposta = this.logger.invocaLogger(metodo, parametro);
			return resposta + "\n" + quantidade;
		}
		return quantidade;
	}
	
	/**
	 * Mostra o historico de transformações em um momento especifico
	 * 
	 * @param posicao Posicao que se encontra essa transformação no historico
	 * @return Retorna uma String com a String original, o algoritmo utilizado
	 * e como ficou a String alterada
	 */
	public String historico(int posicao) {
		String mensagem = this.historico.get(posicao);
		if(this.loggerAtivado) {
			String metodo = "historico";
			String parametro = String.valueOf(posicao);
			String resposta = this.logger.invocaLogger(metodo, parametro);
			return resposta + "\n" + mensagem;
		}else {
			return mensagem;
		}
	}
	/**
	 * Lista todas as Strings originais únicas
	 * 
	 * @return Retorna as String originais
	 */
	public String listarOriginais() {
		String lista = "";
		for(int i = 0; i < this.mensagensOriginais.size(); i++) {
			lista += this.mensagensOriginais.get(i) + "\n";
		}
		if(this.loggerAtivado) {
			String metodo = "listarOriginais";
			String parametro = "";
			String resposta = this.logger.invocaLogger(metodo, parametro);
			return resposta + "\n" + lista;
		}else{
			return lista;
		}
	}
	
	/**
	 * Lista os algoritmos existentes
	 * 
	 * @return Retorna os nomes dos Algoritmos
	 */
	public String listarAlgoritmos() {
		String lista = "";
		Set<String> nomes = algoritmos.keySet();
		for(String nome : nomes) {
			if(nome != null) {
				AlgoritmoTransformacao algoritmo = algoritmos.get(nome);
				this.nomesAlgoritmos.add(algoritmo.getNome());
			}
		}
		Collections.sort(nomesAlgoritmos);
		for(int i = 0; i < nomesAlgoritmos.size(); ++i) {
			lista += nomesAlgoritmos.get(i) + "\n";
		}
		if(this.loggerAtivado) {
			String metodo = "listarAlgoritmos";
			String parametro = "";
			String resposta = this.logger.invocaLogger(metodo, parametro);
			return resposta + "\n" + lista;
		}else{
			return lista;
		}
	}
}
