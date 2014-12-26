import java.util.List;
import java.util.ArrayList;

public class PathSum2 {
	List<List<Integer>> result;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		result = new ArrayList<>();
		findPathSum(root, sum, new ArrayList<Integer>());
		return result;
	}
	
	public void findPathSum(TreeNode root, int sum, List<Integer> path) {
		if(root == null)
			return;
		//leaf node
		if(root.left == null && root.right == null && sum == root.val){
			List<Integer> list = new ArrayList<>();
			list.addAll(path);
			list.add(root.val);
			result.add(list);
			return;
		}
		path.add(root.val);
		if(root.left != null) {
			findPathSum(root.left, sum - root.val, path);
		}
		if(root.right != null){
			findPathSum(root.right, sum - root.val, path);
		}
		path.remove(path.size() - 1);
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public void test() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		List<List<Integer>> list = pathSum(root, 22);
		for(List<Integer> l : list){
			for(Integer i : l)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new PathSum2().test();
	}
}