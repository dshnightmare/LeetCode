public class SumRoottoLeafNumbers {
	private int sum;
	public int sumNumbers(TreeNode root) {
		sum = 0;
		if(root == null)
			return sum;
		getNumber(root, 0);
		return sum;
		
	}
	
	private void getNumber(TreeNode node, int last) {
		int num = last * 10 + node.val;
		if(node.left == null && node.right == null)
			sum += num;
		if(node.left != null)
			getNumber(node.left, num);
		if(node.right != null)
			getNumber(node.right, num);
	}
	
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		new SumRoottoLeafNumbers().test();
	}
}