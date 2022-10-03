package menu;

import java.util.*;

/**
 * Um menu que mantem um mapa de alunos com sua matrícula, um mapa
 * de grupos com seus nomes e uma lista de alunos que responderam.
 * 
 * @author Lucas Leonardo Mayer Almeida - 120210158
 *
 */
public class Menu {
	
	private HashMap<Integer, Aluno> mapaMatriculaAlunos = new HashMap<>();
	private HashMap<String, Grupo> mapaGrupos = new HashMap<>();
	private ArrayList<Aluno> listaAlunosRespondem = new ArrayList<>();
	
	/**
	 * Cria um Menu
	 * 
	 */
	public Menu(){
		this.mapaMatriculaAlunos = new HashMap<>();
		this.mapaGrupos = new HashMap<>();
		this.listaAlunosRespondem = new ArrayList<>();
	}
	
	/**
	 * Cadastra o aluno por meio da matrícula e retorna se essa
	 * operação foi bem sucedida
	 * 
	 * @param matricula Inteiro que identifica um aluno
	 * @param nome Nome do Aluno
	 * @param curso Curso do Aluno
	 * @return Retorna uma String que mostra se a operação foi bem sucedida ou se
	 * essa matrícula já existia.
	 */
	public String cadastraAluno(int matricula, String nome, String curso) {
		if(this.mapaMatriculaAlunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA!";
		}else {
			this.mapaMatriculaAlunos.put(matricula, new Aluno(matricula, nome, curso));
			return "CADASTRO REALIZADO!";
		}
	}
	
	/**
	 * Exibe uma string que representa os dados do aluno por meio de sua matrícula
	 * 
	 * @param matricula Inteiro chave que representa o aluno dentro do mapa para
	 * poder ser identificado
	 * @return retorna a String que representa os dados do aluno ou uma mensagem de falha 
	 * pelo aluno não existir
	 */
	public String exibeAluno(int matricula) {
		Aluno aluno = this.mapaMatriculaAlunos.get(matricula);
		if(aluno == null) {
			return "Aluno não cadastrado.";
		}else {
			return aluno.toString(); 
		}
	}
	
	/**
	 * Cadastra um grupo por meio do seu nome
	 * 
	 * @param grupo Nome do grupo que sera usado como chave dentro do mapa para identificação
	 * @param tamanho Tamanho de alunos que o grupo pode chegar
	 * @return Retorna uma String que mostra se a operação foi realizada ou se já existia um 
	 * grupo com esse nome
	 */
	public String cadastraGrupo(String grupo, int tamanho) {
		boolean possui = false;
		for (Map.Entry<String, Grupo> grupoEntry : this.mapaGrupos.entrySet()) {
			if(grupoEntry.getKey().toUpperCase().equals(grupo.toUpperCase())) {
				possui = true;
			}
		}
		if(possui) {
			return "GRUPO JÁ CADASTRADO!";
		}else {
			this.mapaGrupos.put(grupo, new Grupo(grupo, tamanho));
			return "CADASTRO REALIZADO!";
		}
	}
	
	/**
	 * Aloca um aluno em um grupo
	 * 
	 * @param matricula Inteiro usado para identificar o Aluno dentro do mapa
	 * @param nome String usada para identificar o Grupo dentro do mapa
	 * @return Retorna uma String que mostra se a operação foi realizada ou se houve alguma problema como,
	 * aluno inexistente, grupo inexistente e grupo cheio
	 */
	public String alocaAluno(int matricula, String nome) {
		Aluno aluno = this.mapaMatriculaAlunos.get(matricula);
		Grupo grupo = this.mapaGrupos.get(nome);
		for (Map.Entry<String, Grupo> grupoEntry : this.mapaGrupos.entrySet()) {
			if(grupoEntry.getKey().toUpperCase().equals(nome.toUpperCase())) {
				grupo = this.mapaGrupos.get(grupoEntry.getKey());
			}
		}
		if(aluno == null) {
			return "Aluno não cadastrado.";
		}else if(grupo == null) {
			return "Grupo não cadastrado.";
		}else if(grupo.getAlunos().contains(aluno)) {
			return "ALUNO ALOCADO";
		}
		else if(grupo.getTamanhoLimite() == grupo.getTamanhoGrupo()) {
			return "GRUPO CHEIO";
		}else {
			aluno.adicionaGrupo(grupo);
			grupo.adicionaAluno(aluno);
			return "ALUNO ALOCADO";
		}
	}
	
	/**
	 * Mostra se um aluno pertence a um grupo
	 * 
	 * @param nome String que identifica o grupo dentro do mapa
	 * @param matricula Inteiro que identifica o aluno dentro do mapa
	 * @return Retorna uma String que mostra se o aluno pertence ou não
	 * ao grupo ou houve problemas como grupo inexistente
	 */
	public String pertenceAGrupo(String nome, int matricula) {
		Grupo grupo = this.mapaGrupos.get(nome);
		for (Map.Entry<String, Grupo> grupoEntry : this.mapaGrupos.entrySet()) {
			if(grupoEntry.getKey().toUpperCase().equals(nome.toUpperCase())) {
				grupo = this.mapaGrupos.get(grupoEntry.getKey());
			}
		}
		Aluno aluno = this.mapaMatriculaAlunos.get(matricula);
		if(grupo == null) {
			return "GRUPO NÃO CADASTRADO.";
		}
		HashSet<Aluno> alunos = grupo.getAlunos();
		if(alunos.contains(aluno)) {
			return "ALUNO PERTENCE AO GRUPO";
		}else {
			return "ALUNO NÃO PERTENCE AO GRUPO";
		}
		
	}
	
	/**
	 * Registra o aluno em uma lista de alunos que responderam quando
	 * foram chamados
	 * @param matricula Inteiro que identifica o aluno no mapa
	 * @return Retorna se a operação foi bem sucedida ou não
	 */
	public String registraAluno(int matricula) {
		Aluno aluno = this.mapaMatriculaAlunos.get(matricula);
		if(aluno == null) {
			return "Aluno não cadastrado.";
		}else {
			this.listaAlunosRespondem.add(aluno);
			return "ALUNO REGISTRADO!";
		}
	}
	
	/**
	 * Imprime a lista de alunos cada vez que responderam quando foram chamados
	 */
	public void imprimeAlunos() {
		for(int i = 0; i < this.listaAlunosRespondem.size(); i++) {
			Aluno aluno = this.listaAlunosRespondem.get(i);
			System.out.println(i+1 + ". " + aluno.toString());
		}
		
	}
	
	/**
	 * Checa os Grupos que um determinado aluno faz parte
	 * @param matricula Inteiro que identifica o aluno no mapa
	 */
	public void checaGruposDeAluno(int matricula) {
		Aluno aluno = this.mapaMatriculaAlunos.get(matricula);
		HashSet<Grupo> grupos = aluno.getGrupos();
		for(Grupo grupo : grupos) {
			System.out.println("- "+ grupo.toString());
		}
	}
}
