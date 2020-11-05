/*Using two pointers, if found 0 increment left pointer,
if found 1 decrement right pointer which points at n-1 position
Compare if found greater then swap*/

import java.util.*;

class ZeroOne{

	static void sortZeroOne(int[] arr){

		int l = 0;
		int r = arr.length-1;

		while(l < r){
			if(arr[l] > arr[r]){
			int	temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
			}
			if(arr[l]==0){
				l++;
			}
			if(arr[r]==1){
				r--;
			}

		}
		for(int i=0; i < arr.length ; i++){
			System.out.println(""+arr[i]);
		}

	}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i=0;i<no;i++){
			arr[i] = sc.nextInt();
		}

		sortZeroOne(arr);
	}
}