package BibliTeX;

public class TimeConsoleLogger implements Logger {
	/**
	 * É invocado e mostra o tempo que demorou entre a criação do objeto e 
	 * invocação do metodo
	 * @return Retorna a mensagem do nome do método
	 * em que foi invocado, parametro e tempo em que demorou a invocação
	 */
	@Override
	public String invocaLogger(String metodo, String parametro) {
		String resposta = "";
		long numero = System.currentTimeMillis();
		String contagem = String.valueOf(numero);
		resposta += "[" + metodo + " -" + contagem + "ms] " + parametro;
		return resposta;
	}
	

}
