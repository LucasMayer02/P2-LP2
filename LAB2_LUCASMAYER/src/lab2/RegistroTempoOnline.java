package lab2;

/**
 * Representa um sistema de registro de informa��es das disciplinas, 
 * o tempo online necess�rio para completar cada uma e quanto tempo cada aluno ja dedicou para a disciplina.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */
public class RegistroTempoOnline {
	
	private String nomeDisciplina;
	private int tempoOnlineEsperado;
	private int tempoOnlineAluno;
	
	/**
	 * Constr�i um resitro de disciplina a partir do nome dela e o tempo online esperado para completar. 
	 * 
	 * @param nomeDisciplina nome da disciplina
	 * @param tempoOnlineEsperado quantidade de horas online para completar a disciplina
	 */
	RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Constr�i um registro de disciplina a partir do nome dela e possui uma quantidade de horas online padr�o de 120.
	 * 
	 * @param nomeDisciplina nome da disciplina
	 */
	RegistroTempoOnline(String nomeDisciplina){
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
	}
	
	/**
	 * Adiciona tempo ao total de horas estudas pelo aluno em determinada disciplina.
	 * 
	 * @param tempo n�mero de horas adicionada ao tempo total
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnlineAluno += tempo;
	}
	
	/**
	 * Retorna se o aluno atingiu ou n�o a quantidade necess�ria de horas online para a disciplina
	 * 
	 * @return um boolean de true or false para o fato do aluno ter atingido a quantidade de horas necess�rias
	 */
	public boolean atingiuMetaTempoOnline() {
		if(this.tempoOnlineAluno >= this.tempoOnlineEsperado) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Retorna uma String que representa a descri��o da disciplina com o seguinte formato :
	 * "nome da disciplina" "horas estudadas pelo aluno/horas necess�rias para a disciplina".
	 * 
	 * @return uma String representando a descri��o da disciplina
	 */
	public String toString() {
		String descricaoDisciplina = "";
		descricaoDisciplina += this.nomeDisciplina + " ";
		descricaoDisciplina += this.tempoOnlineAluno + "/" + this.tempoOnlineEsperado;
		return descricaoDisciplina;
	}
}
