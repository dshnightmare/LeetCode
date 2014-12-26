public class MinimumDepthofBinaryTree {
	private int min;
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		min = Integer.MAX_VALUE;
		find(root, 0);
		return min;
	}
	
	private void find(TreeNode root, int depth) {
		depth++;
		if(depth >= min)
			return;
		if(root.left == null && root.right == null)
			min = depth;
		if(root.left != null)
			find(root.left, depth);
		if(root.right != null)
			find(root.right, depth);
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public void test() {
		
	}
	
	public static void main(String[] args) {
		new MinimumDepthofBinaryTree().test();
	}
}