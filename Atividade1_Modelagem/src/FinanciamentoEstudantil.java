
public class FinanciamentoEstudantil {
	private int dividaBase;
	
	public void defineDividaBase(int valor) {
		this.dividaBase = valor;
	}
	
	public void aumentaDivida(int valor) {
		this.dividaBase += valor;
	}
	
	public void diminuiDivida(int valor) {
		this.dividaBase -= valor;
	}
}
