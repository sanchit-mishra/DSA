/*Largest contiguous sum subArray using kadane algorithm,
very simple algorithm that look for positive conitguous sum
TC: O(N) && SC:O(1) */


import java.util.*;

class kadaneAlgo{

	static void largestSumContiguousSubArray(int[] arr){
		int start = 0,s = 0, end = 0;
		int currentMax = 0, max = 0;
		for(int i = 0; i < arr.length;i++){

			currentMax += arr[i];
			if(currentMax > max){
				max = currentMax;
				start = s;
				end = i;
			}
			else if(currentMax <= 0){
				currentMax = 0;
				s = i+1;
			}
		}
		System.out.println("Max:" + max + "Start index:" + start + "End Index:" + end);	
	}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no; i++){
			arr[i] = sc.nextInt();
		}
		largestSumContiguousSubArray(arr);
	}
}