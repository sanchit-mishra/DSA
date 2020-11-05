import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class BTree{
	public class Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public Node insert(Node root, int data){
		Node newNode = new Node(data);

		if(root == null){
			root = newNode;
			return root;
		}
		Node temp = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);
		while(!q.isEmpty()){
			temp = q.peek();
			q.remove();

			if(temp.left == null){
				temp.left = newNode;
				break;
			}
			else{
				q.add(temp.left);
			}
			if(temp.right == null){
				temp.right = newNode;
				break;
			}
			else{
				q.add(temp.right);
			}
		}
		return root;
	}
	public Node delete(Node root, int key){
		if(root == null){
			return null;
		}

		if(root.right == null && root.left == null){
			if(root.data == key){
				return null;
			}
			else{
				return root;
			}
		}

		Node temp = root;
		Queue<Node> q = new LinkedList<Node>();
		Node keyNode = null;
		q.add(temp);
		while(!q.isEmpty()){
			temp = q.peek();
			q.remove();

			if(temp.data == key){
				keyNode = temp;
			}
			if(temp.right != null){
				q.add(temp.right);
			}
			if(temp.left != null){
				q.add(temp.left);
			}
		}
		if(keyNode != null){
			int x = temp.data;
			deleteDeepest(root,temp);
			keyNode.data = x;
		}
		return root;
	}
	public Node deleteDeepest(Node root, Node deep){
		Queue<Node> q = new LinkedList<Node>();
		Node temp = root;
		q.add(temp);

		while(!q.isEmpty()){
			temp = q.peek();
			q.remove();

			if(temp == deep){
				temp = null;
				return root;
			}

			if(temp.left != null){
				if(temp.left == deep){
					temp.left = null;
					return root;
				}
				else{
					q.add(temp.left);
				}
			}
			if(temp.right != null){
				if(temp.right == deep){
					temp.right = null;
					return root;
				}
				else{	
					q.add(temp.right);
				}
			}
		}
		return root;
	}
	public void inOrder(Node temp){
		if(temp == null){
			return;
		}

		inOrder(temp.left);
		System.out.print(temp.data+"->");
		inOrder(temp.right);

	}
	public void preOrder(Node temp){
		if(temp == null){
			return;
		}

		System.out.print(temp.data+"->");
		preOrder(temp.left);
		preOrder(temp.right);
	}
	public void postOrder(Node temp){
		if(temp == null){
			return;
		}

		postOrder(temp.left);
		postOrder(temp.right);
		System.out.print(temp.data+"->");
	}
	public Boolean search(Node temp, int key){
		if(temp == null){
			return false;
		}
		
		if(temp.data == key){
				return true;
		}

		boolean leftAns	= search(temp.left,key);
		if(leftAns) return true;
		boolean rightAns = search(temp.right,key);

		return rightAns;
	}
	public void getMinMax(Node temp){
		if(temp == null){
			System.out.println("Tree is Empty");
		}
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Queue<Node> q = new LinkedList<Node>();
		q.add(temp);

		while(!q.isEmpty()){
			temp = q.peek();
			q.remove();

			if(temp.data < min){
				min = temp.data;
			}
			if(temp.data > max){
				max = temp.data;
			}
			if(temp.left != null){
				q.add(temp.left);
			}
			if(temp.right != null){
				q.add(temp.right);
			}
		}
		System.out.print("Minimum Element->"+min+ " Maximum Element->" + max);
	}
	public int getHeight(Node root){
		if(root == null){
			return 0;
		}

		int lheight = getHeight(root.left);
		int rheight = getHeight(root.right);

		if(lheight > rheight){
			return lheight+1;
		}
		else{
			return rheight+1;
		}
		
	}
	public static Node root = null;
	public static void main(String[] args) {
		BTree b1 = new BTree();

		root = b1.insert(root,1);
		root = b1.insert(root,22);
		root = b1.insert(root,23);
		root = b1.insert(root,11);

		b1.inOrder(root);

		root = b1.delete(root,23);
		System.out.println("");
		b1.inOrder(root);

		System.out.println("");
		b1.preOrder(root);

		System.out.println("");
		b1.postOrder(root);

		Boolean result = b1.search(root,11);
		if(result){
			System.out.println("Element Found");
		}
		else{
			System.out.println("Element not found");
		}

		b1.getMinMax(root);
		int height = b1.getHeight(root);
		System.out.println("Height of the tree: "+height);
	}
}