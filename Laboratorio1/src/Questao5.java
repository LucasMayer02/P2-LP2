import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */

public class Questao5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		String[] resultados = entrada.split(" ");
		int total = 0;
		
		for(int i = 0; i < resultados.length; i++) {
			total += Integer.parseInt(resultados[i]);
		}
		float media = total / (resultados.length); 
		for(int i = 0; i < resultados.length; i++) {
			if(Integer.parseInt(resultados[i]) > media) {
				if(i == resultados.length - 1) {
					System.out.print(resultados[i]);
				}else {
					System.out.print(resultados[i] + " ");
				}
			}
		}
	}
}
