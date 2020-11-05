/* Check if two tree are mirror or not. */

class Mirror{
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
	public static boolean check(Node nodeA, Node nodeB){
		//If root is different return false!
		if(nodeA == null && nodeB == null){
			return true;
		}

		if(nodeA == null || nodeB == null){
			return false;
		}

		if(nodeA.data != nodeB.data){
			return false;
		}
		else{
			ans = true;
		}

		ans = (check(nodeA.left, nodeB.right) && check(nodeA.right, nodeB.left));
		return ans;
	}
	public static boolean ans = false;
	public static Node rootA = null;
	public static Node rootB = null;
	public static void main(String[] args) {
		Mirror m = new Mirror();

		rootA = new Node(1);
		rootA.left = new Node(2);
		rootA.right = new Node(3);

		rootB = new Node(1);
		rootB.left = new Node(3);
		rootB.right = new Node(2);
		//rootB.right.left = new Node(4);

		if(m.check(rootA, rootB)){
			System.out.println("Given tree is mirror");
		}
		else{
			System.out.println("Given tree is not mirror");
		}
	}
}