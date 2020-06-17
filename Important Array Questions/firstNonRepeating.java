/*First Non-Repeating element from an array using HashMap
Store number of occurence and look for occurence equal to 1 in HashMap
TC: O(N) & SC:O(N)*/

import java.util.*;

class firstNonRepeating{

	static int nonRepeating(int[] arr){
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		for(int i=0; i < arr.length;i++){
			if(hmap.containsKey(arr[i])){
				hmap.put(arr[i],hmap.get(arr[i])+1);
			}
			else{
				hmap.put(arr[i],1);
			}
		}
		for(int i=0; i < hmap.size(); i++){
			if(hmap.get(arr[i]) == 1){
				return arr[i];
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
		int first = nonRepeating(arr);
		System.out.println("First repeating Number is :" + first);
	}
}