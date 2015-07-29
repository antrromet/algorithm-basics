public class MergeSort {
	
	public static void main(String[] args){
		int[] a = new int[args.length];
		for(int i=0;i<a.length;i++){
			a[i] = Integer.parseInt(args[i]);			
		}
		int[] b = new int[args.length]; // Helper array
		System.out.println("Before Sort : ");
		printArray(a);
		mergeSort(a, b, 0, a.length-1);
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
		
	}
	
	private static void printArray(int[] a){
		for(int num : a){
			System.out.print(num + " ");
		}
		System.out.println("");
	}
	
}