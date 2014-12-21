import java.util.List;
import java.util.ArrayList;

public class UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
		return gen(1, n);
	}
	
	public List<TreeNode> gen(int left, int right) {
		List<TreeNode> result = new ArrayList<>();
		if(left > right) {
			result.add(null);
			return result;
		}
		List<TreeNode> lefts, rights;
		for(int i = left; i <= right; i++){
			lefts = gen(left, i - 1);
			rights = gen(i + 1, right);
			for(TreeNode leftChild : lefts){
				for(TreeNode rightChild : rights){
					TreeNode root = new TreeNode(i);
					root.left = leftChild;
					root.right = rightChild;
					result.add(root);
				}
			}
		}
		return result;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x; left = null; right = null;}
	}
	
	public void test(){
		List<TreeNode> result = generateTrees(3);
		System.out.println(result.size());
	}
	
	public static void main(String[] args) {
		new UniqueBinarySearchTrees2().test();
	}
}