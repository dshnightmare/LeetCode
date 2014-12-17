import java.util.Currency;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = 0, lengthB = 0;
		ListNode cur, dummy = new ListNode(-1);
		dummy.next = headA;
		cur = dummy;
		while(cur.next != null){
			lengthA++;
			cur = cur.next;
		}
		dummy.next = headB;
		cur = dummy;
		while(cur.next != null){
			lengthB++;
			cur = cur.next;
		}
		int gap = lengthA - lengthB;
		if(lengthB > lengthA)
		{
			ListNode tmp = headA;
			headA = headB;
			headB = tmp;
			gap = lengthB - lengthA;
		}
		ListNode cur1 = headA;
		ListNode cur2 = headB;
		for(int i = 0; i < gap; i++){
			cur1 = cur1.next;
		}
		while(cur1 != null && cur2 != null){
			if(cur1 == cur2)
				return cur1;
			else {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
