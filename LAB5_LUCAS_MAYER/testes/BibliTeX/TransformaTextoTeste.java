package BibliTeX;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransformaTextoTeste {

	@Test
	void testTransformaTexto() {
		TransformaTexto tt = new TransformaTexto();
	}

	@Test
	void testTransformaTextoLogger() {
		Logger cl = new ConsoleLogger();
		TransformaTexto tt = new TransformaTexto(cl);
	}

	@Test
	void testCadastraTransformacao() {
		TransformaTexto tt = new TransformaTexto();
		AlgoritmoTransformacao meuAlgoritmo = new InterrogaPraPontos();
		tt.cadastraTransformacao("InterrogaPraPontos", meuAlgoritmo);
	}
	
	@Test
	void testTransformaInterrogaPontos() {
		TransformaTexto tt = new TransformaTexto();
		AlgoritmoTransformacao meuAlgoritmo = new InterrogaPraPontos();
		tt.cadastraTransformacao("InterrogaPraPontos", meuAlgoritmo);
		String resposta = tt.transforma("InterrogaPraPontos", "oi, como vc vai?");
		assertEquals("oi, como vc vai.", resposta);
	}
	
	@Test
	void testTransformaCamelCasefy() {
		TransformaTexto tt = new TransformaTexto();
		String resposta = tt.transforma("CaMeLcAsEfY", "OI, como vc vai?");
		assertEquals("Oi, CoMo vC VaI?", resposta);
	}
	
	@Test
	void testTransformaClean() {
		TransformaTexto tt = new TransformaTexto();
		String resposta = tt.transforma("clean", "oi, como vc vai?");
		assertEquals("oi como vc vai", resposta);
	}

	@Test
	void testTransformaUpperCase() {
		TransformaTexto tt = new TransformaTexto();
		AlgoritmoTransformacao meuAlgoritmo = new UpperCase();
		tt.cadastraTransformacao("Upper", meuAlgoritmo);
		String resposta = tt.transforma("Upper", "oi, como vc vai?");
		assertEquals("OI, COMO VC VAI?", resposta);
	}
	
	@Test
	void testTransformaCleanSpaces() {
		TransformaTexto tt = new TransformaTexto();
		AlgoritmoTransformacao meuAlgoritmo = new cleanSpaces();
		tt.cadastraTransformacao("cleanSpaces", meuAlgoritmo);
		String resposta = tt.transforma("cleanSpaces", "oi, como vc vai?");
		assertEquals("oi,comovcvai?", resposta);
	}
	
	@Test
	void testTransformaInvertido() {
		TransformaTexto tt = new TransformaTexto();
		AlgoritmoTransformacao meuAlgoritmo = new Invertido();
		tt.cadastraTransformacao("Invertido", meuAlgoritmo);
		String resposta = tt.transforma("Invertido", "oi, como vc vai?");
		assertEquals("?iav cv omoc ,io", resposta);
	}
	
	@Test
	void testContaTransformacao() {
		TransformaTexto tt = new TransformaTexto();
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		tt.transforma("clean", "oi, como vc vai?");
		tt.transforma("clean", "oi, como vc vai?");
		String resposta = tt.contaTransformacao();
		assertEquals("3", resposta );

	}

	@Test
	void testHistorico() {
		TransformaTexto tt = new TransformaTexto();
		tt.transforma("clean", "oi, como vc vai?");
		tt.transforma("clean", "oi, como vc vai?");
		String resposta = tt.historico(0);
		String resposta2 = tt.historico(1);
		assertEquals("oi, como vc vai? -> clean -> oi como vc vai", resposta );
		assertEquals("oi, como vc vai? -> clean -> oi como vc vai", resposta2 );
	}

	@Test
	void testListarOriginais() {
		TransformaTexto tt = new TransformaTexto();
		tt.transforma("clean", "oi, como vc vai?");
		tt.transforma("clean", "Oi, como vc vai?");
		String resposta = tt.listarOriginais();
		assertEquals("oi, como vc vai?\n"
				+ "Oi, como vc vai?\n"
				, resposta);

	}

	@Test
	void testListarAlgoritmos() {
		TransformaTexto tt = new TransformaTexto();
		AlgoritmoTransformacao meuAlgoritmo3 = new cleanSpaces();
		tt.cadastraTransformacao("cleanSpaces", meuAlgoritmo3);
		String resposta = tt.listarAlgoritmos();
		assertEquals("CaMeLcAsEfY\n" + "Clean\n" + "CleanSpaces\n", resposta);
	}
	
	@Test
	void testConsoleLogger() {
		Logger cl = new ConsoleLogger();
		TransformaTexto tt = new TransformaTexto(cl);
		String resposta = tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		assertEquals("[transforma] CaMeLcAsEfY\n" + "Oi, CoMo vC VaI?", resposta);
	}
	
	@Test
	void testContagemLogger() {
		ContagemLogger ctl = new ContagemLogger();
		TransformaTexto tt = new TransformaTexto(ctl);
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		tt.transforma("clean", "oi, como vc vai?");
		tt.contaTransformacao();
		tt.historico(0);
		String resposta = ctl.toString();
		assertEquals("transforma - 2\n"
				+ "contaTransformacao - 1\n"
				+ "historico - 1\n", resposta);
	}
	
	@Test
	void testBreakpointLogger() {
		BreakpointLogger il = new BreakpointLogger("contaTransformacao");
		TransformaTexto tt = new TransformaTexto(il);
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		tt.transforma("clean", "oi, como vc vai?");
		String resposta = tt.contaTransformacao();
		assertEquals("[INVOCADO - contaTransformacao]" + "\n" + "2", resposta);
	}
	
	@Test
	void testTimeConsoleLogger() {
		TimeConsoleLogger tcl = new TimeConsoleLogger();
		TransformaTexto tt = new TransformaTexto(tcl);
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		tt.transforma("clean", "oi, como vc vai?");
		tt.contaTransformacao();
		tt.historico(0);
	}
	

}
