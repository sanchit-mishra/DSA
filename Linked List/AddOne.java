/* Add 1 to number represented by Linked List.
TC:O(N) && SC:O(1)
*/

import java.util.*;

class AddOne{
	class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
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
	public Node add(Node head, int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return head;
		}
		else{
			newNode.next = head;
			head = newNode;
			return head;
		}
	}
	public Node reverse(Node head){
		if(head == null){
			return head;
		}
		else{
			Node current = head;
			Node prev = null;
			Node next = null;
			while(current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
		}
	}
	public Node addOne(Node head, int data){
		int carry = 0;
		if(head == null){
			return head;
		}
		else{
			Node current = head;
			while(current != null){
				current.data += data;   //add data
				if(current.data < 10){  // if less than 10 return as it is.
					return head;
				} 
				else{                         //traverse and add carry untill data < 10 i.e No carry chance.
					data = current.data / 10;
					current.data = current.data % 10;
					current = current.next;
				}
			}
		}
		return head;
	}
	public static Node head = null;
	public static void main(String[] args) {
		AddOne l1 = new AddOne();

		head = l1.add(head,9);
		head = l1.add(head,9);
		head = l1.add(head,9);
		head = l1.add(head,1);

		l1.display(head);
		System.out.println("");
		
		head = l1.reverse(head);
		
		System.out.println("After adding 1");
		System.out.println("");
		
		head = l1.addOne(head,1);
		head = l1.reverse(head);
		l1.display(head);


	}
}