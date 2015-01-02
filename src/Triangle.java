import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int level = triangle.size();
		int[] min = new int[level];
		List<Integer> cur;
		min[0] = triangle.get(0).get(0);
		for(int i = 1; i < level; i++){
			cur = triangle.get(i);
			min[i] = min[i - 1] + cur.get(i);
			for(int j = i - 1; j >= 1; j--){
				min[j] = Math.min(min[j - 1], min[j]) + cur.get(j);
			}
			min[0] += cur.get(0);
		}
		int result = min[0];
		for(int i = 1; i < level; i++){
			if(min[i] < result)
				result = min[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		
	}
}