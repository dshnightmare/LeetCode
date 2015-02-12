import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		TreeNode cur = root;
		stack = new Stack<>();
		while(cur != null){
			stack.push(cur);
			cur = cur.left;
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		TreeNode top = stack.pop(), cur = top.right;
		while(cur != null)
		{
			stack.push(cur);
			cur = cur.left;
		}
		return top.val;
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