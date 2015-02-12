import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if(numRows == 0)
			return result;
		List<Integer> cur = new ArrayList<>();
		cur.add(1);
		result.add(cur);
		for(int i = 1; i < numRows; i++) {
			cur = new ArrayList<>();
			for(int j = 0; j < i; j++){
				int sum = 0;
				if(j - 1 >= 0)
					sum += result.get(i - 1).get(j - 1);
				sum += result.get(i - 1).get(j);
				cur.add(sum);
			}
			cur.add(1);
			result.add(cur);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
	}
}