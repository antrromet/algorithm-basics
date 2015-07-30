import java.util.*;

public class LinearSearch {
	
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
		
		int foundIndex = linearSearch(a, x);
		if(foundIndex == -1){
			System.out.println(x + " not found");
		}else{
			System.out.println(x + " found at index " + foundIndex);
		}
	}
	
	private static int linearSearch(int[] a, int x){
		for(int i=0;i<a.length;i++){
			if(a[i] == x){
				return i;
			}
		}
		return -1;
	}
	
	private static void printArray(int[] a){
		for(int i=0;i<a.length-1;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
}