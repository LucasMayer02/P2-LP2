
public class Caminhao extends Veiculos{
	
	private String placa;
	private int quilometragem;
	private String marca;
	private int desgaste;
	private int multas;
	private int rodas;
	
	public Caminhao(String placa, String marca) {
		super(placa, marca);
		this.rodas = 6;
	}
	
	@Override
	protected void defineDesgaste() {
		this.desgaste = this.quilometragem / 10 * 7;
	}
}
