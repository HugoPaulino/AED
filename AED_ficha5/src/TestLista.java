import java.util.Scanner;

public class TestLista {

	
	
	
	public static void main(String[] args) {
		ListaLigada aLista = new ListaLigada();
		
		
		int opcao=0;	
		Scanner input=new Scanner(System.in);
		
		do {
			imprimirMenu();
			opcao=input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					 aLista = adicionarCartas(aLista,10);
					break;
				case 2:
					imprimirLista(aLista);
					break;
				case 3:
					System.out.println("Introduza o indice da carta a procurar");
					int idx=input.nextInt();
					aLista.get(idx).toString();
					
					break;
				case 4:
					System.out.println("Introduza o indice da carta a remover");
					idx=input.nextInt();
					aLista.retirar(idx);
					break;
				default:
					System.out.println("ERRO: Opção inválida!\n");
			}
		}
		while(opcao!=0);
		input.close();
	}
//-------------------------------------------------------------------------------------------------
	private static void imprimirMenu() {
		System.out.println("1 – Adicionar Cartas");
		System.out.println("2 - Imprimir Lista");
		System.out.println("3 - Imprimir uma carta");
		System.out.println("4 – Remover Carta por Índice");
		System.out.println("4 – Sair\n");
		System.out.println("Opção => ");		
	}
	
	private static ListaLigada adicionarCartas(ListaLigada listaLigada, int numCartas) {
		for(int i = 0; i<numCartas;i++)
			listaLigada.inserirCabeca(new Carta());
		return listaLigada;
	}
	
	private static void imprimirLista(ListaLigada listaLigada) {
		for(int i = 0; i<listaLigada.getnElementos();i++)
			System.out.println(listaLigada.get(i));
	}

}
