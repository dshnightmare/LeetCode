public class RemoveDuplicatesSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;
		ListNode cur = head;
		while(cur.next != null)
		{
			if(cur.val == cur.next.val)
				cur.next = cur.next.next;
			else 
				cur = cur.next;
		}
		return head;
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
}
