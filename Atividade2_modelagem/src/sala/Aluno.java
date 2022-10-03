package sala;

public class Aluno {
	
	private String nome;
	private int idade;
	private Responsavel responsavel;
	
	Aluno(String nome, int idade, String nomeResponsavel, int idadeResponsavel, String sexo, String telefoneResponsavel ){
		this.nome = nome;
		this.idade = idade;
		this.responsavel = new Responsavel(nomeResponsavel, idadeResponsavel, sexo, telefoneResponsavel);
	}

}
