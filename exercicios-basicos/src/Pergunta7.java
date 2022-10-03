
public class Pergunta7 {
	public static void main(String[] args) {
        int[] valores = new int[10];
        int soma1 = 0;
        for (int i : valores) {
            soma1 += i;
        }
        int soma2 = 0;
        for (int i = 0; i < valores.length - 1; i++) {
            valores[i] = i;
            soma2 += i;
        }
        int soma3 = 0;
        for (int i = 0; i < valores.length; i++) {
            soma3 += valores[i];
        }
        System.out.println(soma1);
        System.out.println(soma2);
        System.out.println(soma3);
    }
}
