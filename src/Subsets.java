import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	private List<List<Integer>> result;
	
	public List<List<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		result = new ArrayList<>();
		ArrayList cur = new ArrayList<>();
		choose(S, 0, cur);
		return result;
	}
	
	private void choose(int[] S, int index, ArrayList<Integer> cur) {
		if(index == S.length) {
			result.add((List<Integer>)cur.clone());
			return;
		}
		// not choose
		choose(S, index + 1, cur);
		// choose the element
		cur.add(S[index]);
		choose(S, index + 1, cur);
		cur.remove(cur.size() - 1);
	}
	
	public static void main(String[] args) {
		
	}
}