
public class Carro extends Veiculos {
	
	private String placa;
	private int quilometragem;
	private String marca;
	private int desgaste;
	private int multas;
	private int rodas;
	
	public Carro(String placa, String marca) {
		super(placa, marca);
		this.rodas = 4;
	}
	
	@Override
	protected void defineDesgaste() {
		this.desgaste = this.quilometragem / 10 * 5;
	}
}
