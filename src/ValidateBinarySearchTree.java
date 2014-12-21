public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root){
		if(root == null)
			return true;
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isValid(TreeNode root, int left, int right) {
		if((left <= root.val && root.val <= right) &&
			(root.left == null || (root.left.val < root.val && isValid(root.left, left, root.val - 1))) &&
			(root.right == null || (root.right.val > root.val && isValid(root.right, root.val + 1, right))))
		{
			return true;
		}
		else
			return false;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public void test() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(isValidBST(root));
	}
	
	public static void main(String[] args) {
		new ValidateBinarySearchTree().test();
	}
}