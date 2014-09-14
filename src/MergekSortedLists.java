import java.util.List;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		return merge(lists);
	}
	
	private ListNode merge(List<ListNode> lists){
		if(lists.size() == 0)
			return null;
		else if(lists.size() == 1)
			return lists.get(0);
		else if(lists.size() == 2)
			return merge(lists.get(0), lists.get(1));
		else{
			int mid = lists.size() / 2;
			List<ListNode> a = lists.subList(0, mid);
			List<ListNode> b = lists.subList(mid, lists.size());
			return merge(merge(a), merge(b));
		}
	}
	
	private ListNode merge(ListNode a, ListNode b){
		ListNode head = new ListNode(0), cur = head;
		while(a != null && b != null)
		{
			if(a.val < b.val)
			{
				cur.next = a;
				cur = a;
				a = a.next;
			}
			else{
				cur.next = b;
				cur = b;
				b = b.next;
			}
		}
		while(a != null){
			cur.next = a;
			cur = a;
			a = a.next;
		}
		while(b != null){
			cur.next = b;
			cur = b;
			b = b.next;
		}
		return head.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MergekSortedLists().test();
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
		a.next = new ListNode(2);
		a.next.next = new ListNode(4);
		a.next.next.next = new ListNode(6);
		a.next.next.next.next = new ListNode(8);
		ListNode b = new ListNode(1);
		b.next = new ListNode(3);
//		b.next.next = new ListNode(5);
//		b.next.next.next = new ListNode(7);
//		b.next.next.next.next = new ListNode(9);
		ListNode c = merge(a, b);
		while(c != null)
		{
			System.out.println(c.val + " ");
			c = c.next;
		}
	}
}
