package agenda;
/**
 * Classe que representa um Contato com as informações de uma Pessoa
 * desde nome, sobrenome, telefone e tags.
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private String descricao;
	private String formatacao;
	private String[] tags;
	
	/**
	 * Construtor de um Contato
	 * 
	 * @param nome Nome da Pessoa
	 * @param sobrenome Sobrenome da Pessoa
	 * @param telefone Telefone da Pessoa
	 */
	Contato(String nome, String sobrenome, String telefone){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tags = new String[5];
	}
	/**
	 * Define a String que será a descrição do Contato
	 * 
	 * @return Retorna a String que descreve o Contato.
	 */
	public String exibeContato(){
		descricao = "";
		descricao += this.nome + " " + this.sobrenome + "\n" + 
		this.telefone + "\n";
		for(int i = 0; i < this.tags.length; i++) {
			if(this.tags[i] == null) {
				continue;
			}else {
				descricao += tags[i] + " ";
			}
		}
		return descricao;
	}
	
	/**
	 * Adiciona uma tag em uma lista de tags,
	 * caso seja adicionada em uma posição que já possui uma tag
	 * sobrescreve a antiga
	 * 
	 * @param tag String que define a tags
	 * @param posicaoTag Posição da tag na lista de tags
	 */
	public void adicionaTag(String tag, int posicaoTag) {
		this.tags[posicaoTag] = tag;
	}
	
	
	public String toString() {
		this.formatacao = this.nome + " " + this.sobrenome;
		return this.formatacao;
		
	}
}
