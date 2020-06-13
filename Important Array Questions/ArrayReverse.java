import java.util.*;

class ArrayReverse{
	
	static void reverse(int[] arr,int start,int end){
		int temp = 0;
		while(start < end){
			temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			start++;
			end--;
		}
		for(int i = 0; i < arr.length;i++){
			System.out.print(""+ arr[i]);
		}
	}
	

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int arr[] = new int[no];
		for(int i=0;i<arr.length;i++){
			arr[i] = sc.nextInt();
		}
		int end = arr.length-1;
		int start = 0;
		reverse(arr,start,end);	
	}
}