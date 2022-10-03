
public class Main {
 public static void main(String[] args) {
  final int ANGULO = 45;
  Robo r1 = new RoboSeguranca(100);
  Robo r2 = new RoboSegurancaEletronico(100);
  Robo r3 = new RoboSegurancaInteligente(100,"livia@computacao...");

  String tipoRobo = "Seguranca";
  switch(tipoRobo){
  case "Seguranca":
   vigia(r1, ANGULO);
   break;
   default:
    System.out.println("Erro....");
  }
}

 private static void vigia(Robo r, int angulo){
  if(r.verificaEnergia()) {
   if(r.detectaPresenca()) {
    r.soaAlarme();
   } else {
    r.girar(angulo);
   }
  }
 }
}