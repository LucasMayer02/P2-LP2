package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa � a maneira de lidar com poss�veis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo n�o encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usu�rio/a.
	 * 
	 * @param scanner Para captura da op��o do usu�rio.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" +
						"(S)air\n" + 
						"\n" + 
						"Op��o> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a op��o escolhida por quem est� usando o sistema.
	 * 
	 * @param opcao   Op��o digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "T":
			criaTag(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Op��o inv�lida!");
		}
	}
	
	/**
	 * Pede os Contatos onde a tag ser� adicionada, o nome da tag
	 * e a posicao que a tag ficara na lista de tags
	 * alem de invocar o m�todo defineTag() 
	 *
	 * @param agenda A Agenda que estamos manipulando
	 * @param scanner Objeto Scanner usado para input
	 */
	private static void criaTag(Agenda agenda, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nContato> ");
		String posicao1 = scanner.nextLine();
		System.out.print("\nTag> ");
		String tag = scanner.next();
		System.out.print("\nPosicao tag> ");
		int posicaoTag = scanner.nextInt();
		String[] posicoes = posicao1.split(" ");
		for(int i = 0; i < posicoes.length; i++) {
			int posicao = Integer.parseInt(posicoes[i]);
			agenda.defineTag(posicao, tag, posicaoTag);
		}
		
	}
	
	/**
	 * Lista todos os contatos presentes na agenda
	 * 
	 * @param agenda A agenda que estamos manipulando
	 */
	private static void listaFavoritos(Agenda agenda) {
		Contato[] favoritos = agenda.getFavoritos();
		for(int i = 0; i < favoritos.length; i++) {
			if(favoritos[i] != null) {
				System.out.println(formataContato(i, favoritos[i]));
			}
		}
		
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		System.out.println(agenda.exibeContato(posicao));
	}

	/**
	 * Formata um contato para impress�o na interface. 
	 * 
	 * @param posicao A posi��o do contato (que � exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informa��es do contato.
	 * 
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosi��o na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
		}

	/**
	 * Sai da aplica��o.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}
	
	/**
	 * Pede o contato que sera favoritado e pede
	 * em qual posi��o dos favoritos o contato vai ficar
	 * alem de invocar um m�todo adicionaFavorito da agenda
	 * 
	 * @param agenda A agenda manipulada.
	 * @param scanner Scanner para coletar o que � pedido
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicao1 = scanner.nextInt();
		System.out.print("\nPosicao> ");
		int posicao2 = scanner.nextInt();
		Contato[] contatos = agenda.getContatos();
		Contato contato = contatos[posicao1-1];
		System.out.println(agenda.adicionaFavorito(contato, posicao2));
	}

	/**
	 * L� uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo n�o exista ou n�o possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}

