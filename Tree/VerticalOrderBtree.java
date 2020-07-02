import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.*;

public class VerticalOrderBtree{
	static class Node{
		int  data;
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
	public static void getVerticalOrder(Node root,int hd, TreeMap<Integer,Vector<Integer>> m){
		//Base Case:
		if(root == null){
			return;
		}

		Vector<Integer> get = m.get(hd);
		if(get == null){
			get = new Vector<>();
			get.add(root.data);
		}
		else{
			get.add(root.data);
		}
		m.put(hd,get);

		getVerticalOrder(root.left,hd-1,m);
		getVerticalOrder(root.right,hd+1,m);
	}
	public static void printVerticalOrder(Node root){
		TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
		int hd = 0;
		getVerticalOrder(root,hd,m);

		for(Entry<Integer,Vector<Integer>> entry : m.entrySet()){
			System.out.print(entry.getValue());
		}
	}
	public static Node root = null;
	public static void main(String[] args) {
			VerticalOrderBtree b1 = new VerticalOrderBtree();

			root = b1.insert(root,1);
			root = b1.insert(root,2);
			root = b1.insert(root,3);
			root = b1.insert(root,4);
			root = b1.insert(root,5);
			root = b1.insert(root,6);
			root = b1.insert(root,7);
			root = b1.insert(root,8);
			root = b1.insert(root,9);

			System.out.println("Print Vertical Order Traversal:");
			printVerticalOrder(root);
		}	
}