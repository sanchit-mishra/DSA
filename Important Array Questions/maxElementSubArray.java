/*Program to return maximum element from subarray of size k
Using Sliding Window Technique, store maximum */

import java.util.*;

class maxElementSubArray{

	static void maxOfSubArray(int[] arr, int k){
		int max = 0;
		// for(int i =0; i<arr.length-k+1;i++){
			
		// 	for(int j=i; j<k+i;j++){
		// 		if(arr[j]>max){
		// 			max = arr[j];
		// 		}
		// 	}
		// 	System.out.println("Max"+max);
		// } O(N2)

		for(int i=0;i < arr.length;i++){
			if(arr[i] > max){
				max = arr[i];
			}
			if(i==k-1){
				System.out.println(""+max);
				k++;
			}
		}

	}

	public static void main(String[] args) {
		int no;
		int k;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		k = sc.nextInt();
		int arr[] = new int[no];
		for(int i =0; i<no;i++){
			arr[i]= sc.nextInt();
		}

		maxOfSubArray(arr,k);

	}
}