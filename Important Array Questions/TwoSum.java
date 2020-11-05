//Unsorted array find all pair that sums up with the given sum "k".
//TC : O(N) SC:O(N).
import java.util.*;

class TwoSum{

	static ArrayList<Integer> pair(int arr[], int sum){
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		ArrayList<Integer> pairArray = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(hmap.containsKey(sum - arr[i])){  //Check Complement
				pairArray.add(hmap.get(sum - arr[i]));
				pairArray.add(i);
			}else{
				hmap.put(arr[i],i);              //add current element
			}
		}
		return pairArray;
	}


	public static void main(String args[]){
		int arr[] = new int[7];
		Scanner sc = new Scanner(System.in);

		for(int index = 0; index < 7; index++){
			arr[index] = sc.nextInt();
		}
		ArrayList<Integer> result;
		result = pair(arr,5);
		for(int i = 0; i < result.size(); i++){
			System.out.print(result.get(i) + " ");
		}
	}
}