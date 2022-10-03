package lab2;

/**
 * Representa��o da rotina de descanso um estudante em horas durante um determinado per�odo de semanas.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */
public class Descanso {
	
	private int horasDeDescanso;
	private int numeroDeSemanas;
	private boolean alunoDescansado = false;
	
	/**
	 * Define a quantidade de horas de descanso que um estudante possu� em determinado per�odo.
	 * 
	 * @param valor a quantidade de horas de descanso do estudante
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDeDescanso = valor;
	}
	
	/**
	 * Define a quantidade de semanas que ser�o consiradas como per�odo de analise.
	 * 
	 * @param valor o n�mero de semanas
	 */
	public void defineNumeroSemanas(int valor) {
		this.numeroDeSemanas = valor;
	} 
	
	/**
	 * Retorna a String que representa a condi��o de descanso do aluno dentro desse per�odo de semanas. Pelo menos 26 horas por semana.
	 * 
	 * @return retorna a condi��o do aluno "cansado" ou "descansado"
	 */
	public String getStatusGeral() {
		this.defineCondicao();
		if(this.alunoDescansado) {
			return "descansado";
		}else {
			return "cansado";
		}
	}
	
	
	private void defineCondicao() {
		if(this.horasDeDescanso != 0 && this.numeroDeSemanas != 0) {
			if(this.horasDeDescanso / this.numeroDeSemanas >= 26) {
				this.alunoDescansado = true;
			}else {
				this.alunoDescansado = false;
			}
		}
	}
}
