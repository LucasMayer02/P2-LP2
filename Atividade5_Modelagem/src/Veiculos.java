
public class Veiculos {
	
	private String placa;
	private int quilometragem;
	private String marca;
	private int desgaste;
	private int multas;
	
	public Veiculos(String placa, String marca) {
		this.placa = placa;
		this.marca = marca;
		this.quilometragem = 0;
		this.multas = 0;
		this.desgaste = 0;
	}
	
	public void viajar(int quilometros) {
		this.quilometragem += quilometros;
		this.defineDesgaste();
	}
	
	public void multar() {
		this.multas += 1;
	}
	
	public String mostraPlaca() {
		return this.placa;
	}
	
	public int mostraQuilometragem() {
		return this.quilometragem;
	}
	
	protected void defineDesgaste() {
		this.desgaste = quilometragem / 10;
	}

}
