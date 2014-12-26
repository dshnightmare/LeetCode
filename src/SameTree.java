public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p != null && q != null
			&& p.val == q.val
			&& isSameTree(p.left, q.left) 
			&& isSameTree(p.right, q.right))
			return true;
		return false;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public void test() {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(3);
		System.out.println(isSameTree(p, q));
	}
	
	public static void main(String[] args) {
		new SameTree().test();
	}
}