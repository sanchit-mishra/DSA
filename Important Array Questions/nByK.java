/*Given an array of n elements and a integer k,
find all the elements in array appearing more than n by k times.
TC: O(N) && SC: O(N)
You can use sorting of (nlogn) time and then just count the occurrence of all in one traversal*/

import java.util.*;

class nByK{

	static void appearMore(int[] arr, int k){

		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		int more = arr.length / k;
		for(int i=0; i < arr.length; i++){

			if(hmap.containsKey(arr[i])){
				hmap.put(arr[i], hmap.get(arr[i]) + 1);
			}
			else{
				hmap.put(arr[i],1);
			}
		}

		for(Map.Entry mapElement : hmap.entrySet()){

			if(more < (int) mapElement.getValue()){
				System.out.print("Value:" + "" + (int)mapElement.getKey());
			}
		}
	}


	public static void main(String[] args) {
		int no, k;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		k = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no; i++){
			arr[i] = sc.nextInt();
		}
		appearMore(arr,k);
	}
}