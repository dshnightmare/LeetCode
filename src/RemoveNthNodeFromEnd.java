public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		//find the nth node of the list
		ListNode nth = head;
		for(int i = 0; i < n - 1; i++)
			nth = nth.next;
		ListNode r = head;
		ListNode last = null;
		while(nth.next != null){
			nth = nth.next;
			last = r;
			r = r.next;
		}
		if(last == null)
			return r.next;
		last.next = r.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveNthNodeFromEnd().test();
		
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
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		ListNode r = removeNthFromEnd(head, 2);
		while(r != null)
		{
			System.out.println(r.val + " ");
			r = r.next;
		}
	}
}
