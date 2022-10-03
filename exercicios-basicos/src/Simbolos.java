import java.util.Scanner; 
public class Simbolos { 
    @SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
         int linhas = Integer.parseInt(sc.nextLine());
         for (int i = 0; i < linhas; i++) {
             String simbolo = sc.next();
             int contagem = sc.nextInt();
             for (int j = i; j < contagem; j++) {
                 System.out.print(simbolo);
             }
             System.out.println();
         }
    }
}