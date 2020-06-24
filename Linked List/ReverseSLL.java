/*Java Program to reverse a Single Linked List
TC: O(N) && SC:O(1).*/

import java.util.*;

class ReverseSLL{
	class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public Node addNodeEnd(Node head, int data){
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
				System.out.print("->"+current.data);
				current = current.next;
			}
		}
	}
	public Node reverse(Node head){
		Node prev = null, curr = head, next = null;
		if(head == null){
			System.out.println("List is empty");
			return head;
		}
		else{
			while(curr != null){
				next = curr.next; //Store next address
				curr.next = prev; //Make points to previous 
				prev = curr;      
				curr = next;     //Reallocate
			}
			return prev;
		}
	}
	public static Node head = null;
	public static void main(String[] args) {
		ReverseSLL l1 = new ReverseSLL();

		head = l1.addNodeEnd(head,1);
		head = l1.addNodeEnd(head,2);
		head = l1.addNodeEnd(head,3);
		head = l1.addNodeEnd(head,4);
		head = l1.addNodeEnd(head,5);


		l1.display(head);

		head = l1.reverse(head);
		System.out.println("");
		System.out.println("Reverse Single Linked List");
		l1.display(head);

	}
}