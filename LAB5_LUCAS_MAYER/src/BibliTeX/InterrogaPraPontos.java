package BibliTeX;

public class InterrogaPraPontos implements AlgoritmoTransformacao {
	/**
	 * Transforma a String mudando as interrogações por pontos
	 * @return retorna a String modificada
	 */
	@Override
	public String transforma(String original) {
		String resultado = "";
		for(int i = 0; i < original.length(); ++i) {
			String letra = original.substring(i, i + 1);
			if(letra.equals("?")) {
				letra = ".";
			}
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
		return "InterrogaPraPontos";
	}

}
