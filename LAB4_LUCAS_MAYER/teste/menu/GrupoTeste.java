package menu;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTeste {
	
	private Grupo grupo;

	@BeforeEach
	void setUp() throws Exception {
		this.grupo = new Grupo("Listas", 10);
	}

	@Test
	void testHashCode() {
		Grupo grupo2 = new Grupo("Listas", 10);
		assertEquals(grupo2.hashCode(), this.grupo.hashCode());
	}

	@Test
	void testGrupo() {
		Grupo grupo2 = new Grupo("Listas", 10);
	}

	@Test
	void testGetTamanhoLimite() {
		int resposta = grupo.getTamanhoLimite();
		assertEquals(10, resposta);
	}

	@Test
	void testGetTamanhoGrupo() {
		Aluno aluno = new Aluno(202, "lucas", "Computação");
		grupo.adicionaAluno(aluno);
		int resposta = grupo.getTamanhoGrupo();
		assertEquals(1, resposta);
	}

	@Test
	void testGetAlunos() {
		Aluno aluno = new Aluno(202, "lucas", "Computação");
		grupo.adicionaAluno(aluno);
		HashSet<Aluno> alunos = grupo.getAlunos();
	}

	@Test
	void testAdicionaAluno() {
		Aluno aluno = new Aluno(202, "lucas", "Computação");
		grupo.adicionaAluno(aluno);
	}

	@Test
	void testEqualsObject() {
		Grupo grupo2 = new Grupo("Listas", 10);
		assertEquals(grupo2, this.grupo);
	}

	@Test
	void testToString() {
		Grupo grupo2 = new Grupo("Listas", 10);
		assertEquals(grupo2.toString(), this.grupo.toString());
	}

}
