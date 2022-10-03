package menu;

import java.util.HashSet;
import java.util.Objects;

/**
 * Representação de um Aluno, esse que contem uma matrícula, nome, 
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
	 * Pega uma representação da lista dos grupos que
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
	 * @param grupo Grupo que será adicionado
	 */
	public void adicionaGrupo(Grupo grupo) {
		grupos.add(grupo);
	}

	/**
	 * Método hashCode baseado na matrícula
	 * 
	 * @return hashCode que representa a matrícula
	 */
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	
	/**
	 * Método equals baseado na matrícula
	 * 
	 * @return booleano se dois alunos são iguais
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
	 * Método toString que retorna uma String com as informações
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
