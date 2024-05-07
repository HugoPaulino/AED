import java.util.Scanner;

public class Ex1 {

	
	public static int [] criarVetorOrdenado(int nElems) {
		
		int [] vetorOrdenado = new int[nElems];
		for(int i = 0; i<nElems;i++) {
			vetorOrdenado[i] = i;
		}
		
		return vetorOrdenado;
	}
	
	public static void imprimirVetor(int [] vector) {
		
		for(int i=0; i<vector.length; i++) {
			if (i>20)
				System.out.println("(...)");
			else
				System.out.printf("v[%d]=%d\n", i, vector[i]);

		}
	}
	
	public static int[] embaralharVetor(int []vetor, int nTrocas) {
		
		
		for (int i =0;i<nTrocas;i++) {
		
			int randomIndex = (int) (Math.random() * vetor.length);
			int randomIndex2 = (int) (Math.random() * vetor.length);
			
			int aux1 = vetor[randomIndex];
			
			vetor[randomIndex] = vetor[randomIndex2];
			vetor[randomIndex2] = aux1;
		}
		return vetor;
	}
	
	public static int somaElementos(int []vetor) {
		
		int soma=0;
		for(int i=0; i<vetor.length; i++) {
			soma+=vetor[i];
		}
		return soma;
	}
	
	public static int maiorElemAt(int []vetor) {
		int indiceMaiorElem=0;
		if ( vetor == null || vetor.length == 0 ) 
			return -1;
		
		for(int i=0; i<vetor.length; i++) {
			if (vetor[i] > vetor[indiceMaiorElem]) indiceMaiorElem = i;
		}
		return indiceMaiorElem;
		
	}
	
	public static int menorElemAt(int []vetor) {
		int indiceMaiorElem=0;
		if ( vetor == null || vetor.length == 0 ) 
			return -1;
		
		for(int i=0; i<vetor.length; i++) {
			if (vetor[i] < vetor[indiceMaiorElem])
				indiceMaiorElem = i;
		}
		return indiceMaiorElem;
		
	}
	
	
	// Função para verificar se um array está ordenado
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Função para permutar os elementos de um array
    public static void ordenacaoPorPermutacao(int[] arr) {
        int n = arr.length;
        while (!isSorted(arr)) {
            for (int i = 0; i < n - 1; i++) {
                // Troca os elementos adjacentes
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
	
	// ex 5
    public static int procuraLinear(int[] vetor, int valorAProcurar){
    	
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == valorAProcurar){
                return i; //valor encontrado, retorna o índice
            }
        }
        return -1; //valor não encontrado
    }
	
    public static int procuraBinaria(int[] vetor, int valorAProcurar){
    	
   	 	int esquerda = 0;
        int direita = vetor.length - 1;

        while (esquerda <= direita) {
       	 
            int meio = esquerda + (direita - esquerda) / 2;
        	System.out.println(meio);

            // Validar se esta presente no meio
            if (vetor[meio] == valorAProcurar)
                return meio;

            // Verificar se o valir a procurar é maior se sim ignorar a outra parte
            if (vetor[meio] < valorAProcurar)
                esquerda = meio + 1;

            // Verificar se o valor a procurar é mais pequeno, ignorar a parte direita.
            else
                direita = meio - 1;
        }

        // Target not found
        return -1;
    }
    
    //ex 7
    //Implementar o algoritmo de ordenação por seleção
    
    public static int [] ordPorSelecao( int [] vetor) {
    	int maxIndice = vetor.length;

        // Percorre o array
        for (int i = 0; i < maxIndice-1; i++) {
            // Encontra o menor elemento no array não ordenado
            int minIndice = i;
            for (int j = i+1; j < maxIndice; j++) {
                if (vetor[j] < vetor[minIndice]) {
                	minIndice = j;
                }
            }

            // Troca o menor elemento encontrado com o primeiro elemento não ordenado
            int temp = vetor[minIndice];
            vetor[minIndice] = vetor[i];
            vetor[i] = temp;
        }
        
		return vetor;
    }
    
    // ex 7:
 
    // ex 8
    public static int [] ordPorInserecao( int [] vetor) {
        int n = vetor.length;
        for (int i = 1; i < n; ++i) {
            int valor = vetor[i];
            int j = i - 1;

            /* Move os elementos do vetor[0..i-1], que são
               maiores que a chave, para uma posição à frente
               de sua posição atual */
            while (j >= 0 && vetor[j] > valor) {
            	vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            
            vetor[j + 1] = valor;
        }
        return vetor;
        }
    
    
 // Partition the array on the basis of a element 
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
 
                // Swap elements arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // Swap elements arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
 
        return i + 1;
    }
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is now
               at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    
    /* Merge Sort */
    
    // Merge two sorted subarrays arr[l..m] and arr[m+1..r]
    public static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temporary arrays
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    // ex 9
    
    
	
	public static void main(String[] args) {
		
	/*	int [] vetorTeste = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		imprimirVetor(vetorTeste);
		int [] vectorEmbaralhado = embaralharVetor(vetorTeste,5);
		imprimirVetor(vectorEmbaralhado);
		
	
		
		System.out.println(somaElementos(vectorEmbaralhado));
		System.out.println(maiorElemAt(vectorEmbaralhado));
		System.out.println(menorElemAt(vectorEmbaralhado));
		
		Ex 5:
		
		System.out.println("Insira o valor a procurar");
		int [] vetorProcuraLinearTeste = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int [] vectorProcLinEmbaralhado = embaralharVetor(vetorProcuraLinearTeste,50);
		imprimirVetor(vectorProcLinEmbaralhado);
		
		System.out.println("Insira o valor a procurar");
		Scanner input = new Scanner(System.in);
		
		int valorAProcurar = input.nextInt();
		
		int indiceDoValor = procuraLinear(vetorProcuraLinearTeste, valorAProcurar);
		
		System.out.println("Indice onde se encontra o valor: "+indiceDoValor);
		
		int indicedoValorBinario= procuraBinaria(vetorTeste, 5);
		
		System.out.println("indice Binario"+indicedoValorBinario);
		*/
		
		int [] vetor1 =  criarVetorOrdenado(100000);
		
		int [] vetor1embaralhado = embaralharVetor(vetor1, 200000);
		
		long inicio=System.nanoTime();
		
		int [] vector1OrdenadoSelecao = ordPorSelecao(vetor1);
	
		long fim=System.nanoTime ();
		System.out.printf("Tempo tamanho de array %d Ordenacao por seleção: %d nanosegundos", vetor1.length, (fim-inicio) );

		
		System.out.printf("Tempo tamanho de array %d Ordenacao por seleção: %d segundos", vetor1.length, (fim-inicio)/1000000000 );
		
		
		inicio=System.nanoTime();
		
		 ordenacaoPorPermutacao(vetor1);
	
		fim=System.nanoTime ();
		
		
	

	}

}
