/*Valid Paranthesis LeetCode
TC : O(N)*/

import java.util.*;

class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack = new Stack<Character>();
     String opening = "([{";
     String closing = ")]}";
     HashMap<Character,Character> match = new HashMap<Character,Character>();
        match.put(')','(');
        match.put(']','[');
        match.put('}','{');
    int i = 0;
    if(s.length() == 0){
        return true;
    }
    
        while(i < s.length() ){
            char c = s.charAt(i);
            i++;
            if(opening.indexOf(c)>=0){
                stack.push(c);
            }
            else{
                if(stack.empty()){
                    return false;
                }
                char out = stack.pop();
                if(out != match.get(c)){
                    return false;
                }
              }   
            }
        
    return stack.empty() ? true : false;
    }
}