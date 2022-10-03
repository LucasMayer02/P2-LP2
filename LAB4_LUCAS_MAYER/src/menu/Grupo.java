package menu;

import java.util.*;

/**
 * Representa��o de um Grupo, esse que contem um nome, tamanho limite e
 * um set de Alunos
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class Grupo {
	private HashSet<Aluno> alunos = new HashSet<>();
	private String nome;
	private int tamanhoLimite;
	
	/**
	 * Cria um Grupo
	 * 
	 * @param grupo Nome do grupo que o identifica
	 * @param tamanho Inteiro que mostra o tamanho m�ximo que a lista de 
	 * alunos pode alcan�ar
	 */
	public Grupo(String grupo, int tamanho) {
		this.nome = grupo;
		this.tamanhoLimite = tamanho;
		this.alunos = new HashSet<>();
	}
	
	/**
	 * Pega o tamanho limite do grupo
	 * 
	 * @return Retorna um inteiro que representa o tamanho limite que a 
	 * lista de alunos do grupo pode ter
	 */
	public int getTamanhoLimite() {
		return this.tamanhoLimite;
	}
	
	/**
	 * Pega o tamanho atual do grupo
	 * 
	 * @return Retorna um inteiro que representa o tamanho atual da
	 * lista de alunos do grupo
	 */
	public int getTamanhoGrupo() {
		return alunos.size();
	}
	
	/**
	 * Pega o Set de alunos
	 * 
	 * @return Retorna uma copia do set de alunos do grupo
	 */
	public HashSet<Aluno> getAlunos() {
		return (HashSet)alunos.clone();
	}
	
	/**
	 * Adiciona um aluno ao set de alunos do grupo
	 * 
	 * @param aluno Aluno que ser� adicionado no set
	 */
	public void adicionaAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	/**
	 * M�todo hashCode Baseado no nome do Grupo
	 * 
	 * @return Retorna um hashCode que representa o nome do Grupo
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	/**
	 * M�todo equals baseado no nome do Grupo
	 * 
	 * @return Retorna um booleano se dois Grupos s�o iguais ou n�o
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(nome, other.nome);
	}
	
	/**
	 * M�todo toString baseado no nome do Grupo
	 * 
	 * @return Retorna uma String que representa o Grupo
	 */
	@Override
	public String toString() {
		String descricao = this.nome;
		return descricao;
	}
}
