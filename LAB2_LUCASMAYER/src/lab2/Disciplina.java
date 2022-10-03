package lab2;

/**
 * Representa��o de uma disciplina contendo seu nome e o desempenho do aluno
 * contendo o n�mero de horas estudados para a disciplina, suas notas e m�dia.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */
public class Disciplina {
	
	private String nomeDisciplina;
	private int numeroHoras;
	private double[] notas = new double[4];
	private double somaNotas;
	private double media;
	
	/**
	 * Constr�i uma disciplina por meio do nome da disciplina.
	 * 
	 * @param nomeDisciplina o nome da disciplina
	 */
	Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Adiciona uma quantidade de tempo ao total estudado pelo aluno na disciplina.
	 * 
	 * @param horas n�mero de horas estudadas
	 */
	public void cadastraHoras(int horas) {
		this.numeroHoras += horas;
	}
	
	/**
	 * Cadrasta uma nota do aluno em uma das 4 posi��es de notas dispon�veis,
	 * enquanto n�o � cadastrada nota em determinada posi��o essa se mantem 0.
	 * 
	 * @param nota posi��o a ser cadastrada a nota
	 * @param valorNota valor da nota cadastrada
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
		this.calculaMedia();
	}
	
	/**
	 * Retorna se o aluno foi ou n�o aprovado.
	 * 
	 * @return boolean para o fato do aluno ter ou n�o sido aprovado
	 */
	public boolean aprovado( ) {
		if(this.media >= 7.0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Retorna uma String com a representa��o da disciplina no seguinte formato :
	 * "nome da disciplina" "horas estudadas" "m�dia" ["lista com as 4 notas"].
	 * 
	 * @return a representa��o em String da disciplina
	 */
	public String toString() {
		String representacaoDisciplina = "";
		representacaoDisciplina += this.nomeDisciplina + " ";
		representacaoDisciplina += this.numeroHoras + " ";
		representacaoDisciplina += this.media + " ";
		representacaoDisciplina += "[" + this.notas[0] + ", " + this.notas[1] 
				+ ", " + this.notas[2] + ", " + this.notas[3] + "]";
		return representacaoDisciplina;
	}
	
	
	private void calculaMedia() {
		this.somaNotas = 0;
		for(int i = 0; i < notas.length; i++) {
			this.somaNotas += this.notas[i];
		}
		this.media = this.somaNotas / 4;
	}
}
