public class CopyListRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode tmp = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = tmp;
			cur = tmp;
		}
		cur = head;
		while (cur != null) {
			if (cur.random == null) {
				cur.next.random = null;
			} else {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		RandomListNode dummy = new RandomListNode(-1), tail = dummy;
		cur = head;
		while(cur != null)
		{
			tail.next = cur.next;
			tail = tail.next;
			cur.next = tail.next;
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
}
