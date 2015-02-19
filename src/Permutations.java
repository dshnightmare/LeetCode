import java.util.List;
import java.util.ArrayList;

public class Permutations {
	private List<List<Integer>> result;
	private ArrayList<Integer> cur;
	public List<List<Integer>> permute(int[] num) {
		boolean[] status = new boolean[num.length];
		result = new ArrayList<>();
		cur = new ArrayList<>();
		generate(num, status);
		return result;
	}
	
	private void generate(int[] num, boolean[] status) {
		if(cur.size() == num.length){
			result.add((List<Integer>)cur.clone());
		}
		for(int i = 0; i < num.length; i++){
			if(!status[i]){
				cur.add(num[i]);
				status[i] = true;
				generate(num, status);
				cur.remove(cur.size() - 1);
				status[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}