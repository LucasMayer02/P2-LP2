package BibliTeX;

public class ConsoleLogger implements Logger {
	/**
	 * É invocado e mostra informações do método
	 * @return Retorna a mensagem de invocado alem do nome do método
	 * em que foi invocado e seu parametro
	 */
	@Override
	public String invocaLogger(String metodo, String parametro) {
		String resposta = "";
		resposta += "[" + metodo + "] " + parametro;
		return resposta;
	}

}
