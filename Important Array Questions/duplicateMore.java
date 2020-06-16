/*Pairs of duplicates numbers in range 0 to n-1*/

import java.util.*;

class duplicateMore{

	static void duplicates(int[] arr){
		// for(int i=0; i < arr.length;i++){
		// 	int index = Math.abs(arr[i]) % arr.length;
		// 	if(arr[index] < 0){
		// 		System.out.print("Duplicate Numbers "+ Math.abs(arr[i]));
		// 	}
		// 	arr[index] = -arr[index];
		// }
		for(int i=0; i < arr.length;i++){
			arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length; //It adds array length if any array value points to that index
		}
		for(int i=0; i < arr.length;i++){
			if(arr[i] >= arr.length*2){    //If value is greter than 10 it means arrays has duplicate number that adding at the same index.
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		int no ;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no; i++){
			arr[i] = sc.nextInt();
		}
		duplicates(arr);
	}
}