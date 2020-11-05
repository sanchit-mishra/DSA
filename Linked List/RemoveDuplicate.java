/*Program to delete duplicated from a Single Linked List.
TC:O(N) && SC:O(N)
My Own Logic :> */

import java.util.*;

class RemoveDuplicate{
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
	public Node removeDup(Node head){
		if(head == null){
			System.out.println("List is empty");
			return head;
		}
		else{
			boolean visit[] = new boolean[100];  //Boolean array to store seen status.
			Node current = head;
			Node prev = null;                    //previous of the current element of which node has to be deleted.
			Node next = null;                    //To store address of deleted next element
			while(current != null){
				if(visit[current.data] == true){  
					prev.next = current.next;    //make previous to point current ahead.
					next = current.next;         
					current.next = null;        //mark current null.
				}
				else{
					visit[current.data] = true;  //Mark visited
					prev = current;
					next = current.next;
				}
				current = next;                  //relocate address;
			}
		}
		return head;
	}
	public static Node head = null;
	public static void main(String[] args) {
		RemoveDuplicate l1 = new RemoveDuplicate();
		head = l1.addNodeEnd(head,1);
		head = l1.addNodeEnd(head,2);
		head = l1.addNodeEnd(head,3);
		head = l1.addNodeEnd(head,7);
		head = l1.addNodeEnd(head,6);
		head = l1.addNodeEnd(head,6);
		head = l1.addNodeEnd(head,7);
		head = l1.addNodeEnd(head,3);


		l1.display(head);
		System.out.println("");
		head = l1.removeDup(head);
		System.out.println("After Removing Duplicate");
		l1.display(head);
	}
}