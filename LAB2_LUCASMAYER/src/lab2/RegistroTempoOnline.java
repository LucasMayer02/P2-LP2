package lab2;

/**
 * Representa um sistema de registro de informações das disciplinas, 
 * o tempo online necessário para completar cada uma e quanto tempo cada aluno ja dedicou para a disciplina.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */
public class RegistroTempoOnline {
	
	private String nomeDisciplina;
	private int tempoOnlineEsperado;
	private int tempoOnlineAluno;
	
	/**
	 * Constrói um resitro de disciplina a partir do nome dela e o tempo online esperado para completar. 
	 * 
	 * @param nomeDisciplina nome da disciplina
	 * @param tempoOnlineEsperado quantidade de horas online para completar a disciplina
	 */
	RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Constrói um registro de disciplina a partir do nome dela e possui uma quantidade de horas online padrão de 120.
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
	 * @param tempo número de horas adicionada ao tempo total
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnlineAluno += tempo;
	}
	
	/**
	 * Retorna se o aluno atingiu ou não a quantidade necessária de horas online para a disciplina
	 * 
	 * @return um boolean de true or false para o fato do aluno ter atingido a quantidade de horas necessárias
	 */
	public boolean atingiuMetaTempoOnline() {
		if(this.tempoOnlineAluno >= this.tempoOnlineEsperado) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Retorna uma String que representa a descrição da disciplina com o seguinte formato :
	 * "nome da disciplina" "horas estudadas pelo aluno/horas necessárias para a disciplina".
	 * 
	 * @return uma String representando a descrição da disciplina
	 */
	public String toString() {
		String descricaoDisciplina = "";
		descricaoDisciplina += this.nomeDisciplina + " ";
		descricaoDisciplina += this.tempoOnlineAluno + "/" + this.tempoOnlineEsperado;
		return descricaoDisciplina;
	}
}
