public class BinaryTreeMaximumPathSum {
	private int max;
	public int maxPathSum(TreeNode root) {
		 max = Integer.MIN_VALUE;
		 find(root);
		 return max;
	}
	
	private int find(TreeNode root){
		if(root == null)
			return 0;
		int leftSum = find(root.left);
		int rightSum = find(root.right);
		int total =root.val;
		if(leftSum > 0)
			total += leftSum;
		if(rightSum > 0)
			total += rightSum;
		if(total > max)
			max = total;
		return Math.max(leftSum, rightSum) > 0 ? Math.max(leftSum, rightSum) + root.val : root.val;
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