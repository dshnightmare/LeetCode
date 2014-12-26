import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		int count = 0, all = 1, child = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> curList = new ArrayList<>();
		TreeNode cur;
		queue.add(root);
		while(!queue.isEmpty()){
			count++;
			cur = queue.poll();
			curList.add(cur.val);
			if(cur.left != null){
				queue.add(cur.left);
				child++;
			}
			if(cur.right != null){
				queue.add(cur.right);
				child++;
			}
			if(count == all){
				all = child;
				count = 0;
				child = 0;
				result.add(curList);
				curList = new ArrayList<>();
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