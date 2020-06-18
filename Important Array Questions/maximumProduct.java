/*Maximum Product Subarray
TC: O(N) && SC: O(1) */

import java.util.*;

class maximumProduct{
	
	static int maxProduct(int[] arr){
		int final_max = arr[0];
		int previous_max = arr[0];
		int previous_min = arr[0];
		int current_max, current_min;

		for(int i=1; i < arr.length; i++){

			current_max = Math.max(Math.max(previous_max*arr[i],previous_min*arr[i]),arr[i]);
			current_min = Math.min(Math.min(previous_max*arr[i],previous_min*arr[i]),arr[i]);

				previous_max = current_max;
				previous_min = current_min;
			
			final_max = Math.max(final_max,current_max);
		}
		return final_max;
	}


	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no ; i++){
			arr[i] = sc.nextInt();
		}
		int maximum = maxProduct(arr);
		System.out.println("Maximum SubArray Product is :" + "" + maximum);
	}
}