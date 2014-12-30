import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		HashMap<Integer, UndirectedGraphNode> check = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		check.put(node.label, new UndirectedGraphNode(node.label));
		while(!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			UndirectedGraphNode cpy = check.get(cur.label);
			for(UndirectedGraphNode n : cur.neighbors) {
				if(!check.containsKey(n.label)){
					queue.add(n);
					UndirectedGraphNode tmp = new UndirectedGraphNode(n.label);
					cpy.neighbors.add(tmp);
					check.put(n.label, tmp);
					
				}
				else{
					cpy.neighbors.add(check.get(n.label));
				}
			}
		}
		return check.get(node.label);
	}
	
	public class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	}
	
	public void test() {
		
	}
	
	public static void main(String[] args) {
		new CloneGraph().test();
	}
}