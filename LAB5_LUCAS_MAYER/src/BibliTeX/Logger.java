package BibliTeX;

/**
 * Interface que representa um Logger que exibe informa��es dos m�todos
 * usados
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public interface Logger {
	/**
	 * Invoca o Logger 
	 * 
	 * @param metodo Metodo que o logger foi usado
	 * @param parametro Parametro usado no metodod
	 * @return Informa��es que o logger fornece
	 */
	public String invocaLogger(String metodo, String parametro);
}
