import java.util.*;

public class Teste {
	
	
	public static void main(String[] args) {
		ArrayList<Aluno> alunosDoMes = new ArrayList<>();
		
		adicionaAluno(12314, "LUcas", "123123", alunosDoMes);
		adicionaAluno(1444, "Mayer", "2222222", alunosDoMes);
		adicionaAluno(22222222, "Felipe", "133333", alunosDoMes);
		adicionaAluno(12314, "LUcas", "123123", alunosDoMes);
	}
	
	private static void adicionaAluno(int matricula, String nome, String telefone, ArrayList<Aluno> alunos) {
		Aluno aluno = new Aluno(matricula, nome, telefone);
		alunos.add(aluno);
	}
}

