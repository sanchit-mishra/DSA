/*Leetcode Problem: Easy
Reverse Integer (with a twist to check for 32bit integer overflow)*/


import java.util.*;

class ReverseInteger {
    public static int reverse(int x) {
    int rev = 0;
    if(x%10 == 0){
               x = x / 10;
    }
        while(x!=0){
           
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && x > Integer.MAX_VALUE%10)) return 0; 
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && x < Integer.MIN_VALUE%10)) return 0; 
            int temp = x % 10;
            rev = rev*10 + temp;
            x = x / 10;  
        }
        return rev;
    }
    public static void main(String[] args) {
      int no;
      Scanner sc = new Scanner(System.in);
      no = sc.nextInt();
      int rev = reverse(no);
      System.out.println(""+rev);
    }
}