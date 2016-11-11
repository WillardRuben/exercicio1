package exercicio1;

import java.util.Scanner;

public class ConsultorioMedico {

	public static void main(String[] args) {
		System.out.println("Consultório Médico");
		Scanner teclado = new Scanner(System.in);
		String[] nome = new String[100];
		String[] sexo = new String[100];
		int[] idade = new int[100];
		double[] valor = new double[100]; 
		int i=0;
		int limite=0;
		String parada = new String();
		while(!((parada.equalsIgnoreCase("N")))){
			nome[i] = leNomePaciente(teclado);
			idade[i] = leIdade(teclado);
			valor[i] = leValorConsulta(teclado);
			sexo[i] = leSexoPaciente(teclado);
			limite++;
			i++;
			System.out.println("Continuar cadastrando?(N ou S): ");
			parada = teclado.nextLine();			
		}
			menu(limite,nome, sexo, idade, valor);
	}
	public static void menu(int limite,String nome[],String sexo[],int idade[],double valor[]){
		Scanner teclado = new Scanner(System.in);
		int opcao;
		System.out.println("1 – Imprimir na tela os dados armazenados;");
		System.out.println("2 – Imprimir a média do valor das consultas realizadas");
		System.out.println("3 – Imprimir os dados das pessoas do sexo masculino;");
		System.out.println("4 – Imprimir o maior valor de consulta realizado por uma pessoa do sexo feminino.");			
		System.out.println("Digite uma opção: ");
		opcao = teclado.nextInt();
		switch(opcao){
			case 1:
				imprimirDados(limite, nome, sexo, idade, valor);
				continua(limite, nome, sexo, idade, valor);
				break;
			case 2:
				imprimirMedia(limite, valor);
				continua(limite, nome, sexo, idade, valor);
				break;
			case 3:
				imprimirMasculino(limite, nome, sexo, idade, valor);
				continua(limite, nome, sexo, idade, valor);
				break;
			case 4:
				imprimirMaiorValorFeminino(limite, valor, sexo);
				continua(limite, nome, sexo, idade, valor);
				break;
		}
	}
	public static void continua(int limite,String nome[],String sexo[],int idade[],double valor[]){
		Scanner teclado = new Scanner(System.in);
		String continua = new String();
		System.out.println("Continuar com o programa?(N ou S)");
		continua = teclado.nextLine(); 
		if(continua.equalsIgnoreCase("S")){
			menu(limite, nome, sexo, idade, valor);
		}
	} 
	public static void imprimirMaiorValorFeminino(int limite,double valor[],String sexo[]){
		int i;
		double compara = -1000;
		for(i=0;i<limite;i++){
			if((valor[i]>compara)&&(sexo[i].equalsIgnoreCase("F"))){
				compara = valor[i];
			}
		}
		System.out.printf("O maior valor de uma consulta foi R$ %.2f\n",compara);
	}
	public static void imprimirMasculino(int limite,String nome[],String sexo[],int idade[],double valor[]){
		int i;
		for(i=0;i<limite;i++){
			if(sexo[i].equalsIgnoreCase("M")){
				imprimirDados(limite, nome, sexo, idade, valor);
			}
		}
	}
	public static void imprimirMedia(int limite,double valor[]){
		int i;
		double soma=0;
		for(i=0;i<limite;i++){
			soma+=valor[i];
		}
		System.out.printf("O valor médio das consultas é R$ %.2f\n",(soma/limite));
	}
	public static String leSexoPaciente(Scanner in){
		String r;
		System.out.print("Digite o sexo do Paciente(M ou F): ");
		r = in.nextLine();
		if(!((r.equalsIgnoreCase("M")||(r.equalsIgnoreCase("F"))))){
			leSexoPaciente(in);
		}
		return r;
	}
	public static String leNomePaciente(Scanner in){
		System.out.print("Digite o nome do Paciente: ");
		String r;
		do{
			r = in.nextLine();
			if(r.length()<3){
				System.out.print("O nome deve ter, no mínimo, 3 caracteres. Digite novamente: ");
			}
		}while(r.length()<3);
		return r;
	}
	public static int leIdade(Scanner in){
		System.out.print("Digite a idade do paciente: ");
		int r=0;
		do{
			while(!in.hasNextInt()){
				in.nextLine();
				System.out.print("Tipo de dado inválido. Digite um inteiro: ");
			}
			r = in.nextInt();
			in.nextLine();
			if(r<=0){
				System.out.println("Digite um inteiro maior que 0: ");
			}
		}while(r<=0);
		
		return r;
	}
	public static double leValorConsulta(Scanner in){
		System.out.print("Digite o valor da consulta: ");
		while(!in.hasNextDouble()){
			in.nextLine();
			System.out.print("Tipo de dado inválido. Digite um double: ");
		}
		double r = in.nextDouble();
		in.nextLine();
		return r;
	}
	public static void imprimirDados(int limite,String nome[],String sexo[],int idade[],double valor[]){
		int i;
		for(i=0;i<limite;i++){
			System.out.println("Nome:"+nome[i]);
			System.out.println("Sexo:"+sexo[i]);
			System.out.println("Idade:"+idade[i]);
			System.out.printf("Valor da consulta: %.2f\n",valor[i]);
			System.out.println("============================");
		}
	}
}

