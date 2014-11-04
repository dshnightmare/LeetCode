/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null)
			return;
		ListNode cur = head;
		int num = 0;
		while(cur != null){
			num++;
			cur = cur.next;
		}
		int half = (num + 1) / 2;
		ListNode reverse = head;
		for(int i = 1; i < half; i++)
			reverse = reverse.next;
		ListNode tmp = reverse.next;
		reverse.next = null;
		reverse = tmp;
		reverse = reverse(reverse);
		ListNode p2 = head.next;
		ListNode p1 = reverse;
		ListNode p = head;
		for(int i = 1; i < half; i++){
			p.next = p1;
			p1 = p1.next;
			p = p.next;
			p.next = p2;
			p2 = p2.next;
			p = p.next;
		}
		if(num % 2 == 0)
			p.next = p1;
	}

	public ListNode reverse(ListNode head){
		ListNode newhead = null;
		while(head != null){
			ListNode cur = head;
			head = head.next;
			cur.next = newhead;
			newhead = cur;
		}
		return newhead;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReorderList().test();
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
		reorderList(a);
		while(a != null)
		{
			System.out.println(a.val + " ");
			a = a.next;
		}
	}
}
