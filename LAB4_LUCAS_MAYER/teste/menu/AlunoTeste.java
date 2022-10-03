package menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTeste {
	
	private Aluno aluno;

	@BeforeEach
	void setUp() throws Exception {
		this.aluno = new Aluno(202, "Lucas Mayer", "Computação");
	}

	@Test
	void testHashCode() {
		Aluno aluno2 = new Aluno(202, "Lucas Mayer", "Computação");
		assertEquals(aluno2.hashCode(), this.aluno.hashCode());
	}

	@Test
	void testAluno() {
		Aluno aluno2 = new Aluno(202, "Lucas Mayer", "Computação");
	}

	@Test
	void testGetGrupos() {
		Menu menu = new Menu();
		menu.cadastraGrupo("listas", 1);
		menu.cadastraGrupo("nomes", 1);
		menu.alocaAluno(202, "listas");
		menu.alocaAluno(202, "nomes");
		this.aluno.getGrupos();
	}

	@Test
	void testAdicionaGrupo() {
		Grupo grupo = new Grupo("listas", 1);
		this.aluno.adicionaGrupo(grupo);
	}

	@Test
	void testEqualsObject() {
		Aluno aluno2 = new Aluno(202, "Lucas Mayer", "Computação");
		assertEquals(aluno2, this.aluno);
	}

	@Test
	void testToString() {
		Aluno aluno2 = new Aluno(202, "Lucas Mayer", "Computação");
		assertEquals(aluno2.toString(), this.aluno.toString());
	}

}
