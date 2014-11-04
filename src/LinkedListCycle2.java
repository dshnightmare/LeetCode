
public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast != null && slow != null)
		{
			slow = slow.next;
			fast = fast.next;
			if(fast == null)
				return null;
			fast = fast.next;
			if(slow == fast)
			{
				while(head != slow){
					head = head.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
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
