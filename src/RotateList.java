/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null)
			return head;
		ListNode cur = head;
		int num = 0;
		while(cur != null)
		{
			num++;
			cur = cur.next;
		}
		n = n % num;
		if(n == 0)
			return head;
		ListNode before = head, behind = head;
		num = 0;
		while(num < n){
			before = before.next;
			num++;
		}
		while(before.next != null)
		{
			before = before.next;
			behind = behind.next;
		}
		ListNode newhead = behind.next;
		behind.next = null;
		before.next = head;
		return newhead;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RotateList().test();
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
		a = rotateRight(null, 0);
		while(a != null)
		{
			System.out.println(a.val + " ");
			a = a.next;
		}
	}

}
