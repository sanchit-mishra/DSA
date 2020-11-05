import java.util.*;

class MissingNumber{

	static int find(int arr[]){
		int realSum = arr[0], requiredSum = 1;
		//Taking XOR of 1 to 100;
		for(int i = 2; i <= 100; i++){
			requiredSum ^= i;
		}
		//Taking XOR of the whole array	
		for(int i = 1; i < arr.length; i++){
			realSum ^= arr[i];
		}
		return realSum ^ requiredSum;
	}


	public static void main(String args[]){
		int arr[] = new int[99];
		Scanner sc = new Scanner(System.in);

		System.out.println("Entering Number Automatically ..");

		for(int i=0; i < 99; i++){
			if(i == 49){
				arr[i] = 100;
			}
			else{
				arr[i] = i+1;
			}
		}

		// System.out.println("");
		// for(int i = 0; i < 99; i++){
		// 	System.out.print(arr[i] + " ");
		// }

		System.out.println("Find the Missing Number: ");
		int missNumber = find(arr);
		System.out.println("The Missing Number is : " + missNumber);
	}
}