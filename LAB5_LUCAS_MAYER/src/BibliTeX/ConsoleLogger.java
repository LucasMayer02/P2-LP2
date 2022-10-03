package BibliTeX;

public class ConsoleLogger implements Logger {
	/**
	 * � invocado e mostra informa��es do m�todo
	 * @return Retorna a mensagem de invocado alem do nome do m�todo
	 * em que foi invocado e seu parametro
	 */
	@Override
	public String invocaLogger(String metodo, String parametro) {
		String resposta = "";
		resposta += "[" + metodo + "] " + parametro;
		return resposta;
	}

}
