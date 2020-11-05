/* Diagonal Traversal of Binary Tree */

import java.util.*;

class DiagonalTraversal{
	public class Node{
		Node left;
		Node right;
		int data;

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
	public void seeDiagonalTraversalUtil(Node root, int level, Map<Integer,Vector<Integer>> mp){
		if(root == null){
			return;
		}
		
		Vector<Integer> list = mp.get(level);

		if(list == null){
			list = new Vector<Integer>();
			list.add(root.data);
		}
		else{
			list.add(root.data);
		}

		mp.put(level,list);

		seeDiagonalTraversalUtil(root.left, level+1, mp);  //Logic notice left child increase in level
		seeDiagonalTraversalUtil(root.right, level, mp);   //Right child at same level

	}
	public void seeDiagonalTraversal(Node root){
		Map<Integer,Vector<Integer>> mp = new TreeMap<Integer,Vector<Integer>>();
		seeDiagonalTraversalUtil(root,0,mp);
		for(Map.Entry<Integer,Vector<Integer>> entry : mp.entrySet()){
			System.out.println(entry.getValue());
		}
	}
	public static Node root = null;
	public static void main(String[] args) {
		
		DiagonalTraversal dt = new DiagonalTraversal();

		root = dt.insert(root,1); 
		root = dt.insert(root,2); 
		root = dt.insert(root,3); 
		root = dt.insert(root,4); 
		root = dt.insert(root,5); 
		root = dt.insert(root,6); 
		root = dt.insert(root,7);

		dt.seeDiagonalTraversal(root); 
	}
}