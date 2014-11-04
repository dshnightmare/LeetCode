public class RemoveDuplicatesSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(-1), pre = dummy, cur = head;
		boolean flag = false;
		dummy.next = head;
		while (cur.next != null) {
			if (cur.val == cur.next.val) {
				flag = true;
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
				if (flag) {
					pre.next = cur;
					flag = false;
				} else {
					pre = pre.next;
				}
			}
		}
		if(flag)
			pre.next = cur.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveDuplicatesSortedList2().test();
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void test() {
		ListNode a = new ListNode(1);
		a.next = new ListNode(1);
//		a.next.next = new ListNode(1);
//		a.next.next.next = new ListNode(2);
//		a.next.next.next.next = new ListNode(3);
		a = deleteDuplicates(a);
		while (a != null) {
			System.out.println(a.val + " ");
			a = a.next;
		}
	}
}
