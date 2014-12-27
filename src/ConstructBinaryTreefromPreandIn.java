public class ConstructBinaryTreefromPreandIn {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0)
			return null;
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
	
	private TreeNode build(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
		if(pleft > pright)
			return null;
		TreeNode root = new TreeNode(preorder[pleft]);
		int i, j;
		for(i = ileft, j = pleft + 1; i <= iright; i++, j++) {
			if(inorder[i] == preorder[pleft])
				break;
		}
		root.left = build(preorder, pleft + 1, j - 1, inorder, ileft, i - 1);
		root.right = build(preorder, j, pright, inorder, i + 1, iright);
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
		new ConstructBinaryTreefromPreandIn().test();
	}
}