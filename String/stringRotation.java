/* String Rotation whether one string is rotation of others
TC: O(1).*/

import java.util.*;

class stringRotation{

	static Boolean isStringRotated(String str1,String str2){

		return ((str1.length() == str2.length()) && ((str1+str1).indexOf(str2) != -1));

	}

	public static void main(String[] args) {
		String str1, str2;
		Scanner sc = new Scanner(System.in);
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		Boolean result = isStringRotated(str1,str2);
		System.out.println("String Rotation Answer: " + result);
	}
}