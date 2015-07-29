import java.util.*;

public class BinarySearch {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter a["+i+"] : ");
			a[i] = in.nextInt();
		}
		System.out.print("Enter the element to search : ");
		int x = in.nextInt();
		
		System.out.println("");
		System.out.println("Array entered : ");
		printArray(a);
		assert isSorted(a) : "Array not sorted and hence Binary Search cannot be performed";
		
		System.out.println("--------------------------------SEARCHING--------------------------------");
		//int foundIndex = binarySearchRecursive(a, x, 0, n-1);
		int foundIndex = binarySearch(a, x);
		System.out.println("-----------------------------SEARCH FINISHED-----------------------------");
		if(foundIndex == -1){
			System.out.println(x + " not found");
		}else{
			System.out.println(x + " found at index " + foundIndex);
		}
	}
	
	private static int binarySearch(int[] a, int x){
		int low = 0;
		int high = a.length - 1;
		while(high >= low){
			System.out.print("Searching in ");
			printArray(a, low, high);
			int mid = (high + low)/2;
			if(a[mid] == x){
				return mid;
			} else if(x > a[mid]){
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	private static int binarySearchRecursive(int[] a, int x, int low, int high){
		System.out.print("Searching in ");
		printArray(a, low, high);
		if(high >= low){
			int mid = (high + low)/2;
			if(a[mid] == x){
				return mid;
			} else if(x > a[mid]){
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			return binarySearchRecursive(a, x, low, high);
		}
		return -1;	
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
		for(int i=1;i<a.length;i++){
			if(a[i] < a[i-1]){
				return false; // Return false even if one condition fails
			}
		}
		return true; // Return true otherwise
	}
	
}