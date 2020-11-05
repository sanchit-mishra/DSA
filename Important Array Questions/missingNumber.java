/*Array of distinct n-1 integers, find the missing number in range from 1 to n.*/

import java.util.*;

class missingNumber{

		static	int missing(int[] arr){
		// HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		// 		for(int i=0; i < arr.length; i++){
		// 			int complement = arr.length - arr[i];
		// 			hmap.put(arr[i],complement);
		// 		}
		// 		for(int i=0; i < arr.length;i++){
		// 			int value = hmap.get(arr[i]);
		// 			if(!hmap.containsKey(value)){
		// 				return value;
		// 			}
		// 		}
		// 	return -1;

			int x1 = arr[0];
			int x2 = 1;
			for(int i=1; i < arr.length;i++){
				x1 ^= arr[i];
			}
			for(int i=2; i < arr.length+1; i++){
				x2 ^= i;
			}
			return(x1^x2);
		}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i = 0; i < no-1 ; i++){
			arr[i] = sc.nextInt();
		}

		int ans = missing(arr);
		System.out.println("Missing Number is:" + ans);
	}
}