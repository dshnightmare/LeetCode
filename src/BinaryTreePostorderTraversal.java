import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode preVisited = root;
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.peek();
			if(cur.left == null && cur.right == null || cur.left == preVisited || cur.right == preVisited){
				stack.pop();
				result.add(cur.val);
				preVisited = cur;
			}
			else{
				if(cur.right != null)
					stack.push(cur.right);
				if(cur.left != null)
					stack.push(cur.left);
			}
		}
		return result;
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