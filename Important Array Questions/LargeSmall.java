//Simple Java Program to get largest and smallest number from unsorted integer array.
import java.util.*;

class LargeSmall{

	static int[] findSmallLarge(int arr[]){
		int result[] = new int[2];
		int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE; //Constant of Integer class in java.lang package.
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
			if(arr[i] < min){
				min = arr[i];
			}
		}
		result[0] = max;
		result[1] = min;
		return result;
	}


	public static void main(String args[]){
		int arr[] = new int[7];
		Scanner sc = new Scanner(System.in);

		for(int i=0; i < 7; i++){
			arr[i] = sc.nextInt();
		}
		int result[] = new int[2];
		result = findSmallLarge(arr);
		System.out.println("Largest and Smallest numbers are: ");
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}
}