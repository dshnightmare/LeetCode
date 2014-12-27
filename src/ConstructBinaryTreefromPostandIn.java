public class ConstructBinaryTreefromPostandIn {
	public TreeNode buildTree(int[] inorder, int[]postorder) {
		if(inorder == null || inorder.length == 0)
			return null;
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	
	private TreeNode build(int[] inorder, int ileft, int iright, int[] postorder, int pleft, int pright) {
		if(pleft > pright)
			return null;
		TreeNode root = new TreeNode(postorder[pright]);
		int i, j;
		for(i = ileft, j = pleft; i <= iright; i++, j++) {
			if(inorder[i] == postorder[pright])
				break;
		}
		root.left = build(inorder, ileft, i - 1, postorder, pleft, j - 1);
		root.right = build(inorder, i + 1, iright, postorder, j, pright - 1);
		return root;
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