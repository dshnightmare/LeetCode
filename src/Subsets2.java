import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
	private List<List<Integer>> result;
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		int[] unique = new int[num.length], count = new int[num.length];
		int j = 0;
		unique[0] = num[0];
		count[0]++;
		for(int i = 1; i < num.length; i++) {
			if(num[i] == num[i - 1])
				count[j]++;
			else{
				unique[++j] = num[i];
				count[j]++;
			}
		}
		result = new ArrayList<>();
		ArrayList<Integer> cur = new ArrayList<>();
		choose(unique, count, 0, j, cur);
		return result;
	}
	
	private void choose(int[] num, int[] count, int index, int length, ArrayList<Integer> cur) {
		if(index > length){
			result.add((List<Integer>)cur.clone());
			return;
		}
		// 0
		choose(num, count, index + 1, length, cur);
		// 1 - count
		for(int i = 1; i <= count[index]; i++) {
			cur.add(num[index]);
			choose(num, count, index + 1, length, cur);
		}
		
		for(int i = 1; i <= count[index]; i++) {
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		
	}
}