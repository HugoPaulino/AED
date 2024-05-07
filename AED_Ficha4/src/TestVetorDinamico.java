import java.util.Scanner;

public class TestVetorDinamico {

	public static void main(String[] args) {
		
		VetorDinamico vetor =  new VetorDinamico(10);
;
		int opcao=0;	
		Scanner input=new Scanner(System.in);
		
		do {
			imprimirMenu();
			opcao=input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					preencherVetor(vetor);
					break;
				case 2:
					
					listarVetor(vetor);
					break;
				case 3:
					vetor.retirarTodas(vetor);
					listarVetor(vetor);
					break;
				case 4:
					listarVetor(vetor);
					break;
				case 0:
					
					break;
				default:
					System.out.println("ERRO: Opção inválida!\n");
			}
		}
		while(opcao != 0 );
		input.close();
	}
//-------------------------------------------------------------------------------------------------
	private static void imprimirMenu() {
		System.out.println("1 – Inserir elementos");
		System.out.println("2 – Listar o vector");
		System.out.println("3 – Apagar elementos");
		System.out.println("4 – Encontrar o maior e o menor elemento");
		System.out.println("0 – Terminar\n");
		System.out.println("Opção => ");		
	}
//-------------------------------------------------------------------------------------------------
	private static int novoNumero() {
		return (int)(Math.random()*1000.0);
	}
	
	private static void preencherVetor(VetorDinamico v ) {
		for (int i = 0; i< 10; i++)
			v.adicionar(novoNumero());
		
	}
	
	private static void listarVetor(VetorDinamico v ) {
		for (int i = 0; i< v.getnElems(); i++)
			System.out.println(v.get(i));
			
		
	}

}
