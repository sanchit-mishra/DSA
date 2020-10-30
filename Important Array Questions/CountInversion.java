import java.util.*;

public class CountInversion{

	static int merge(int[] array, int[] temp, int low, int mid, int high){
		
		int i, j, k;
		int countInversion = 0;

		i = low;
		j = mid;
		k = low;
		while((i <= mid - 1) && (j <= high)){
			if(array[i] <= array[j]){
				temp[k++] = array[i++];
			}else{
				temp[k++] = array[j++];
				countInversion += (mid - i);
			}
		}

		while(i <= mid - 1)
			temp[k++] = array[i++];

		while(j <= high)
			temp[k++] = array[j++];

		for(i = low; i <= high; i++)
			array[i] = temp[i];

		return countInversion;
	}


	static int mergeSort(int[] array, int[] temp, int low, int high){
		int mid = (low+high) / 2;

		int countInversion = 0;
		if(low < high){

			countInversion += mergeSort(array, temp, low, mid);
			countInversion += mergeSort(array, temp, mid + 1, high);

			countInversion += merge(array, temp, low, mid + 1, high);

		}
		return countInversion;
	}


	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int arraySize = sc.nextInt();

		int[] array = new int[arraySize];
		int[] tempArray = new int[arraySize];

		for(int i = 0; i < arraySize; i++){
			array[i] = sc.nextInt();
		}

		int count = mergeSort(array, tempArray, 0, array.length - 1);
		System.out.println("Count Inversion: " + count);
	}
}