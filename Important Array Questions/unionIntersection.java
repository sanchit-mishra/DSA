/*Union Intersection of two sorted array in java*/

import java.util.*;

class unionIntersection{

	static void uniInter(int[] arr1, int[] arr2){
		int i = 0,j = 0,k = 0;
		int[] arr3 = new int[arr1.length + arr2.length];
		List<Integer> intersection = new ArrayList<Integer>();
		/*Union Part*/
		while(i < arr1.length && j < arr2.length){
			while(i < arr1.length-1 && (arr1[i] == arr1[i+1])){ //Corner Case for duplicate value handling.
				i++;
			}
			while(j < arr2.length -1 && (arr2[j] == arr2[j+1])){ //Corner Case for duplicate value handling.
				j++;
			}
			if(arr1[i] < arr2[j]){
				arr3[k++] = arr1[i++];
			}
			else if(arr1[i] == arr2[j]){
				arr3[k++] = arr2[j++];
				i++;
			}
			else{
				arr3[k++] = arr2[j++];
			}
		}
		while(i != arr1.length){                                //Remaining, If any.
			arr3[k++] = arr1[i++];
		}
		while(j != arr2.length){                                //Remaining, If any.
			arr3[k++] = arr2[j++];
		}
		/*Intersection Part*/
		i=0;j=0;
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] > arr2[j]){
				j++;
			}
			else if(arr1[i] == arr2[j]){
				intersection.add(arr1[i++]);
				j++;
			}
			else{
				i++;
			}
		}
		for(i=0; i < intersection.size(); i++){
			System.out.println(intersection.get(i));
		}
		for(k = 0; k < arr3.length; k++){
			System.out.println(arr3[k]);
		}
	}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr1 = new int[no];
		int[] arr2 = new int[no];
		for(int i=0; i < no ; i++){
			arr1[i] = sc.nextInt();
		}
		for(int i=0; i < no ; i++){
			arr2[i] = sc.nextInt();
		}

		uniInter(arr1,arr2);
	}
}