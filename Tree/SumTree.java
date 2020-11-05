/* Construct a sum tree from binary tree. */

class SumTree{
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
	public static int createSumTree(Node node){

		if(node == null){
			return 0;
		}

		int oldData = node.data;

		node.data = createSumTree(node.left) + createSumTree(node.right);

		return node.data + oldData;
	}
	public static void seePreOrder(Node node){
		if(node == null){
			return;
		}

		System.out.print(node.data + "->");
		seePreOrder(node.left);
		seePreOrder(node.right);
	}
	public static Node root = null;
	public static void main(String[] args) {
		SumTree s = new SumTree();

		root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(6);

		root.left.left = new Node(8);
		root.left.right = new Node(-4);

		root.right.left = new Node(7);
		root.right.right = new Node(5);

		s.createSumTree(root);
		s.seePreOrder(root);
	}
}