public class BubbleSort {

	public static void main(String[] args){
		int[] a = new int[args.length];
		for(int i=0;i<a.length;i++){
			a[i] = Integer.parseInt(args[i]);
		}
		
		System.out.println("Before Sort : ");
		printArray(a);
		System.out.println("--------------------------------SORTING--------------------------------");
		bubbleSort(a);
		System.out.println("---------------------------------SORTED--------------------------------");
		System.out.println("After Bubble Sort : ");
		printArray(a);
		assert isSorted(a);
	}
	
	private static void bubbleSort(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length - i - 1;j++){
				if(a[j] > a[j+1]){
					swap(a, j, j+1);
					printArray(a);
				}
			}
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