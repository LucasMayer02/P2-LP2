package menu;

import java.util.*;

/**
 * Uma interface para poder manipular um menu de controle de alunos
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class MainMenu {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, menu, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do usuário
	 * 
	 * @param scanner Captura a opção do usuário
	 * @return Comando escolhido
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" + 
						"(A)locar Aluno no Grupo e Verificar pertinencia a Grupos\n" +
						"(R)egistrar Aluno que Respondeu\n" +
						"(I)mprimir Alunos que Responderam\n" +
						"(O)lhaí quais Grupos o Aluno Tá.\n" +
						"(S)im, quero Fechar o Programa!\n" +
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida do usuário
	 * 
	 * @param opcao Opção Digitada
	 * @param menu O menu que estamos manipulando
	 * @param scanner Objeto para a necessidade de um input
	 */
	private static void comando(String opcao, Menu menu, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(menu, scanner);
			break;
		case "E":
			exibeAluno(menu, scanner);
			break;
		case "N":
			cadastraGrupo(menu, scanner);
			break;
		case "A":
			alocaAlunosOuVerificaEmGrupos(menu, scanner);
			break;
		case "R":
			registraAlunoRespondeu(menu, scanner);
			break;
		case "I":
			imprimeAlunoRespondeu(menu);
			break;
		case "O":
			olhaGruposDeAluno(menu, scanner);
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	/**
	 * Encerra o programa
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}
	
	/**
	 * Pede a matrícula do aluno e invoca o método checaGruposDeAluno
	 * 
	 * @param menu O menu manipulado
	 * @param scanner Coleta a informação fornecida pelo usuário
	 */
	private static void olhaGruposDeAluno(Menu menu, Scanner scanner) {
		System.out.println("Aluno: ");
		int matricula = scanner.nextInt();
		System.out.println("Grupos: ");
		menu.checaGruposDeAluno(matricula);
		
	}
	
	/**
	 * Invoca o método imprimeAlunos que retorna uma lista de alunos que responderam
	 * 
	 * @param menu O menu manipulado
	 */
	private static void imprimeAlunoRespondeu(Menu menu) {
		System.out.println("Alunos: ");
		menu.imprimeAlunos();
		
	}
	
	/**
	 * Pede a matricula do aluno para invocar e retornar o método
	 * registraAluno
	 * 
	 * @param menu O menu manipulado
	 * @param scanner Coleta a informação fornecida pelo usuário
	 */
	private static void registraAlunoRespondeu(Menu menu, Scanner scanner) {
		System.out.println("Matricula: ");
		int matricula = scanner.nextInt();
		System.out.println(menu.registraAluno(matricula));
		
	}
	
	/**
	 * Pede para escolher entre alocar um aluno ou checar sua pertinência em um grupo,
	 * sendo alocar, pede a matricula e o nome do grupo para invocar e retornar o método
	 * alocaAluno, sendo checar a pertinência, pede o nome do grupo e a matricula do aluno
	 * para invocar e retornar o método pertenceAGrupo.
	 *
	 * @param menu O menu manipulado
	 * @param scanner Coleta a informação fornecida pelo usuário
	 */
	private static void alocaAlunosOuVerificaEmGrupos(Menu menu, Scanner scanner) {
		System.out.println("(A)locar Aluno ou (P)ertinência a Grupo?");
		String opcao = scanner.next().toUpperCase();
		if(opcao.equals("A")) {
			System.out.println("Matricula: ");
			int matricula = scanner.nextInt();
			System.out.println("Grupo: ");
			scanner.nextLine();
			String grupo = scanner.nextLine();
			System.out.println(menu.alocaAluno(matricula, grupo));
		}else if(opcao.equals("P")) {
			scanner.nextLine();
			System.out.println("Grupo: ");
			String grupo = scanner.nextLine();
			System.out.println("Aluno: ");
			int matricula = scanner.nextInt();
			System.out.println(menu.pertenceAGrupo(grupo, matricula));
		}else {
			System.out.println("Opção Inválida");
		}
	}
	
	/**
	 * Pede o grupo e o tamanho(caso não informado não tem limite) para chamar e exibir o retorno
	 * do método cadastraGrupo 
	 * 
	 * @param menu O menu manipulado
	 * @param scanner Coleta a informação fornecida pelo usuário
	 */
	private static void cadastraGrupo(Menu menu, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nGrupo: ");
		String grupo = scanner.nextLine();
		System.out.print("\nTamanho: ");
		String tamanho = scanner.nextLine();
		int tamanhoInt;
		if(tamanho.isBlank()) {
			tamanhoInt = Integer.MAX_VALUE;
		}else {
			tamanhoInt = Integer.parseInt(tamanho);
			}
		System.out.println(menu.cadastraGrupo(grupo, tamanhoInt));
		
	}
	
	/**
	 * Pede a matrícula de um aluno para poder chamar o método exibeAluno e 
	 * mostrar as informações do aluno
	 * 
	 * @param menu O menu manipulado
	 * @param scanner Coleta a informação fornecida pelo usuário
	 */
	private static void exibeAluno(Menu menu, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		int matricula = scanner.nextInt();
		System.out.println("Aluno: " + menu.exibeAluno(matricula));
		
	}
	
	/**
	 * Pede as informações de matricula, nome e curso para poder chamar o método
	 * de cadastro do aluno
	 * 
	 * @param menu O menu manipulado
	 * @param scanner Coleta a informação fornecida pelo usuário
	 */
	private static void cadastraAluno(Menu menu, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		int matricula = scanner.nextInt();
		System.out.print("\nNome: ");
		scanner.nextLine();
		String nome = scanner.nextLine();
		System.out.print("\nCurso: ");
		String curso = scanner.nextLine();
		System.out.println(menu.cadastraAluno(matricula, nome, curso));
	}
}
