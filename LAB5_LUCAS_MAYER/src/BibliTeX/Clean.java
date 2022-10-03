package BibliTeX;

public class Clean implements AlgoritmoTransformacao {
	/**
	 * Transforma a String retirando os acentos
	 * @return retorna a String modificada
	 */
	@Override
	public String transforma(String original) {
		String resultado = "";
		for(int i = 0; i < original.length(); ++i) {
			String letra = original.substring(i, i + 1);
			if(letra.equals(".") || letra.equals(",") ||
					letra.equals(";") || letra.equals(":") || letra.equals("!") ||
					letra.equals("?") || letra.equals("...")) {
				continue;
			}else {
				resultado += letra;
			}
		}
		return resultado;
	}
	/**
	 * Define o nome do algoritmo
	 * @return Retorna o nome do algoritmo
	 */
	@Override
	public String getNome() {
		return "Clean";
	}

}
