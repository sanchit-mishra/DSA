/*Minimum element in a rotated sorted array using Binary Search approach
TC: O(N) && SC:O(1)*/


import java.util.*;

class minSortedRotated{

	static int findMinimum(int[] arr){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			if(arr[low] < arr[high]){
				high--;
			}
			else if(arr[low] > arr[high]){
				low++;
			}
			if(low == high){
				return arr[low];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no; i++){
			arr[i] = sc.nextInt();
		}
		int minimum = findMinimum(arr);
		System.out.println("Minimum Element in a rotated sorted array is:"+minimum);
	}
}