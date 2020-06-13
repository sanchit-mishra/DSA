/*As all the values in the array are from 1 to n,
use the indexing technique so that when you subtract 
value of any element and if its duplicate it will 
point to the same index, so just make the number negative
and if you reach there again BOOM!! you catch the duplicate.*/

import java.util.*;

class duplicate{
	
	static void duplicateNumbers(int[] arr){

		for(int i=0;i<arr.length;i++){

		int index = Math.abs(arr[i]) - 1;
		if(arr[index] < 0){
			System.out.print(Math.abs(arr[i]));
		}
		arr[index] = -arr[index];
		} 
	}


	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no ; i++){
			arr[i] = sc.nextInt();
		}
		duplicateNumbers(arr);
	}
}

