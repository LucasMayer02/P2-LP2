package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		if(contatos[posicao-1] == null) {
			return null;
		}else {
			return contatos[posicao-1].exibeContato();
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return Retorna Uma String que representa o sucesso do Cadastro ou o erro nas informações.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		boolean contatosIguais = false;
		if(posicao < 1 || posicao > 100) {
			return "\nPOSIÇÃO INVÁLIDA";
		}else {
			if(nome.equals("")) {
				return "\nCONTATO INVALIDO";
			}else {
				String contato = nome + " " + sobrenome;
				Contato[] contatos = this.getContatos();
				for (int i = 0; i < contatos.length; i++) {
					if (contatos[i] != null) {
						if(contatos[i].toString().equals(contato)) {
							contatosIguais = true;
							break;
						}
					}
				}if(contatosIguais) {
					return "\nCONTATO JA CADASTRADO";
				}else {
					if(telefone.equals("")) {
						return "\nCONTATO INVALIDO";
					}else {
						this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
						return "\nCADASTRO REALIZADO";
					}
				}
				
			}
		}
	}
	/**
	 * Retorna a lista de favoritos
	 * 
	 * @return Retorna um clone da lista de favoritos
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}
	/**
	 * Pega um favorito especifico de dentro da lista 
	 * e invoca o exibeContato()
	 * 
	 * @param posicao Posicao que o favorito se encontra na lista
	 * 
	 * @return Nulo ou Uma String vida do exibeContato
	 */
	public String getFavorito(int posicao) {
		if(favoritos[posicao-1] == null) {
			return null;
		}else {
			return favoritos[posicao-1].exibeContato();
		}
	}
	
	/**
	 * Adiciona um Contato a lista dos Favoritos
	 * sobescreve um Contato se outro ja estiver
	 * 
	 * @param contato Contato que será adicionado.
	 * @param posicao2 Posição que o Contato ficara na lista de favoritos
	 * @return Uma String confirmando ou não o processo
	 */
	public String adicionaFavorito(Contato contato, int posicao2) {
		boolean jaPossui = false;
		for(int i = 0; i < this.favoritos.length; i++) {
			if(this.favoritos[i] != null) {
				if(this.favoritos[i].toString().equals(contato)) {
					jaPossui = true;
				}
			}
		}
		if(jaPossui) {
			return "CONTATO JÁ É FAVORITO";
		}else {
			this.favoritos[posicao2-1] = contato;
			return "CONTATO FAVORITADO NA POSIÇÂO " + posicao2 + "!";
		}
	}
	
	/**
	 * Define quais contatos receberão a tag
	 * 
	 * 
	 * @param posicao Posição do Contato que recebera a tag
	 * @param tag String que define a tag
	 * @param posicaoTag Posicao que a tag será colocada
	 */
	public void defineTag(int posicao, String tag, int posicaoTag) {
		this.contatos[posicao-1].adicionaTag(tag, posicaoTag);
		
	}
	/**
	 * Exibe uma String que representa um contato da lista
	 * 
	 * @param posicao Posição da lista em que o Contato se encontra 
	 * @return Retorna a String que representa o contato.
	 */
	public String exibeContato(int posicao) {
		String contato = this.getContato(posicao);
		if(contato == null) {
			return "\nPOSIÇÃO INVÁLIDA!";
		}else {
			boolean ehFavorito = false;
			Contato[] favoritos = this.getFavoritos();
			for(int i = 1; i <= favoritos.length; i++) {
				if(contato.equals(this.getFavorito(i))) {
					ehFavorito = true;
				}
			}
			if(ehFavorito) {
				return "Dados do contato:\n\nS2 " + contato;
			}else {
				return"Dados do contato:\n\n" + contato;
			}
		}

	}

}
