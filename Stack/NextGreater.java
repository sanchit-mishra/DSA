//Find Next Greater Element for every element in array.
import java.util.*;

class NextGreater{
	
	static void nextGreaterElement(Stack<Integer> s, int[] arr){
		int next;
		int pop;
		if(s.isEmpty()){
			s.push(arr[0]);
		}
		
		for(int i = 1; i < arr.length; i++){
			next = arr[i];

			if(!s.isEmpty()){
				pop = s.pop();
			

				while(pop < next){
					System.out.print(pop + " ----> " + next);
					if(s.isEmpty())
						break;
					pop = s.pop();
				}

				if(pop > next)
					s.push(pop);
			}
		
		s.push(next);
	}
	while(!s.isEmpty()){
		int element = s.pop();
		System.out.print(" " + element + " ----> " + "-1");
	}
}

	public static void main(String args[]){
		int no;
		Scanner sc = new Scanner(System.in);

		no = sc.nextInt();
		int[] arr = new int[no];

		for(int i = 0; i < no; i++){
			arr[i] = sc.nextInt();
		}

		Stack<Integer> s = new Stack<Integer>();

		nextGreaterElement(s,arr);
	}
}