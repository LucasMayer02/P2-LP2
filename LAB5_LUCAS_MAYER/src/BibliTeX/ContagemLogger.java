package BibliTeX;

public class ContagemLogger implements Logger {
	private int transforma;
	private int contaTransformacao;
	private int historico;
	private int listarOriginais;
	private int listarAlgoritmos;
	
	public ContagemLogger() {
		this.transforma = 0;
		this.contaTransformacao = 0;
		this.historico = 0;
		this.listarOriginais = 0;
		this.listarAlgoritmos = 0;
	}
	/**
	 * Guarda o numero de vezes que um metodo foi chamado
	 * @return null
	 */
	@Override
	public String invocaLogger(String metodo, String parametro) {
		if(metodo.equals("transforma")) {
			this.transforma += 1;
		}else if(metodo.equals("contaTransformacao")) {
			this.contaTransformacao += 1;
		}else if(metodo.equals("historico")) {
			this.historico += 1;
		}else if(metodo.equals("listarOriginais")) {
			this.listarOriginais += 1;
		}else if(metodo.equals("listarAlgoritmos")) {
			this.listarAlgoritmos += 1;
		}
		return null;
	}
	
	/**
	 * Exibe quantas vezes quais metodos foram usados
	 * @return os metodos utilizados e quantas vezes cada
	 */
	public String toString() {
		String resposta = "";
		String valor;
		if(this.transforma > 0) {
			valor = String.valueOf(this.transforma);
			resposta += "transforma - " + valor + "\n";
		}
		if(this.contaTransformacao > 0) {
			valor = String.valueOf(this.contaTransformacao);
			resposta += "contaTransformacao - " + valor + "\n";
		}
		if(this.historico > 0) {
			valor = String.valueOf(this.historico);
			resposta += "historico - " + valor + "\n";
		}
		if(this.listarOriginais > 0) {
			valor = String.valueOf(this.listarOriginais);
			resposta += "listarOriginais - " + valor + "\n";
		}
		if(this.listarAlgoritmos > 0) {
			valor = String.valueOf(this.listarAlgoritmos);
			resposta += "listarAlgoritmos - " + valor + "\n";
		}
		return resposta; 
		
	}

}
