import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */

public class Questao3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int valor1 = sc.nextInt();
		int valor2 = sc.nextInt();
		int valor3 = sc.nextInt();
		int valor4 = sc.nextInt();
		String resultado;
		
		if(valor1 < valor2 && valor2 < valor3 && valor3 < valor4) {
			resultado = "POSSIVELMENTE ESTRITAMENTE CRESCENTE";
		}
			else if(valor1 > valor2 && valor2 > valor3 && valor3 > valor4) {
				resultado = "POSSIVELMENTE ESTRITAMENTE DECRESCENTE";
			}
			else {
				resultado = "FUNCAO NAO ESTRITAMENTE CRES/DECR";
			}
		
		System.out.println(resultado);
	}

}
