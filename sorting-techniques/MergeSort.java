public class MergeSort {
	
	public static void main(String[] args){
		int[] a = new int[args.length];
		for(int i=0;i<a.length;i++){
			a[i] = Integer.parseInt(args[i]);			
		}
		int[] b = new int[args.length]; // Helper array
		System.out.println("Before Sort : ");
		printArray(a);
		System.out.println("--------------------------------SORTING--------------------------------");
		mergeSort(a, b, 0, a.length-1);
		System.out.println("---------------------------------SORTED--------------------------------");
		System.out.println("After Merge Sort : ");
		printArray(a);
	}
	
	private static void mergeSort(int[] a, int[] b, int low, int high){
		if(high > low){
			int mid = (high + low)/2; // Divide
			mergeSort(a, b, low, mid); // Conquer
			mergeSort(a, b, mid+1, high); // Conquer
			merge(a, b, low, mid, high); // Combine
		}
	}
	
	private static void merge(int a[], int[] b, int low, int mid, int high){
		assert isSorted(a, low, mid);
		assert isSorted(a, mid+1, high);
		
		for(int i=0;i<a.length;i++){
			b[i] = a[i]; // Copy the original array in the helper array
		}
		int leftHelper = low;
		int rightHelper = mid+1;
		int current = low;
		while(leftHelper <= mid && rightHelper <= high){
			if(b[leftHelper] <= b[rightHelper]){
				a[current] = b[leftHelper];
				leftHelper++;
			} else {
				a[current] = b[rightHelper];
				rightHelper++;
			}
			current++;
		}
		
		// Copy the remaining items in left side of the array (if any) to the original array
		// Not worried about the right side because that is already copied initially
		int remaining = mid - leftHelper;
		for(int i=0;i<=remaining;i++){
			a[current+i] = b[leftHelper + i];
		}
		
		printArray(a, low, high);
		assert isSorted(a, low, high);
	}
	
	private static void printArray(int[] a){
		printArray(a, 0, a.length - 1);
	}
	
	private static void printArray(int[] a, int low, int high){
		for(int i=low;i<=high;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	
	private static boolean isSorted(int[] a){
		return isSorted(a, 0, a.length-1);
	}
	
	private static boolean isSorted(int[] a, int low, int high){
		for(int i=low+1;i<=high;i++){
			if(a[i] < a[i-1]){
				return false; // Return false even if one condition fails
			}
		}
		return true; // Return true otherwise
	}
	
}