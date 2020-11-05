/*Factorial of a large number*/


import java.util.*;

class largeFactorial{

	static void fact(int n){
	final int max = 500;
		int[] res = new int[max];
		res[0] = 1;              //Initial result
		int res_size = 1;        //Initial result size

		for(int i=2 ; i <=n; i++){
			res_size = multiply(i,res,res_size);  //For every value call multiply
		}

		for(int i=res_size-1; i >= 0; i--){
			System.out.print(res[i]);             //Print factorial from res array by iterating from last
		}
	}

	static int multiply(int i, int[] res, int res_size){

		int carry = 0;

		for(int j=0; j < res_size; j++){
			int prod = res[j]*i + carry;      //Multiply every array element with value with value i
			res[j] = prod % 10;               //Store unit place of a product before ten's place 
			carry = prod / 10;                //Take the ten's place value in next product multiplicate i.e old school maths
		}

		while(carry != 0){                    //Corner case for the last value if carry remains
			res[res_size] = carry % 10;       //Store unit value at last index
			carry = carry / 10;               //if carry remains continue,
			res_size++;                       //Increase index size;
		}
		return res_size;
	}
	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		no = sc.nextInt();
		fact(no);
	}
}