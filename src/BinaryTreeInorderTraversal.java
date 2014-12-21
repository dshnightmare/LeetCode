import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		TreeNode p = root;
		Stack<TreeNode> s = new Stack<>();
		while(!s.isEmpty() || p != null){
			if(p != null){
				s.push(p);
				p = p.left;
			}
			else{
				p = s.pop();
				result.add(p.val);
				p = p.right;
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
	
	public void test(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<Integer> result = inorderTraversal(root);
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}
	
	public static void main(String[] args) {
		new BinaryTreeInorderTraversal().test();
	}
}