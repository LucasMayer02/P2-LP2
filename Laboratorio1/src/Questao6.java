import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */

public class Questao6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		String novoWally;
		
		while(!entrada.equals("wally")) {
			novoWally = "?";
			String[] pessoas = entrada.split(" ");
			for(int i = 0; i < pessoas.length; i++) {
				if(pessoas[i].length() == 5) {
					novoWally = pessoas[i];
				}
			}
			System.out.println(novoWally);
			entrada = sc.nextLine();
		}
	}
}
