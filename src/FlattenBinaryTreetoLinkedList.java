import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode pre = new TreeNode(-1);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			pre.right = cur;
			pre = cur;
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
			cur.left = null;
		}
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