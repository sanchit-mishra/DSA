/*Compare elements between both array, find smallest
add it to the the new array and increment the index of that array
from where element is picked up, do the operation untill any of it reaches end,
then simply put remaining elements in the new array*/

import java.util.*;

class merge{

	static void mergeArray(int[] arr1, int[] arr2){

	int[] arr3 = new int[arr1.length + arr2.length];
	int i=0,j=0,k=0;
	while(i < arr1.length && j < arr2.length){

		if(arr1[i] < arr2[j]){
			arr3[k] = arr1[i];
			k++;
			i++;
		}
		else{
			arr3[k] = arr2[j];
			k++;
			j++;
		}

	}
	while(i < arr1.length){
		arr3[k] = arr1[i];
		k++;
		i++;
	}
	while(j < arr2.length){
		arr3[k] = arr2[j];
		k++;
		j++;
	}

	for(i=0; i < arr3.length; i++){
			System.out.print("\t"+arr3[i]);
		}

	}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr1 = new int[no];
		int[] arr2 = new int[6];
		for(int i=0; i < no; i++){
			arr1[i] = sc.nextInt();
		}
		for(int i=0; i < 6; i++){
			arr2[i] = sc.nextInt();
		}

		mergeArray(arr1,arr2);
	}
}