import java.util.*;

public class Selection {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array : ");
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			System.out.print("Enter a["+i+"] : ");
			a[i] = in.nextInt();
		}
		System.out.print("Enter the k largest element to search : ");
		int k = in.nextInt();
		assert k<a.length : "Largest element should be less than the size of the array";
		
		System.out.println("");
		System.out.println("Array entered : ");
		printArray(a);
		
		System.out.println(k + "th largest element is " + selection(a, k));
	}
	
	private static int selection(int[] a, int k){
		int low = 0;
		int high = a.length - 1;
		while(high > low){
			int j = partition(a, low, high);
			if(j > k){
				high = j - 1;
			} else if(j < k){
				low = j+1;
			} else {
				return a[k];
			}
		}
		return a[k];
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
	
	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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