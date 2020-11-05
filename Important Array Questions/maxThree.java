/*Three largest element from an array of distinct elements.
TC:O(N) & SC: O(1)
Note: You can also optimize the solution in O(nlogn) using sorting algorithm & returning last 3 greatest,
but check for same element also at the end ;)*/

import java.util.*;

class maxThree{
	static void maximumThree(int[] arr){
		int max1=0, max2=0, max3=0;
		for(int i=0; i < arr.length; i++){
			if(arr[i] > max1){
				max3 = max2;
				max2 = max1;
				max1 = arr[i];
			}
			else if(arr[i] > max2){
				max3 = max2;
				max2 = arr[i];
			}
			else{
				if(arr[i] > max3){
					max3 = arr[i];
				}
			}
		}
		System.out.println("First Greater:"+max1+ "" + "Second Greater:" + max2 + "" + "Third Greater:"+max3);
	}
	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0; i < no; i++){
			arr[i] = sc.nextInt();
		}

		maximumThree(arr);
	}
}