import java.util.Arrays;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if(num.length == 0)
			return null;
		return BST(num);
	}

	
	private TreeNode BST(int[] num)
	{
		TreeNode root = new TreeNode(num[num.length/2]);
		if(num.length == 1)
		{
			
		}
		else if(num.length == 2)
		{
			root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, 1));
		}
		else {
			root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, num.length/2));
			root.right = sortedArrayToBST(Arrays.copyOfRange(num, num.length/2 + 1, num.length));
		}
		return root;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2, 4, 6, 8};
		TreeNode aNode = new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(num);
		int a = 1;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
