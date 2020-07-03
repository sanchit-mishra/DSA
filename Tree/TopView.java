/*Top View of Binary Tree in Java*/

import java.util.*;

class TopView{
	static class Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	static class VerticalOrder{  //Vertical Order with associate Horizontal distance.
		Node node;
		int hd;

		public VerticalOrder(Node n, int d){
			this.node = n;
			this.hd = d;
		}
	}
	public static void seeTopView(Node root){
		
		//Base Condition:
		if(root == null){
			System.out.println("Tree is empty");
		}
		Node temp = null;
		Queue<VerticalOrder> q = new LinkedList<VerticalOrder>();

		Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();
		q.add(new VerticalOrder(root,0));

		while(q.size() > 0){  //Level Order Traversal
			temp = q.peek().node;
			int d = q.peek().hd;
			q.remove();

			if(mp.get(d) == null){  //Store only first one of vertical order traversal
				mp.put(d,temp.data);
			}

			if(temp.left != null){
				q.add(new VerticalOrder(temp.left,d-1));
			}

			if(temp.right != null){
				q.add(new VerticalOrder(temp.right,d+1));
			}
		}

		for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
			System.out.print(entry.getValue()+"->");
		}
	}
	public static Node root = null;
	public static void main(String[] args) {
		TopView l1 = new TopView();

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		l1.seeTopView(root);

	}
}