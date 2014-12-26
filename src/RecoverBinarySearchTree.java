public class RecoverBinarySearchTree {
	private TreeNode first = null;
	private TreeNode second = null;
	private TreeNode pre = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root){
		morrisTraversal(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
	
	private void morrisTraversal(TreeNode root) {
		TreeNode cur = root;
		while(cur != null){
			if(cur.left == null){
				//do something
				if(first == null && pre.val >= cur.val)
					first = pre;
				if(first != null && pre.val >= cur.val)
					second = cur;
				pre = cur;
				cur = cur.right;
			}
			else{
				TreeNode p = cur.left;
				while(p.right != null && p.right != cur)
					p = p.right;
				if(p.right == null){
					p.right = cur;
					cur = cur.left;
				}
				else{
					p.right = null;
					//do something
					if(first == null && pre.val >= cur.val)
						first = pre;
					if(first != null && pre.val >= cur.val)
						second = cur;
					pre = cur;
					cur = cur.right;
				}
			}
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public void test() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		recoverTree(root);
	}
	
	public static void main(String[] args) {
		new RecoverBinarySearchTree().test();
	}
}