package lab2;

/**
 * Representação de uma disciplina contendo seu nome e o desempenho do aluno
 * contendo o número de horas estudados para a disciplina, suas notas e média.
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
	 * Constrói uma disciplina por meio do nome da disciplina.
	 * 
	 * @param nomeDisciplina o nome da disciplina
	 */
	Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Adiciona uma quantidade de tempo ao total estudado pelo aluno na disciplina.
	 * 
	 * @param horas número de horas estudadas
	 */
	public void cadastraHoras(int horas) {
		this.numeroHoras += horas;
	}
	
	/**
	 * Cadrasta uma nota do aluno em uma das 4 posições de notas disponíveis,
	 * enquanto não é cadastrada nota em determinada posição essa se mantem 0.
	 * 
	 * @param nota posição a ser cadastrada a nota
	 * @param valorNota valor da nota cadastrada
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
		this.calculaMedia();
	}
	
	/**
	 * Retorna se o aluno foi ou não aprovado.
	 * 
	 * @return boolean para o fato do aluno ter ou não sido aprovado
	 */
	public boolean aprovado( ) {
		if(this.media >= 7.0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Retorna uma String com a representação da disciplina no seguinte formato :
	 * "nome da disciplina" "horas estudadas" "média" ["lista com as 4 notas"].
	 * 
	 * @return a representação em String da disciplina
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
