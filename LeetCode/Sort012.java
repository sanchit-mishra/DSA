//LeetCode:- 75. Sort 0's, 1's, 2's [Dutch Flag Algorithm]
// arr[0..low-1] = 0;
// arr[high+1..] = 2;
// arr[low..mid-1] = 1;
import java.util.*;

class Sort012{
	
	static void display(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

	static void sort(int[] arr){
		int low = 0, mid = 0;
		int high = arr.length - 1;

		for(int i = 0; i < arr.length; i++){
			if(arr[mid] == 0){
				int value = arr[mid];
				arr[mid] = arr[low];
				arr[low] = value;
				mid++;
				low++;
			}
			else if(arr[mid] == 1){
				mid++;
			}
			else{
				int value = arr[mid];
				arr[mid] = arr[high];
				arr[high] = value;
				high--;
			}
		}
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n;

		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}

		System.out.println("Array Before Sorting");
		display(arr);

		sort(arr);
		System.out.println();

		System.out.println("Array After Sorting");
		display(arr);
	}
} 