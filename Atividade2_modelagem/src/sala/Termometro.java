package sala;

public class Termometro {

    private int temp;

    public Termometro(int tempInicial) {
        this.temp = tempInicial;
    }
   
    public String medicao() {
        if (this.temp > 30) {
            return "QUENTE";
        }
        if (this.temp <= 10) {
            return "FRIO";
        }
        return "OK";
    } 
}
