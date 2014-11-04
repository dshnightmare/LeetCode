/**
 * @author dengshihong
 * 
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode small = new ListNode(-1), big = new ListNode(-1), pivot = head, cur = head.next;
		ListNode sc = small, bc = big;
		int smin = pivot.val, bmax = pivot.val;
		while (cur != null) {
			if (cur.val > pivot.val) {
				if(cur.val > bmax)
					bmax = cur.val;
				bc.next = cur;
				bc = bc.next;
				cur = cur.next;
				bc.next = null;
			} else {
				if(cur.val < smin)
					smin = cur.val;
				sc.next = cur;
				sc = sc.next;
				cur = cur.next;
				sc.next = null;
			}
		}
		if(smin != pivot.val)
			small.next = sortList(small.next);
		if(bmax != pivot.val + 1)
			big.next = sortList(big.next);
		pivot.next = big.next;
		sc = small;
		while(sc.next != null)
			sc = sc.next;
		sc.next = pivot;
		return small.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SortList().test();
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
		a = sortList(a);
		while(a != null)
		{
			System.out.println(a.val + " ");
			a = a.next;
		}
	}

}
