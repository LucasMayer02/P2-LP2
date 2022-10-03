package BibliTeX;

public class UpperCase implements AlgoritmoTransformacao {
	/**
	 * Transforma a String colocando tudo em maiusculo
	 * @return retorna a String modificada
	 */
	@Override
	public String transforma(String original) {
		String resultado = "";
		for(int i = 0; i < original.length(); ++i) {
			String letra = original.substring(i, i + 1);
			letra = letra.toUpperCase();
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
		return "UpperCase";
	}

}
