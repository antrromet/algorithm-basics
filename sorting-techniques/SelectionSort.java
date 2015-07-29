public class SelectionSort {

	public static void main(String[] args){
		int[] a = new int[args.length];
		for(int i=0;i<a.length;i++){
			a[i] = Integer.parseInt(args[i]);
		}
		
		System.out.println("Before Sort : ");
		printArray(a);
		System.out.println("--------------------------------SORTING--------------------------------");
		selectionSort(a);
		System.out.println("---------------------------------SORTED--------------------------------");
		System.out.println("After Insertion Sort : ");
		printArray(a);
		assert isSorted(a);
	}
	
	private static void selectionSort(int[] a){
		for(int i=0;i<a.length-1;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			swap(a, i, min);
			printArray(a);
		}
	}
	
	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
		
	private static void printArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	private static boolean isSorted(int[] a){
		for(int i=1;i<a.length;i++){
			if(a[i] < a[i-1]){
				return false; // Return false even if one condition fails
			}
		}
		return true; // Return true otherwise
	}

}