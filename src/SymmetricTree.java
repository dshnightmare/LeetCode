import java.util.Stack;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null)
			return true;
		if(left != null && right != null && left.val == right.val && 
			isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left))
			return true;
		return false;
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public void test(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));
	}
	
	public static void main(String[] args) {
		new SymmetricTree().test();
	}
}