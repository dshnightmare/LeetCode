public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		while(head != null){
			ListNode cur = dummy;
			while(cur.next != null && head.val > cur.next.val){
				cur = cur.next;
			}
			ListNode tmp = head;
			head = head.next;
			tmp.next = cur.next;
			cur.next = tmp;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InsertionSortList().test();
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public void test()
	{
		ListNode a = new ListNode(0);
		a.next = new ListNode(4);
		a.next.next = new ListNode(2);
		a.next.next.next = new ListNode(8);
		a.next.next.next.next = new ListNode(3);
		a = insertionSortList(a);
		while(a != null)
		{
			System.out.println(a.val + " ");
			a = a.next;
		}
	}
}
