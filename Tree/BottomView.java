/* Bottom View of Binary Tree */
import java.util.*;

class BottomView{
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
	static class NodeLevelHd{
		Node node;
		int hd;

		public NodeLevelHd(Node node, int levelHd){
			this.node = node;
			this.hd = levelHd;
		}
	}
	public static void seeBottomView(Node root){   //Use Concept of LevelOrder && VerticalOrder Traversal
		//Case 1:
		if(root == null){
			System.out.println("Tree is empty");
		}

		Queue<NodeLevelHd> q = new LinkedList<NodeLevelHd>();
		Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();
		
		Node temp = null;
		q.add(new NodeLevelHd(root,0));
		while(q.size() > 0){
			temp = q.peek().node;
			int levelHd = q.peek().hd;
			q.remove();

			if(mp.get(levelHd) == null){
				mp.put(levelHd,temp.data);
			}
			else{
				mp.put(levelHd,temp.data);
			}

			if(temp.left != null){
				q.add(new NodeLevelHd(temp.left,levelHd-1));
			}

			if(temp.right != null){
				q.add(new NodeLevelHd(temp.right,levelHd+1));
			}
		}

		for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
			System.out.print(entry.getValue()+"->");
		}
	}
	public static Node root = null;
	public static void main(String[] args) {
		BottomView b1 = new BottomView();

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.left.right.left = new Node(8);
		root.left.left.right.right = new Node(9);

		   //           1
		   //         2   3
		   //       4   5
		   //     6   7
		   //       8   9

		b1.seeBottomView(root); //6->8->7->9->3.
	}
}