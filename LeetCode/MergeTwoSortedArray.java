import java.util.*;

class MergeTwoSortedArray{

	static void merge(int[] arr1, int[] arr2){
		for(int i = 0; i < arr1.length; i++){
			if(arr1[i] > arr2[0]){
				int temp = arr2[0];
				arr2[0] = arr1[i];
				arr1[i] = temp;
			}
			Arrays.sort(arr2);
		}
	}

	static void display(int[] arr1, int[] arr2){
		System.out.println("Merged Two Sorted Array: ");

		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}

		for(int i = 0; i < arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
	}
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7, 10};
		int[] arr2 = {4, 8, 9};

		merge(arr1, arr2);
		display(arr1, arr2);
	}
}