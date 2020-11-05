/*Function to move last element to first element in SLL
TC:O(N) && SC:O(1).
*/
import java.util.*;

class MakeLastAsFirst{
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
public Node makeLastAsFirst(Node head){
	if(head == null){
		return head;
	}
	else{
		Node current = head;
		Node prev = null;
		while(current.next != null){
			prev = current;
			current = current.next;
		}
		prev.next = null;
		current.next = head;
		head = current;
		return head;
	}
}
	public static Node head = null;
	public static void main(String[] args) {
	
	MakeLastAsFirst l1 = new MakeLastAsFirst();

		head = l1.add(head,4);
		head = l1.add(head,3);
		head = l1.add(head,2);
		head = l1.add(head,1);

		l1.display(head);

		head = l1.makeLastAsFirst(head);
		l1.display(head);
	}
}