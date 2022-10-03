package lab2;

/**
 * Representa��o dos registros financeiros de um aluno, com seus ganhos iniciais, ganhos dispon�veis,
 * despesas e a quantidade total de ganhos.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */
public class RegistroFinancas {
	
	private int ganhosIniciais;
	private int totalDeGanhos;
	private int[] fontesDeGanhos = new int[totalDeGanhos];
	private int despesas;
	private int quantidadeGanhos;
	
	/**
	 * Constr�i um registro financeiro a partir dos ganhos iniciais e o total de ganhos dispon�veis.
	 * 
	 * @param ganhosIniciais quantidade dinheiro inicial
	 * @param totalDeGanhos quantidade de diferentes ganhos que podem ser registrados ao ser
	 * criado o array das fontes de ganhos
	 */
	RegistroFinancas(int ganhosIniciais, int totalDeGanhos){
		this.ganhosIniciais = ganhosIniciais;
		this.totalDeGanhos = totalDeGanhos;
		this.criacaoDeArray();
	}
	
	/**
	 * Registra ganhos em uma determinada posi��o no array de fontes de ganhos.
	 * 
	 * @param valorCentavos quantidade de ganhos adicionado em determinada posi��o
	 * @param posicaoGanho posi��o em que os ganhos ser�o registrados
	 */
	public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
		this.fontesDeGanhos[posicaoGanho-1] = valorCentavos;
	}
	
	/**
	 * Adiciona um valor a quantidade total de despesas a serem pagas.
	 * 
	 * @param valorCentavos valor da nova despesa
	 */
	public void pagaDespesa(int valorCentavos) {
		this.despesas += valorCentavos;
	}
	
	/**
	 * Retorna o array com cada fonte de ganho nova dispon�vel a cada linha.
	 * 
	 * @return a representa��o dos novos ganhos
	 */
	public String exibeGanhos( ) {
		String exibicao = "";
		for(int i= 0; i < this.fontesDeGanhos.length; i++) {
			exibicao += i+1 + " - " + this.fontesDeGanhos[i];
			if(i+1 != this.fontesDeGanhos.length) {
				exibicao += "\n";
			}
		}
		return exibicao;
	}
	
	/**
	 * Retorna uma String que ap�s calcular valores totais de ganhos, despesas e dispon�veis
	 * representa a comunica��o dos valores no seguinte formato :
	 * "Total recebidos: " , "Despesas totais: " "Total dispon�vel: ".
	 * 
	 * @return a represeta��o em String da comunica��o do registro
	 */
	public String toString( ) {
		this.calculaTotalRecebido();
		int totalDisponivel = this.quantidadeGanhos - this.despesas;
		String comunicacao = "Total recebidos: " + this.quantidadeGanhos + ", ";
		comunicacao += "Despesas totais: " + this.despesas + ", ";
		comunicacao += "Total dispon�vel: " + totalDisponivel;
		return comunicacao;
	}
	
	
	private void criacaoDeArray() {
		this.fontesDeGanhos = new int[totalDeGanhos];
	}
	
	private void calculaTotalRecebido() {
		this.quantidadeGanhos = 0;
		for(int i = 0; i < this.fontesDeGanhos.length; i++) {
			this.quantidadeGanhos += this.fontesDeGanhos[i];
		}
		this.quantidadeGanhos += this.ganhosIniciais;
	}
}
