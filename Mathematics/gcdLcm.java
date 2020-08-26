/*Approach is to find first two gcd and then recursively call for others */

import java.util.*;

class gcdLcm{
	//Eucliedean Algorithm 
	static int gcdArray(int a, int b){
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		return gcdArray(b%a, a);
	}
	//Through gcd
	static int lcm(int a, int b){
		return (a*b)/gcdArray(a,b);
	}

	/*Another Approach*/
	/*static int lcm(int a, int b){
		int lar = Math.max(a,b);
		int small = Math.min(a,b);
		for(int i=lar ;; i += lar){
			if(i % small == 0){
				return i;
			}
		}
	}*/
	public static void main(String[] args){
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();

		int[] arr = new int[no];
		for(int i = 0; i < arr.length; i++){
			arr[i] = sc.nextInt();
		}
		int res = arr[0];
		for(int i=1; i < arr.length; i++){
			res = gcdArray(res,arr[i]);  
		}
		System.out.println("GCD of array: " + res);

		int a = 10, b = 20;
		int lcmRes = lcm(a,b);
		System.out.println("LCM of two number: "+lcmRes);
		
		res = arr[0];
		for(int i=0; i < arr.length; i++){
			res = lcm(res,arr[i]);
		}

		System.out.println("LCM of an array: " + res);

	}
}