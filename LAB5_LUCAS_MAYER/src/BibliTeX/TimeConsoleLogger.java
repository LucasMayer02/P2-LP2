package BibliTeX;

public class TimeConsoleLogger implements Logger {
	/**
	 * � invocado e mostra o tempo que demorou entre a cria��o do objeto e 
	 * invoca��o do metodo
	 * @return Retorna a mensagem do nome do m�todo
	 * em que foi invocado, parametro e tempo em que demorou a invoca��o
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
