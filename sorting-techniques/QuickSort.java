import java.util.Random;

public class QuickSort {
	
	public static void main(String[] args){
		int[] a = new int[args.length];
		for(int i=0;i<a.length;i++){
			a[i] = Integer.parseInt(args[i]);			
		}
		System.out.println("Before Sort : ");
		printArray(a);
		System.out.println("After shuffling (to ensure good performance) : ");
		knuthShuffle(a);
		printArray(a);
		System.out.println("--------------------------------SORTING--------------------------------");
		quickSort(a, 0, a.length-1);
		System.out.println("---------------------------------SORTED--------------------------------");
		System.out.println("After Quick Sort : ");
		printArray(a);
		assert isSorted(a);
	}
	
	private static void quickSort(int[] a, int low, int high){
		if(high > low){
			int j = partition(a, low, high);
			quickSort(a, j+1, high);
			printArray(a, j+1, high);
			quickSort(a, low, j-1);
			printArray(a, low, j-1);
		}
	}
	
	private static int partition(int a[], int low, int high){
		int i=low;
		int j=high+1;
		
		while(true){
			do{
				i++;
				if(i == high){
					break;
				}
			}while(a[i] < a[low]);
			
			do{
				j--;
				if(j == low){
					break;
				}
			}while(a[j] > a[low]);
			
			if(i >= j){
				break;
			}
			swap(a, i, j);
		}
		swap(a, low, j);
		return j;
	}
	
	private static void knuthShuffle(int[] a){
		Random rand = new Random();
		for(int i=1;i<a.length;i++){
			swap(a, i, rand.nextInt(i));
		}
	}
	
	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void printArray(int[] a){
		printArray(a, 0, a.length - 1);
	}
	
	// Print the array from the given range
	private static void printArray(int[] a, int low, int high){
		for(int i=low;i<=high;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	
	private static boolean isSorted(int[] a){
		return isSorted(a, 0, a.length-1);
	}
	
	// Check if the array is sorted in the given range
	private static boolean isSorted(int[] a, int low, int high){
		for(int i=low+1;i<=high;i++){
			if(a[i] < a[i-1]){
				return false; // Return false even if one condition fails
			}
		}
		return true; // Return true otherwise
	}
	
}