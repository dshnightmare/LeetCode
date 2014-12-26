public class MaximumDepthofBinaryTree {
	private int max = 0;
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		max = 0;
		find(root, 0);
		return max;
	}
	
	private void find(TreeNode root, int depth) {
		depth++;
		if(root.left == null && root.right == null && depth > max) {
			max = depth;
			return;
		}
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
		
	}
}