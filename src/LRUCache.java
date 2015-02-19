import java.util.HashMap;

public class LRUCache {
	// hashmap + dlinkedlist
	private HashMap<Integer, DLinkedNode> cache;
	private int count;
	private int capacity;
	private DLinkedNode head, tail;
	
	public LRUCache(int capacity) {
		cache = new HashMap<>();
		count = 0;
		this.capacity = capacity;
		
		head = new DLinkedNode();
		head.pre = null;
		
		tail = new DLinkedNode();
		tail.post = null;
		
		head.post = tail;
		tail.pre = head;
	}
	
	public int get(int key) {
		DLinkedNode node  = cache.get(key);
		if(node == null)
			return  -1;
		
		moveToHead(node);
		return node.value;
	}
	
	public void set(int key, int value) {
		DLinkedNode node = cache.get(key);
		
		if(node == null) {
			node = new DLinkedNode();
			node.key = key;
			node.value = value;
			
			cache.put(key, node);
			addNode(node);
			
			++count;
			if(count > capacity) {
				DLinkedNode t = popTail();
				cache.remove(t.key);
				--count;
			}
		}
		else{
			node.value = value;
			moveToHead(node);
		}
	}
	
	private class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
	}
	
	private void addNode(DLinkedNode node) {
		node.pre = head;
		node.post = head.post;
		
		head.post.pre = node;
		head.post = node;
	}
	
	private void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		
		pre.post = post;
		post.pre = pre;
	}
	
	private void moveToHead(DLinkedNode node) {
		removeNode(node);
		addNode(node);
	}
	
	private DLinkedNode popTail() {
		DLinkedNode res = tail.pre;
		removeNode(res);
		return res;
	}
	
	public static void main(String[] args) {
		
	}
}