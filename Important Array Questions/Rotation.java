	/*For juggling algorithm watch on Youtube ;>*/

	import java.util.*;

	class Rotation{

	public static void arrRotate(int[] arr, int n, int k){
		/* Simple Approach
	int[] temp = new int[k];
	for(int i = 0 ; i<k; i++){
		temp[i] = arr[i];
	}

	for(int i = k; i < arr.length; i++){
		arr[i-k]= arr[i];
	}
	for(int i = arr.length-k,j=0; i < arr.length; i++,j++){
		arr[i] = temp[j];
	}

	for(int i  = 0; i<arr.length;i++){
		System.out.println(""+arr[i]);
	}
		*/

	/*
	int temp = 0;

	while(k>0){
	temp = arr[0];
	for(int i = 1; i<arr.length;i++){
		arr[i-1] = arr[i];
	}
	arr[arr.length-1] = temp;
	k--;
	}

	for(int i = 0; i<arr.length;i++){
		System.out.println(""+arr[i]);
	} 
			O(N*K)*/

	/*  Juggling Algorithm*/

	int d=-1, temp = 0,j;
	for(int i= 0; i < gcd(n,k); i++){
	j=i;
	 temp = arr[j];
	 while(true){
	 	d = (j+k)%n;

	 	if(d==i)
	 		break;

	 	arr[j] = arr[d];
	 	j=d;
	 }
	 arr[j]=temp;
	}

	for(int i = 0; i<arr.length;i++){
		System.out.println(""+arr[i]);
	}

	}

	static int gcd(int n, int k){
		if(k==0)
			return n;
		else
			return gcd(k,n%k);
	}

	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		int[] arr = new int[no];
		for(int i = 0; i < no; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int n = arr.length;
		arrRotate(arr,n,k);

	}
	}