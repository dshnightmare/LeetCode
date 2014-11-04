public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode small = new ListNode(-1), big = new ListNode(-1), scur = small, bcur = big;
		while (head != null) {
			if (head.val < x) {
				scur.next = head;
				head = head.next;
				scur = scur.next;
				scur.next = null;
			} else {
				bcur.next = head;
				head = head.next;
				bcur = bcur.next;
				bcur.next = null;
			}
		}
		scur.next = big.next;
		return small.next;
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
