package menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuTeste {
	
	private Menu menu;

	@BeforeEach
	void setUp() throws Exception {
		this.menu = new Menu();
		menu.cadastraAluno(202, "Lucas Mayer", "Computa��o");
		menu.cadastraGrupo("Listas", 1);
		
	}

	@Test
	void testCadastraAluno() {
		String resposta = menu.cadastraAluno(203, "Lucas Mayer", "Computa��o");
		assertEquals("CADASTRO REALIZADO!", resposta);
	}
	
	@Test
	void testCadastraAlunoJaExistente() {
		String resposta = menu.cadastraAluno(202, "Leonardo Almeida", "Medicina");
		assertEquals("MATR�CULA J� CADASTRADA!", resposta);
	}

	@Test
	void testExibeAluno() {
		menu.cadastraAluno(202, "Lucas Mayer", "Computa��o");
		menu.exibeAluno(202);
	}
	
	@Test
	void testExibeAlunoInexistente() {
		menu.cadastraAluno(202, "Lucas Mayer", "Computa��o");
		String resposta = menu.exibeAluno(203);
		assertEquals("Aluno n�o cadastrado.", resposta);
	}

	@Test
	void testCadastraGrupo() {
		String resposta = menu.cadastraGrupo("Nomes", 10);
		assertEquals("CADASTRO REALIZADO!", resposta);
	}
	
	@Test
	void testCadastraGrupoSemRestricao() {
		String resposta = menu.cadastraGrupo("Nomes", Integer.MAX_VALUE);
		assertEquals("CADASTRO REALIZADO!", resposta);
	}
	
	@Test
	void testCadastraGrupoJaExistente() {
		String resposta = menu.cadastraGrupo("LISTAS", 20);
		assertEquals("GRUPO J� CADASTRADO!", resposta);
	}
	
	@Test
	void testCadastraGrupoJaExistente2() {
		String resposta = menu.cadastraGrupo("listas", 20);
		assertEquals("GRUPO J� CADASTRADO!", resposta);
	}
	
	@Test
	void testAlocaAluno() {
		String resposta = menu.alocaAluno(202, "Listas");
		assertEquals("ALUNO ALOCADO", resposta);
	}
	
	@Test
	void testAlocaAlunoInexistente() {
		String resposta = menu.alocaAluno(203, "Listas");
		assertEquals("Aluno n�o cadastrado.", resposta);
	}
	
	@Test
	void testAlocaAlunoEmGrupoInexistente() {
		String resposta = menu.alocaAluno(202, "Nomes");
		assertEquals("Grupo n�o cadastrado.", resposta);
	}
	
	@Test
	void testAlocaAlunoEmGrupoJaPresente() {
		menu.alocaAluno(202, "Listas");
		String resposta = menu.alocaAluno(202, "Listas");
		assertEquals("ALUNO ALOCADO", resposta);
	}
	
	@Test
	void testAlocaAlunoEmGrupoCheio() {
		menu.alocaAluno(202, "Listas");
		menu.cadastraAluno(203, "Qualquer", "Qualquer");
		String resposta = menu.alocaAluno(203, "Listas");
		assertEquals("GRUPO CHEIO", resposta);
	}

	@Test
	void testPertenceAGrupo() {
		menu.alocaAluno(202, "Listas");
		String resposta = menu.pertenceAGrupo("Listas", 202);
		assertEquals("ALUNO PERTENCE AO GRUPO", resposta);
	}
	
	@Test
	void testPertenceAGrupoInexistente() {
		menu.alocaAluno(202, "Listas");
		String resposta = menu.pertenceAGrupo("Nomes", 202);
		assertEquals("GRUPO N�O CADASTRADO.", resposta);
	}
	
	@Test
	void testPertenceAGrupoAlunoInexistente() {
		menu.alocaAluno(202, "Listas");
		String resposta = menu.pertenceAGrupo("Listas", 203);
		assertEquals("ALUNO N�O PERTENCE AO GRUPO", resposta);
	}
	
	@Test
	void testNaoPertenceAGrupo() {
		String resposta = menu.pertenceAGrupo("Listas", 202);
		assertEquals("ALUNO N�O PERTENCE AO GRUPO", resposta);
	}

	@Test
	void testRegistraAluno() {
		String resposta = menu.registraAluno(202);
		assertEquals("ALUNO REGISTRADO!", resposta);
	}
	
	@Test
	void testRegistraAlunoInexistente() {
		String resposta = menu.registraAluno(203);
		assertEquals("Aluno n�o cadastrado.", resposta);
	}

	@Test
	void testImprimeAlunos() {
		menu.registraAluno(202);
		menu.cadastraAluno(203, "Qualquer", "Qualquer");
		menu.registraAluno(203);
		menu.imprimeAlunos();
	}

	@Test
	void testChecaGruposDeAluno() {
		menu.alocaAluno(202, "Listas");
		menu.cadastraGrupo("Nomes", 10);
		menu.alocaAluno(202, "Nomes");
		menu.checaGruposDeAluno(202);
	}

}
