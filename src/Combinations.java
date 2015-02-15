import java.util.List;
import java.util.ArrayList;

public class Combinations {
	private List<List<Integer>> result;
	public List<List<Integer>> combine(int n, int k) {
		result = new ArrayList<>();
		ArrayList<Integer> cur = new ArrayList<>();
		choose(n, k, cur);
		return result;
	}
	
	private void choose(int n, int k, ArrayList<Integer> cur) {
		if(cur.size() == k) {
			result.add((List<Integer>)cur.clone());
			return;
		}
		int i = cur.isEmpty() ? 1 : cur.get(cur.size() - 1) + 1; 
		for(; i <= n; i++) {
			cur.add(i);
			choose(n, k, cur);
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		
	}
}