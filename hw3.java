///// ex 2////
public class ArrayPalindrome {
	public static boolean isPalindromeRecursive(char[] c) {
		return isPalindromeRecursive(c, 0, c.length - 1);
	}
	
	public static boolean isPalindromeNoneRecursive(char[] c) {
		int start = 0;
		int end   = c.length - 1;
		
		while(end > start) {
			if (c[start] != c[end]) return false;
			++start; --end;
		}
		
		return true;
	}
	
	private static boolean isPalindromeRecursive(char[] c, int start, int end) {
		if (c.length == 0 || c.length == 1) return true;
		
		if (start >= end) return true;
		
		if (c[start] != c[end])
			return false;
		
		return isPalindromeRecursive(c, start + 1, end - 1);
	}
	
	public static void main(String[] args) {
		char[] c = {'a', 'b', 'a', 'b', 'a'};
		System.out.println(isPalindromeRecursive(c));
		
		char[] c1 = {'a', 'b', 'c', 'r'};
		System.out.println(isPalindromeNoneRecursive(c1));
	}
}



//Ex 3

import java.util.Arrays;

public class ArraySort {
	public static void bubbleSort(int[] arr) {
		int tmp;
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		int[] arr = {5, 1, 6, 4, 7, 3, 9, 1, 6};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
//1. It is n(n-1)/2
//2. Worst case is O(n^2)
//3. Best case is [1, 2, 3, 4, 5, 6, 7, 8]
// Worst case is [2, 7, 4, 8, 1, 3,5, 6]because it is an arbitrary array


//Ex 4

import java.util.Arrays;

public class ArraySort {
	public static void bucketSort(char[] arr) {
		int firstLetter = 'A';
		char[] bucket = new char[52];
		
		for (int i = 0; i < arr.length; i++) {
			bucket[arr[i] - firstLetter]++;
		}
		
		int pos = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				arr[pos++] = (char)(i + firstLetter);
			}
		}
}
	public static void main(String[] args) {
		int[] arr = {5, 1, 6, 4, 7, 3, 9, 1, 6};
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}

//2. Worst case is O(n^2)
//3. The implementation will not change


//Ex 5 
	import java.util.Arrays;

public class ArraySort {
	public static void insertionSort(int[] arr) {
  int tmp;
  for (int i = 1; i < arr.length; i++) {
    for (int j = i; j > 0; j--) {
      if (arr[j] < arr[j - 1]) {
        tmp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = tmp;
      }
    }
  }
}
	public static void main(String[] args) {
		int[] arr = {5, 1, 6, 4, 7, 3, 9, 1, 6};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}

//1. 1/2(N^2 - N)
//2. Worst case is O(n^2) When for the every element iteration will be compared to every element from the sorted subsection of the array
//3. Best case [1, 2, 3, 4, 5, 6, 7, 8]
//.  Worst case [8, 7, 6, 5, 4, 3, 2, 1]


//ex 6
import java.util.Arrays;

public class ArraySort {
	public static void selectionSort(int[] arr) {
  for (int i = 0; i < arr.length; ++i) {
    int lowestIndex = i;
    for (int j = i + 1; j < arr.length; ++j) {
      if (arr[j] < arr[i])
        lowestIndex = j;
    }
    
    int smallest = arr[lowestIndex];
    arr[lowestIndex] = arr[i];
    arr[i] = smallest;
  }
  
}
	public static void main(String[] args) {
		int[] arr = {5, 1, 6, 4, 7, 3, 9, 1, 6};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}

//1. n(n − 1) / 2 comparisons
//2. Worst case
//3. Worst case and best case performance are same so there is no difference, every array will work

//ex 7

import java.util.Arrays;

public class ArraySort {
	
	
	private static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	
	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (int i = 0; i < n1; ++i)
			left[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			right[j] = arr[m + 1 + j];
		
		int i = 0, j = 0, k = l;
		
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			arr[k] = left[i];
			i++; k++;
		}
		
		while (j < n2) {
			arr[k] = right[j];
			j++; k++;
		}
	}
	
	public static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	
  
 

	
	public static void main(String[] args) {
		int[] arr = {5, 1, 6, 4, 7, 3, 9, 1, 6};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
}
}

//1. 27
//2. O(m + n)
//3. O(nlogn)$ since merge sort is a stable sorting algorithm it worst, avarage, and best cases are always the same.


//ex 8

import java.util.Arrays;

public class ArraySort {



	
	private static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	
	private static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (int i = 0; i < n1; ++i)
			left[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			right[j] = arr[m + 1 + j];
		
		int i = 0, j = 0, k = l;
		
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			arr[k] = left[i];
			i++; k++;
		}
		
		while (j < n2) {
			arr[k] = right[j];
			j++; k++;
		}
	}
	

	
	public static int partition(int arr[], int low, int high) { 
        int pivot = arr[high];  
        int i = (low - 1);
        for (int j = low; j < high; j++) { 
            if (arr[j] <= pivot) {
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp; 
  
        return i + 1; 
    } 
  
 
	public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    }
	
	public static void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		int[] arr = {6, 1, 9, 3, 7, 4, 6, 1, 5};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}

//1. Pivot is the last element here
//2.16
//3. O(n^2)
