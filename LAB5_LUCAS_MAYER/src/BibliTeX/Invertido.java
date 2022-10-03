package BibliTeX;

public class Invertido implements AlgoritmoTransformacao {
	/**
	 * Transforma a String Invertendo ela
	 * @return retorna a String modificada
	 */
	@Override
	public String transforma(String original) {
		String resultado = "";
		for(int i = original.length() - 1; i >= 0; i--) {
			String letra = original.substring(i, i + 1);
			resultado += letra;
		}
		return resultado;
	}
	/**
	 * Define o nome do algoritmo
	 * @return Retorna o nome do algoritmo
	 */
	@Override
	public String getNome() {
		return "Invertido";
	}

}
