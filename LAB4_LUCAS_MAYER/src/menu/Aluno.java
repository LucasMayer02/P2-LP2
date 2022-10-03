package menu;

import java.util.HashSet;
import java.util.Objects;

/**
 * Representa��o de um Aluno, esse que contem uma matr�cula, nome, 
 * curso, e lista de grupos que participa
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class Aluno {
	private int matricula;
	private String nome;
	private String curso;
	private HashSet<Grupo> grupos = new HashSet<>();
	
	/**
	 * Cria um Aluno
	 * 
	 * @param matricula Inteiro que o identifica
	 * @param nome Nome do Aluno
	 * @param curso Curso do Aluno
	 */
	public Aluno(int matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.grupos = new HashSet<>();
	}
	/**
	 * Pega uma representa��o da lista dos grupos que
	 * o aluno faz parte
	 * 
	 * @return Retorna uma lista clone dos grupos do aluno
	 */
	public HashSet<Grupo> getGrupos() {
		return (HashSet)grupos.clone();
	}
	
	/**
	 * Adiciona um Grupo na lista de Grupos do Aluno
	 * 
	 * @param grupo Grupo que ser� adicionado
	 */
	public void adicionaGrupo(Grupo grupo) {
		grupos.add(grupo);
	}

	/**
	 * M�todo hashCode baseado na matr�cula
	 * 
	 * @return hashCode que representa a matr�cula
	 */
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	
	/**
	 * M�todo equals baseado na matr�cula
	 * 
	 * @return booleano se dois alunos s�o iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return matricula == other.matricula;
	}
	
	/**
	 * M�todo toString que retorna uma String com as informa��es
	 * do aluno
	 * 
	 * @return String que representa o aluno
	 */
	@Override
	public String toString() {
		String descricao = this.matricula + " - "
				+ this.nome + " - " + this.curso;
		return descricao; 
	}
}
