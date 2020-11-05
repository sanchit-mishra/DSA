/*Find nth node from the end in SLL
TC:O(N) && SC:O(1).*/

import java.util.*;

class NthNodeLast{
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
		Node current = head;

		if(head == null){
			System.out.println("List is empty");
		}
		else{
			while(current != null ){
				System.out.print("->"+current.data);
				current = current.next;
			}
		}
	}
	public static int nTH(Node head, int pos){
		if(head == null){
			System.out.println("List is empty");
			return -1;
		}
		else{
			Node forward = head;    //Move forward to nth node position from end-1 time.
			while(pos-1 > 0){
				forward = forward.next;
				pos--;
			}
			Node backward = head;
			while(forward.next != null){  //move forward & backward at same speed i.e 1 time, till forward reaches at the end.
				forward = forward.next;
				backward = backward.next;
			}
			return backward.data;     // This will point to the node we want.
		}
	}
	public static Node head = null;
	public static void main(String[] args) {
		NthNodeLast l1 = new NthNodeLast();

		head = l1.add(head,1);
		head = l1.add(head,3);
		head = l1.add(head,4);
		head = l1.add(head,8);
		head = l1.add(head,10);
		head = l1.add(head,11);

		l1.display(head);

		System.out.println("Enter the nth pos from the end");
		Scanner sc = new Scanner(System.in);
		int pos = sc.nextInt();

		int nodeData = l1.nTH(head,pos);
		System.out.println("Node data: " + nodeData);

	}
}