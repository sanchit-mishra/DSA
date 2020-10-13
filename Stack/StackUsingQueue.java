import java.util.*;

class StackUsingQueue{

	static void push(Queue<Integer> q1, Queue<Integer> q2, int no){
		if(!q1.isEmpty()){
			while(!q1.isEmpty()){
				q2.add(q1.peek());
				q1.remove();
			}
		}
		q1.add(no);
		while(!q2.isEmpty()){
			q1.add(q2.peek());
			q2.remove();
		}
	}

	static int pop(Queue<Integer> q1){
		int popElement = q1.peek();
		q1.remove();
		return popElement;
	}

	public static void main(String args[]){
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();


		push(q1,q2,1);
		push(q1,q2,2);
		push(q1,q2,3);
		push(q1,q2,4);
		push(q1,q2,5);

		int[] reverse = new int[q1.size()];
		for(int i = 0; i < 5; i++){
			reverse[i] = pop(q1);
		}
		for(int i = 0; i < reverse.length; i++){
			System.out.print(reverse[i] + " ");
		}
	}
}