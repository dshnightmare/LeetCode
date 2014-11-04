public class ReverseNodesKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null)
			return null;
		ListNode realhead = new ListNode(0);
		realhead.next = head;
		ListNode pre = realhead, cur = head, next = head.next, find = head;
		int i = 0;
		while(true){
			//find if there are k nodes leave
			i = 0;
			for(; i < k; i++){
				if(find == null)
					return realhead.next;
				else
					find = find.next;
			}
			//reverse k nodes
			i = 1;
			ListNode old_begin = cur;
			for(; i < k; i++){
				ListNode tmp = next.next;
				next.next = cur;
				cur = next;
				next = tmp;
			}
			old_begin.next = find;
			pre.next = cur;
			pre = old_begin;
			cur = find;
			if(cur != null)
				next = cur.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReverseNodesKGroup().test();
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
		ListNode r = reverseKGroup(null, 2);
		while(r != null)
		{
			System.out.println(r.val + " ");
			r = r.next;
		}
	}
}
