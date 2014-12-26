public class PopulatingNextRightPointers {
	public void connect(TreeLinkNode root) {
		int count = 0, max = 1;
		TreeLinkNode head = root, tail = root;
		while(head != null) {
			if(head.left != null){
				tail.next = head.left;
				tail = tail.next;
			}
			if(head.right != null){
				tail.next = head.right;
				tail = tail.next;
			}
			count++;
			TreeLinkNode tmp = head;
			head = head.next;
			if(count == max) {
				tmp.next = null;
				count = 0;
				max *= 2;
			}
		}
	}
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
	
	public void test() {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		connect(root);
	}
	
	public static void main(String[] args) {
		new PopulatingNextRightPointers().test();
	}
}