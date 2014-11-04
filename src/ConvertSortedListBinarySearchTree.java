public class ConvertSortedListBinarySearchTree {
	private ListNode list;   //need to be a global variable in java
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		int n = 0;
		ListNode cur = head;
		while(cur != null){
			n++;
			cur = cur.next;
		}
		list = head;
		return sortedListToBST(0, n-1);
	}

	public TreeNode sortedListToBST(int start, int end){
		if(start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode leftchild = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		parent.left = leftchild;
		list = list.next;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
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
