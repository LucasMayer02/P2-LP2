import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */

public class Questao2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float valor1 = sc.nextFloat();
		sc.nextLine();
		float valor2 = sc.nextFloat();
		String resultado = "pass: True!";
		float media = (valor1 + valor2) / 2;
		if(media < 7.0) {
			resultado = "pass: False!";
		}
		System.out.println(resultado);
	}	

}
