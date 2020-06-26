/*Sort two sorted Linked List
TC:O(N).
*/

import java.util.*;

public class SortTwoSLL{
	class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public Node add(Node head, int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return head;
		}
		else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = newNode;
			return head;
		}
	}
	public void display(Node head){
		if(head == null){
			System.out.println("List is empty");
		}
		else{
			Node current = head;
			while(current != null){
				System.out.print("->" + current.data);
				current = current.next;
			}
		}
	}
	public Node merge(Node target, Node source1, Node source2){
		if(source1 == null && source2 != null){  //if one list is null
			return source2;
		}
		else if(source1 != null && source2 == null){
			return source1;
		}
		else{                 
			Node p1 = source1;    // 3 pointer sorting game
			Node p2 = source2;
			Node p3 = null;
			Node next1 = null;
			Node next2 = null;
			if(p1.data < p2.data){ //tricky step: Decide first small.
				p3 = p1;
				target = p3;     
				next1 = p1.next;
				p1.next = null;
				p1 = next1;
			}
			else{
				p3 = p2;
				target = p3;
				next2 = p2.next;
				p2.next = null;
				p2 = next2;
			}
			while(p1 != null && p2 != null){
				if(p1.data < p2.data){
					p3.next = p1;          //connecting 
					next1 = p1.next;       //storing next address
					p1.next = null;        // current next null
					p1 = next1;            //going to next
				}
				else{
					p3.next = p2;
					next2 = p2.next;
					p2.next = null;
					p2 = next2;
				}
			p3 = p3.next;
			}
			while(p1 != null){
				p3.next = p1;
				p1 = p1.next;
				p3 = p3.next;
			}
			while(p2 != null){
				p3.next = p2;
				p2 = p2.next;
				p3 = p3.next;
			}
		return target;
		}
	}
	public static Node headL1 = null;
	public static Node headL2 = null;
	public static Node headSort = null;
	public static void main(String[] args) {
	 	SortTwoSLL l1 = new SortTwoSLL();
	 	SortTwoSLL l2 = new SortTwoSLL();
	 	SortTwoSLL l3 = new SortTwoSLL();

	 		headL1 = l1.add(headL1,1);
	 		headL1 = l1.add(headL1,3);
	 		headL1 = l1.add(headL1,6);
	 		headL1 = l1.add(headL1,10);
	 		headL1 = l1.add(headL1,12);

	 		System.out.println("");
	 		l1.display(headL1);
	 		
	 		System.out.println("");
	 		headL2 = l2.add(headL2,2);
	 		headL2 = l2.add(headL2,4);
	 		headL2 = l2.add(headL2,5);

	 		l2.display(headL2);


	 		headSort = l3.merge(headSort,headL1,headL2); 
	 		System.out.println("");
	 		l3.display(headSort);


	 } 
}