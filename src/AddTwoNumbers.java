/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//保证两个表都不为null
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode add1 = l1, add2 = l2;
		
		while(add1.next != null && add2.next != null)
		{
			add1.val += add2.val;
			add1 = add1.next;
			add2 = add2.next;
		}
		
		add1.val += add2.val;
		if(add1.next == null)
			add1.next = add2.next;
		
		add1 = l1;
		int flag = 0;
		while(add1.next != null)
		{
			add1.val += flag;
			if(add1.val >= 10)
			{
				add1.val -= 10;
				flag = 1;
			}
			else
				flag = 0;
			add1 = add1.next;
		}
		add1.val += flag;
		if(add1.val >= 10)
		{
			add1.val -= 10;
			add1.next = new ListNode(1);
		}
		return l1;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddTwoNumbers().test();
		
	}

	public void test()
	{
		ListNode a1 = new ListNode(2);
		a1.next = new ListNode(4);
		a1.next.next = new ListNode(3);
		ListNode a2 = new ListNode(5);
		a2.next = new ListNode(6);
		a2.next.next = new ListNode(4);
		ListNode ans = addTwoNumbers(a1, a2);
	}
}
