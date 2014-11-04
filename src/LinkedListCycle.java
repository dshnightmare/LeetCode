public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast != null && slow != null)
		{
			slow = slow.next;
			fast = fast.next;
			if(fast == null)
				break;
			fast = fast.next;
			if(slow == fast)
				return true;
		}
		return false;
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
