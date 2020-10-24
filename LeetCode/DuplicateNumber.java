//LeetCode 287
import java.util.*;

class DuplicateNumber{

	public static int findDuplicate(int[] arr){
		int slow = arr[0];
		int fast = arr[0];

		do{
			slow = arr[slow];
			fast = arr[arr[fast]];
		}while(slow != fast);

		fast = arr[0];
		while(slow != fast){
			fast = arr[fast];
			slow = arr[slow];
		}
		return fast;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i = 0; i < n+1; i++){
			arr[i] = sc.nextInt();
		}
		int duplicateNumber = findDuplicate(arr);
		System.out.println(duplicateNumber);
	}
}