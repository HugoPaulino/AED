import java.io.File;
import java.util.Scanner;

public class TestLista {

	
	public static void main(String[] args) {
		ListaLigada aLista = new ListaLigada(); //lista que recebe palavras
		
		int opcao=0;	
		Scanner input=new Scanner(System.in);
		
		do {
			imprimirMenu();
			opcao=input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					 aLista = lerFicheiroParaLista("palavras.txt", aLista);
					break;
				case 2:
					 System.out.println(aLista.procura("remisso"));
					break;
				case 3:
					// System.out.println(aLista("an"));
					break;
				
				default:
					System.out.println("ERRO: Opção inválida!\n");
			}
		}
		while(opcao!=0);
		input.close();
		
		
		
	}
	
	private static ListaLigada lerFicheiroParaLista(String filePath, ListaLigada aLista) {
		
		String palavra = "";
		
		File f = new File(filePath);
		
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				palavra = sc.nextLine();
				aLista.inserirCauda(palavra);
			}
		} catch (Exception e) {

		}
		
		return aLista;
	}

	private static void imprimirMenu() {
		System.out.println("1 – Ler Ficheiro");
		System.out.println("2 - Procurar uma palavra");
		System.out.println("3 - Apagar uma palavra");
		System.out.println("4 – Gravar Ficheiro");
		System.out.println("5 – Sair\n");
		System.out.println("Opção => ");		
	}

}
