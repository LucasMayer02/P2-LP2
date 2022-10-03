package BibliTeX;


public class BreakpointLogger implements Logger{
	private String metodoProprio;
	
	public BreakpointLogger(String metodo) {
		this.metodoProprio = metodo;
	}
	/**
	 * É invocado apenas pelo metodo designado
	 * @return Retorna a mensagem de invocado alem do nome do método
	 * em que foi invocado
	 */
	@Override
	public String invocaLogger(String metodo, String parametro) {
		if(metodo.equals(this.metodoProprio)) {
			return "[INVOCADO -" + metodo + "]";
		}else{
			return "";
		}
	}

}
