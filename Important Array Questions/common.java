/*Common elements in three sorted array, Use the intersection technique
TC: O(N) & SC: O(N) Note: Space complexity can also be made constant O(1),
if simply just print the common element instead of storing */

import java.util.*;

class common{

	static void commonInThree(int[] arr1, int[] arr2, int[] arr3, List<Integer> same){

		int i=0,j=0,k=0;

		while(i < arr1.length && j < arr2.length && k < arr3.length){
		if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
			same.add(arr1[i]);
			i++; j++; k++;
		}
		else if(arr1[i] < arr2[j]){
			i++;
		}
		else if(arr2[j] < arr3[k]){
			j++;
		}
		else{
			k++;
		}
		}

	}
	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr1 = new int[no];
		int[] arr2 = new int[no];
		int[] arr3 = new int[no];
		List<Integer> same = new ArrayList<Integer>();
		for(int i=0; i < no; i++){
			arr1[i] = sc.nextInt();
		}
		for(int i=0; i < no; i++){
			arr2[i] = sc.nextInt();
		}
		for(int i=0; i < no; i++){
			arr3[i] = sc.nextInt();
		}

		commonInThree(arr1,arr2,arr3,same);
		for(int i=0; i < same.size(); i++){
			System.out.println(same.get(i));
		}
	}
}