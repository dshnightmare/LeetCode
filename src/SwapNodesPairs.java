
public class SwapNodesPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode realhead = new ListNode(0);
		realhead.next = head;
		ListNode a, b, cur = head, pre = realhead;
		while(true)
		{
			//get two node
			a = cur;
			if(a == null)
				break;
			b = cur.next;
			if(b == null)
				break;
			cur = cur.next.next;
			//swap
			pre.next = b;
			a.next = b.next;
			b.next = a;
			pre = a;
		}
		return realhead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwapNodesPairs().test();
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public void test(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode r = swapPairs(head);
		while(r != null)
		{
			System.out.println(r.val + " ");
			r = r.next;
		}
	}
}
