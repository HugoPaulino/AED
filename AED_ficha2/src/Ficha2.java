

public class Ficha2 {

	
	
	
	public class QuickSort {
	    
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
	    public static void sort(int[] arr, int low, int high) {
	        if (low < high) {
	            /* pi is partitioning index, arr[pi] is now
	               at right place */
	            int pi = partition(arr, low, high);
	 
	            // Recursively sort elements before
	            // partition and after partition
	            sort(arr, low, pi - 1);
	            sort(arr, pi + 1, high);
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
	            sort(arr, l, m);
	            sort(arr, m + 1, r);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
	 
	
	    public static void imprimeArray(int[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	
	
	
	public static void main(String[] args) {

		int[] arr = {10, 7, 8, 9, 1, 5};
		
        int n = arr.length;
 
        System.out.println("Given Array");
        printArray(arr);
 
        sort(arr, 0, n - 1);
 
        System.out.println("\nSorted array");
        printArray(arr);
		
		
	}

}
