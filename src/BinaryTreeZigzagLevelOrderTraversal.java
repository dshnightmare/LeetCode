import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		Stack<TreeNode> cur = new Stack<>();
		Stack<TreeNode> next = new Stack<>();
		List<Integer> curList;
		int direction = 0;
		cur.push(root);
		while(!cur.isEmpty()){
			curList = new ArrayList<>();
			while(!cur.isEmpty()){
				TreeNode node = cur.pop();
				curList.add(node.val);
				if(direction == 0){
					if(node.left != null)
						next.push(node.left);
					if(node.right != null)
						next.push(node.right);
				}
				else{
					if(node.right != null)
						next.push(node.right);
					if(node.left != null)
						next.push(node.left);
				}
			}
			result.add(curList);
			Stack<TreeNode> tmp = next;
			next = cur;
			cur = tmp;
			direction = direction == 0 ? 1 : 0;
		}
		return result;
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