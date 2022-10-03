import java.util.Objects;

public class Aluno {
	
	private int matricula;
	private String nome;
	private String telefone;

	public Aluno(int matricula, String nome, String telefone) {
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return matricula == other.matricula && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
}
