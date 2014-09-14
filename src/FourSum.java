import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> r = new ArrayList<>();
		HashMap<String, Integer> tag = new HashMap<>();
		Arrays.sort(num);
		for(int i = 0; i < num.length - 3; i++)
		{
			for(int j = i + 1; j < num.length - 2; j++)
			{
				int sum = num[i] + num[j], left = j + 1, right = num.length - 1;
				while(left < right)
				{
					if(sum + num[left] + num[right] == target)
					{
						List<Integer> rr = new ArrayList<>();
						rr.add(num[i]);
						rr.add(num[j]);
						rr.add(num[left]);
						rr.add(num[right]);
						if(!tag.containsKey(num[i] + " " + num[j] + " " + num[left] + " " + num[right]))
						{
							r.add(rr);
							tag.put(num[i] + " " + num[j] + " " + num[left] + " " + num[right], 0);
						}
						left++;
						right--;
					}
					else if(sum + num[left] + num[right] < target)
						left++;
					else
						right--;
				}
			}
		}
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {-3,-2,-1,0,0,1,2,3};
		List<List<Integer>> rr = new FourSum().fourSum(num, 0);
		for (List<Integer> list : rr) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}

	}

}
