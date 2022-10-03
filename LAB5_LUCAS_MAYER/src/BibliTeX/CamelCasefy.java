package BibliTeX;

public class CamelCasefy implements AlgoritmoTransformacao {
	
	/**
	 * Transforma a String com CamelCase
	 * @return retorna a String modificada
	 */
	@Override
	public String transforma(String original) {
		boolean ehmaiuscula = true;
		String resultado = "";
		for(int i = 0; i < original.length(); ++i) {
			String letra = original.substring(i, i + 1);
			if(ehmaiuscula) {
				letra = letra.toUpperCase();
				ehmaiuscula = false;
			}else {
				letra = letra.toLowerCase();
				ehmaiuscula = true;
			}
			resultado += letra;
		}
		return resultado;
	}

	@Override
	public String getNome() {
		return "CaMeLcAsEfY";
	}

}
