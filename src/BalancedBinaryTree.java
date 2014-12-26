public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return balancedHeight(root) >= 0;
	}
	
	private int balancedHeight(TreeNode root) {
		if(root == null)
			return 0;
		int leftHeight = balancedHeight(root.left);
		if(leftHeight < 0)
			return leftHeight;
		int rightHeight = balancedHeight(root.right);
		if(rightHeight < 0)
			return rightHeight;
		if(Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		
	}
}