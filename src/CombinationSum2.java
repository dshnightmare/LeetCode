import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	List<List<Integer>> result;
	int[] count;
	int[] real;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		int length = RemoveDuplicatesSortedArray(candidates);
		candidates = Arrays.copyOfRange(candidates, 0, length);
		result = new ArrayList<>();
		count = new int[candidates.length];
		choose(candidates, target, 0);
		return result;
	}

	private void choose(int[] candidates, int left, int index) {
		if (left == 0) {
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
		if (index >= candidates.length || left < 0)
			return;
		int time = left / candidates[index];
		time = time < real[index] ? time : real[index];
		for(int i = time; i >= 0; i--){
			count[index] = i;
			choose(candidates, left - i * candidates[index], index + 1);
			count[index] = 0;
		}
	}
	
	private int RemoveDuplicatesSortedArray(int[] A){
		if(A == null || A.length == 0)
			return 0;
		real = new int[A.length];
		int pre = A[0], num = 0, count = 1, i;
		for(i = 1; i < A.length; i++){
			if(A[i] == pre){
				num++;
				count++;
			}
			else {
				real[i - num - 1] = count;
				count = 1;
				pre = A[i];
				A[i - num] = A[i];
			}
		}
		real[i - num - 1] = count;
		return A.length - num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 2 };
		List<List<Integer>> ans = new CombinationSum2().combinationSum2(
				candidates, 1);
		for (List<Integer> list : ans) {
			for (Integer integer : list) {
				System.out.printf("%d,", integer);
			}
			System.out.println();
		}
	}

}
