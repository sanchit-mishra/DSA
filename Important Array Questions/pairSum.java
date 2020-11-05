/*Print all pairs with given sum
The code using HashMap that I have did as one bug,
it will also give copy pairs i.e if there exist a pair(1,5) it will also return (5,1)*/

import java.util.*;

class pairSum{
	static void checkPairSum(int[] arr,int sum){
		// HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

		// for(int i=0; i < arr.length; i++){
		// 	int complement = sum - arr[i];
		// 	hmap.put(arr[i],complement);
		// }
		// for(int i=0; i < arr.length; i++){
		// 	if(hmap.get(arr[i]) != null){
		// 		int value = hmap.get(arr[i]);
		// 	if(hmap.containsKey(value)){
		// 		System.out.println("Pair:"+ arr[i]+value);
		// 		hmap.remove(value);
		// 		}
		// 	}
		// }
		int low = 0; 
		int high = arr.length - 1;

		while(low < high){
			if(arr[low] + arr[high] == sum){
				System.out.println("Pair:("+arr[low] + "" + arr[high]+")");
				
			}
			if(arr[low] + arr[high] > sum){
				high--;
			}
			else{
				low++;
			}
		}
	}
	public static void main(String[] args) {
		int no, sum;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no; i++){
			arr[i] = sc.nextInt();
		}
		sum = sc.nextInt();
		Arrays.sort(arr);
		checkPairSum(arr,sum);
 	}
}