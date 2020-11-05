// Java Program to find duplicates in unsorted array within k range.
// 1) Naive Approach: Pick an element check for k distance, TC : O(n.k) && SC : O(1).
// 2) Optimal Approach: Use HashMap/HashSet and remove element after k distance. TC: O(N) && SC: O(N). 
import java.util.*;

class DuplicateRange{

	static void findInRange(int arr[], int k){
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		for(int i = 0; i < arr.length; i++){
			//If present , Duplicate is in "k" distance.
			if(hmap.containsKey(arr[i]))
				System.out.print(arr[i] + " ");
			hmap.put(arr[i],i);

			//Checking for "k" distance.
			if(i >= k){
				hmap.remove(arr[i-k]);
			}
		}
	}


	public static void main(String args[]){
		int arr[] = new int[7];
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < 7; i++){
			arr[i] = sc.nextInt();
		}
		findInRange(arr,3);
	}
}