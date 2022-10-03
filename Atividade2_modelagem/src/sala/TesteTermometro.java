package sala;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteTermometro {

	@Test
	void testTermometro() {
		Termometro t1 = new Termometro(0);
	}

	@Test
	void testMedicaoQuente() {
		Termometro t1 = new Termometro(31);
		assertEquals("QUENTE", t1.medicao());
	}
	
	@Test
	void testMedicaoOK() {
		Termometro t1 = new Termometro(30);
		assertEquals("OK", t1.medicao());
	}
	
	@Test
	void testMedicaoFrio() {
		Termometro t1 = new Termometro(10);
		assertEquals("FRIO", t1.medicao());
	}

}
