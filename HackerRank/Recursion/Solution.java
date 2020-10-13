import java.io.*;
import java.util.*;

public class Solution {

	static int powerSum(int x, int n, int start){

		int value = (int) Math.pow(start, n);
		if(value < x){
			return powerSum(x,n,start + 1) + powerSum(x - value, n, start + 1);
		}

		if(x == value)
			return 1;
		else
			return 0;
	}


	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);

	int x, n;
	x = sc.nextInt();
	n = sc.nextInt();
	int start = 1;
	int result = powerSum(x,n,start);
	System.out.println(result);
}


}