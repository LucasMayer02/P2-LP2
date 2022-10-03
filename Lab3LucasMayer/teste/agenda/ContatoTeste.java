package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContatoTeste {

	@Test
	void testContato() {
		Contato contato = new Contato("Lucas", "Mayer", "222222-22222");
	}

	@Test
	void testExibeContato() {
		Contato contato = new Contato("Lucas", "Mayer", "22222-22222");
		assertEquals("Lucas Mayer\n22222-22222\n",contato.exibeContato());
	}
	
	@Test
	void testExibeContatoComTag() {
		Contato contato = new Contato("Lucas", "Mayer", "22222-22222");
		contato.adicionaTag("ufcg", 1);
		assertEquals("Lucas Mayer\n22222-22222\nufcg ",contato.exibeContato());
	}

	@Test
	void testAdicionaTag() {
		Contato contato = new Contato("Lucas", "Mayer", "22222-22222");
		contato.adicionaTag("ufcg", 1);
		assertEquals("Lucas Mayer\n22222-22222\nufcg ",contato.exibeContato());
	}

	@Test
	void testToString() {
		Contato contato = new Contato("Lucas", "Mayer", "22222-22222");
		assertEquals("Lucas Mayer", contato.toString());
	}

}
