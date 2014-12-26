public class PopulatingNextRightPointers2 {
	public void connect(TreeLinkNode root) {
		int count = 0, max = 1, child = 0;
		TreeLinkNode head = root, tail = root;
		while(head != null) {
			if(head.left != null){
				tail.next = head.left;
				tail = tail.next;
				child++;
			}
			if(head.right != null){
				tail.next = head.right;
				tail = tail.next;
				child++;
			}
			count++;
			TreeLinkNode tmp = head;
			head = head.next;
			if(count == max) {
				tmp.next = null;
				count = 0;
				max = child;
				child = 0;
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
		root.left.left = new TreeLinkNode(3);
		root.left.left.left = new TreeLinkNode(4);
		root.left.left.left.left = new TreeLinkNode(5);
		connect(root);
	}
	
	public static void main(String[] args) {
		new PopulatingNextRightPointers2().test();
	}
}