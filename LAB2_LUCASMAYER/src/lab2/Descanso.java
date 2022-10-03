package lab2;

/**
 * Representação da rotina de descanso um estudante em horas durante um determinado período de semanas.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */
public class Descanso {
	
	private int horasDeDescanso;
	private int numeroDeSemanas;
	private boolean alunoDescansado = false;
	
	/**
	 * Define a quantidade de horas de descanso que um estudante possuí em determinado período.
	 * 
	 * @param valor a quantidade de horas de descanso do estudante
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDeDescanso = valor;
	}
	
	/**
	 * Define a quantidade de semanas que serão consiradas como período de analise.
	 * 
	 * @param valor o número de semanas
	 */
	public void defineNumeroSemanas(int valor) {
		this.numeroDeSemanas = valor;
	} 
	
	/**
	 * Retorna a String que representa a condição de descanso do aluno dentro desse período de semanas. Pelo menos 26 horas por semana.
	 * 
	 * @return retorna a condição do aluno "cansado" ou "descansado"
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
