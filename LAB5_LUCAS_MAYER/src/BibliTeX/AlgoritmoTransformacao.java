package BibliTeX;

/**
 * Interface que representa os algoritmos que poderão transformar as strings
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public interface AlgoritmoTransformacao {
	/**
	 * Transforma uma String em outra
	 * 
	 * @param original String Original
	 * @return Retorna a String Modificada
	 */
	public String transforma(String original);
	/**
	 * DA o nome do algoritmo
	 * @return Retorna o nome do algoritmo
	 */
	public String getNome();
	
}
