/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m == n)
			return head;
		ListNode dummy = new ListNode(-1), cur = dummy, rhead, rtail, it;
		dummy.next = head;
		int count = 1;
		while(count < m){
			cur = cur.next;
			count++;
		}
		rhead = null;
		rtail = cur.next;
		it = rtail;
		while(count <= n){
			ListNode tmp = it.next;
			it.next = rhead;
			rhead = it;
			it = tmp;
			count++;
		}
		cur.next = rhead;
		rtail.next = it;
		return dummy.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReverseLinkedList2().test();
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
		a = reverseBetween(a, 3, 5);
		while(a != null)
		{
			System.out.println(a.val + " ");
			a = a.next;
		}
	}
}
