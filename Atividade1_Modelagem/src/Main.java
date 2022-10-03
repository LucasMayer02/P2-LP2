import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mensagem msg = new Mensagem();
		System.out.println("Diga sua idade:");
		int idade = sc.nextInt();	
		msg.defineExibeMensagem(idade);
		
	}
}
