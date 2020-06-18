/*Longest Consecutive SubSequence using Hashing
TC: O(N) && SC: O(N)
The same can be done using sorting and linear scan with count(TC: O(nlogn) && SC: O(1))*/

import java.util.*;

class longestConsecutiveSubsequence{

	static int subSequence(int[] arr){

		HashSet<Integer> hs = new HashSet<Integer>();
		int ans = 0, j = 0;
		for(int i=0; i < arr.length; i++){
			hs.add(arr[i]);
		}

		for(int i=0; i < arr.length; i++){
			if(!hs.contains(arr[i]-1)){

				j = arr[i];
				while(hs.contains(j))
					j++;
			

			if(ans < j - arr[i])
				ans = j - arr[i];
		}
	}
	return ans;
}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no; i++){
			arr[i] = sc.nextInt();
		}

		int length = subSequence(arr);
		System.out.println("Longest Consecutive Subsequence:" + "" + length);
	}
}