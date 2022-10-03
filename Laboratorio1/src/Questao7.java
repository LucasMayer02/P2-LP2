import java.util.Scanner;
import java.util.ArrayList;
/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 */

public class Questao7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nome = sc.next();
		ArrayList<Integer> notas = new ArrayList<Integer>();
		int maiorNota = -1;
		int menorNota = 1001;
		int total = 0;
		int media = 0;
		int quantidade = 0;
		int acimaDaMedia = 0;
		int abaixoDaMedia = 0;
		
		while(!nome.equals("-")) {
			int nota = sc.nextInt();
			if(nota > maiorNota) {
				maiorNota = nota;
			}
			if(nota < menorNota) {
				menorNota = nota;
			}
			if(nota >= 700) {
				acimaDaMedia++;
			}else {
				abaixoDaMedia++;
			}
			total += nota;
			quantidade++;
			nome = sc.next();
		}
		media = total / quantidade;
		
		System.out.println("maior: " + maiorNota);
		System.out.println("menor: " + menorNota);
		System.out.println("media: " + media);
		System.out.println("acima: " + acimaDaMedia);
		System.out.println("abaixo: " + abaixoDaMedia);
	}
}
