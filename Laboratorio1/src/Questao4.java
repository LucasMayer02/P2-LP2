import java.util.Scanner;
/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */

public class Questao4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String operacao = sc.next();
		float valor1;
		float valor2;
		float resultado = 0;
		boolean erro = false;
		boolean invalida = false;
		
		if(operacao.equals("+")) {
			valor1 = sc.nextFloat();
			valor2 = sc.nextFloat();
			resultado = valor1 + valor2;
		}else if(operacao.equals("-")) {
			valor1 = sc.nextFloat();
			valor2 = sc.nextFloat();
			resultado = valor1 - valor2;
		}else if(operacao.equals("*")) {
			valor1 = sc.nextFloat();
			valor2 = sc.nextFloat();
			resultado = valor1 * valor2;
		}else if(operacao.equals("/")) {
			valor1 = sc.nextFloat();
			valor2 = sc.nextFloat();
			if(valor2 == 0.0 ) {
				erro = true;
			}else {
				resultado = valor1 / valor2;
			}
		}else {
			invalida = true;
		}
		
		if(invalida) {
			System.out.println("ENTRADA INVALIDA");
		}else if(erro) {
			System.out.println("ERRO");
		}else {
			System.out.println("RESULTADO: " + resultado);
		}
	}
}
