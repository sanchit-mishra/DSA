/*Simple program to delete a linked List in java
TC: O(1)*/

import java.util.*;

class DeleteSLL{
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
	public Node delete(Node head){
		if(head == null){
			System.out.println("List is already empty");
			return null;
		}
		else{
			head = null;  //Java has automated garbage collections, so make head points -> null;
			return head;
		}
	}
	public static Node head = null;
	public static void main(String[] args) {
		DeleteSLL l1 = new DeleteSLL();

		head = l1.add(head,1);
		head = l1.add(head,2);
		head = l1.add(head,3);
		head = l1.add(head,4);
		
		l1.display(head); 

		head = l1.delete(head);
		if(head == null){
			System.out.println("Linked List Deleted");
		}
	}
}