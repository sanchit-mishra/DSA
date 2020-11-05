/*Program to return maximum sum from subarray of size k
First Compute first sum of size k store it in order variable(window_size),
then using sliding window techniques add next element and remove first element,
Compare maximum of new maxsum & old maxsum and store which ever is maximum in old maxsum*/

import java.util.*;

class maxSub{
	
	static int maxSubArray(int[] arr, int k){
		int max_sum = 0;
		for(int i=0; i < k ; i++){
			max_sum += arr[i];
		}

		int window_sum = max_sum;
		for(int i=k; i<arr.length;i++){
			window_sum += arr[i]-arr[i-k];
			max_sum =  Math.max(window_sum,max_sum);

		}
		return max_sum;
	} 


	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int arr[] = new int[no];
		for(int i=0; i<no;i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int max = maxSubArray(arr,k);
		System.out.println("Maximum Sub array:"+ max);
	}
}