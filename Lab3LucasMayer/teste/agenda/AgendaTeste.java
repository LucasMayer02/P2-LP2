package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTeste {

	@Test
	public void testAgenda() {
		Agenda agenda = new Agenda();
	}

	@Test
	public void testGetContatos() {
		Agenda agenda = new Agenda();
		assertNotEquals(null, agenda.getContatos());
	}

	@Test
	void testGetContato() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio\n" + "(83) 99999-0000\n" , agenda.getContato(1));
	}
	
	@Test
	void testGetContatoNulo() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(null, agenda.getContato(2));
	}

	@Test
	void testCadastraContato() {
		Agenda agenda = new Agenda();
		assertEquals("\nCADASTRO REALIZADO", agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoPosicaoInvalida() {
		Agenda agenda = new Agenda();
		assertEquals("\nPOSIÇÃO INVÁLIDA", agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoPosicaoInvalida2() {
		Agenda agenda = new Agenda();
		assertEquals("\nPOSIÇÃO INVÁLIDA", agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoNomeVazio() {
		Agenda agenda = new Agenda();	
		assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoNomeSobrenomeIgual() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("\nCONTATO JA CADASTRADO", agenda.cadastraContato(2, "Mathues", "Gaudencio", "(83) 22222-2222"));
	}
	
	@Test
	void testCadastraContatoTelefoneVazio() {
		Agenda agenda = new Agenda();
		assertEquals("\nCONTATO INVALIDO", agenda.cadastraContato(1, "Mathues", "Gaudencio", ""));
	}

	@Test
	void testGetFavoritos() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		Contato[] contatos = agenda.getContatos();
		Contato contato = contatos[0];
		int posicao = 1;
		agenda.adicionaFavorito(contato, posicao);
		assertNotEquals(null, agenda.getFavoritos());
	}

	@Test
	void testGetFavorito() {
		Agenda agenda = new Agenda();
		Contato contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		int posicao = 1;
		agenda.adicionaFavorito(contato, posicao);
		assertEquals("Matheus Gaudencio\n" + "(83) 99999-0000\n", agenda.getFavorito(posicao));
	}
	
	@Test
	void testGetFavoritoNulo() {
		Agenda agenda = new Agenda();
		Contato contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		int posicao = 1;
		agenda.adicionaFavorito(contato, posicao);
		assertEquals(null, agenda.getFavorito(posicao + 1));
	}

	@Test
	void testAdicionaFavorito() {
		Agenda agenda = new Agenda();
		Contato contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		int posicao = 1;
		assertEquals("CONTATO FAVORITADO NA POSIÇÂO " + posicao + "!", agenda.adicionaFavorito(contato, posicao));
	}

	@Test
	void testDefineTag() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.defineTag(1, "ufcg", 1);
	}
	
	@Test
	void testExibeContato() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Dados do contato:\n\n" + "Matheus Gaudencio\n" + "(83) 99999-0000\n", agenda.exibeContato(1));
	}
	
	@Test
	void testExibeContatoNulo() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("\nPOSIÇÃO INVÁLIDA!", agenda.exibeContato(2));
	}
	
	@Test
	void testExibeContatoFavorito() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		Contato[] contatos = agenda.getContatos();
		Contato contato = contatos[0];
		agenda.adicionaFavorito(contato, 1);
		assertEquals("Dados do contato:\n\n" + "S2 Matheus Gaudencio\n" + "(83) 99999-0000\n", agenda.exibeContato(1));
	}

}
