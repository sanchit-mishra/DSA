/* Java program for nth node in-order traversal. */

import java.util.*;

class NthNodeInTraversal{
	class Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public void seeInorder(Node root){
		if(root == null){
			return;
		}

		seeInorder(root.left);
		System.out.print(root.data+"->");
		seeInorder(root.right);
	}
	public Node add(Node root, int data){
		Node newNode = new Node(data);

		if(root == null){
			root = newNode;
			return root;
		}
		Node temp = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);

		while(q.size() > 0){
			temp = q.peek();
			q.remove();

			if(temp.left != null){
				q.add(temp.left);
			}
			else{
				temp.left = newNode;
				break;
			}

			if(temp.right != null){
				q.add(temp.right);
			}
			else{
				temp.right = newNode;
				break;
			}

		}
		return root;
	}
	public void nthInorder(Node temp, int count){
		if(temp == null){
			return;
		}
		if(track <= count){
			nthInorder(temp.left, count);
			track++;
			if(count == track){
				System.out.println("Data at Node " + count + " is: " + temp.data);
			}
			nthInorder(temp.right,count);

		}
		
	}
	static int track = 0;  // to track visit.
	public static Node root = null;
	public static void main(String[] args) {
		NthNodeInTraversal l1 = new NthNodeInTraversal();

		root = l1.add(root,1);
		root = l1.add(root,2);
		root = l1.add(root,3);
		root = l1.add(root,4);
		root = l1.add(root,5);
		root = l1.add(root,6);

		l1.seeInorder(root);

		System.out.println("");

		l1.nthInorder(root,4);
	}
}