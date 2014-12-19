import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	List<List<Integer>> result;
	int[] count;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		result = new ArrayList<>();
		count = new int[candidates.length];
		choose(candidates, target, 0);
		return result;
	}
	
	private void choose(int[] candidates, int left, int index){
		if(left == 0){
			List<Integer> ans = new ArrayList<>();
			for(int i = 0; i < count.length; i++){
				if(count[i] != 0){
					for(int j = 0; j < count[i]; j++)
						ans.add(candidates[i]);
				}
			}
			result.add(ans);
			return;
		}
		if(index >= candidates.length || left < 0)
			return;
		int time = left / candidates[index];
		for(int i = time; i >= 0; i--){
			count[index] = i;
			choose(candidates, left - i * candidates[index], index + 1);
			count[index] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,6,7};
		List<List<Integer>> ans = new CombinationSum().combinationSum(candidates, 7);
		for (List<Integer> list : ans) {
			for (Integer integer : list) {
				System.out.printf("%d,", integer);
			}
			System.out.println();
		}
	}

}
