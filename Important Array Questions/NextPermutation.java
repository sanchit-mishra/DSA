import java.util.*;

public class NextPermutation{

	static void displayPermutation(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	static void swap(int[] array, int pos1, int pos2){
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}

	static void reverse(int[] array, int low, int high){
		while(low < high)
			swap(array, low++, high--);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = sc.nextInt();
		int[] array = new int[length];

		for(int i = 0; i < length; i++){
			array[i] = sc.nextInt();
		}

		System.out.println("Current Permutation: ");
		displayPermutation(array);

		if(array == null || array.length <= 1)
			return;

		int i = array.length - 2;
		while(i >= 0 && array[i] >= array[i+1]) //To find index having value at that position less than previous one from backward i.e a[i] < a[i+1]
			i--;
		if(i >= 0){
			int j = array.length - 1;
			while(array[j] <= array[i]) //Find index having value at that position > than the one at above index.
				j--;
			swap(array, i, j);  //Swap Them.
		}
		reverse(array, i+1, array.length - 1);

		System.out.println("Next Permutation: ");

		displayPermutation(array);
	}
}












