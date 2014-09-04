import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> all = new ArrayList<>();
		for(int i = 0; i < num.length - 1; i++)
		{
			if(i > 0 && num[i] == num[i - 1])
				continue;
			if((i == 0 || num[i] != num[i - 1]) && num[i] == num[i + 1] && num[i] <= 0)
				all.addAll(twoSum(num, i+1));
			else
				all.addAll(twoSum(num, i));
		}
		return all;
	}

	
	private List<List<Integer>> twoSum(int[] num, int index){
		int i = 0, j = num.length - 1;
		ArrayList<Integer> r = new ArrayList<>();
		List<List<Integer>> rr = new ArrayList<>();
		while(i < index && index < j){
			int a = num[i];
			int b = num[j];
			if(a + b < -num[index])
			{
				i++;
				while(i <= index && num[i] == num[i-1])
					i++;
			}
			else if(a + b > -num[index])
			{
				j--;
				while(j >= index && num[j] == num[j+1])
					j--;
			}
			else {
				if(i < index && index < j)
				{
					r.add(num[i]);
					r.add(num[index]);
					r.add(num[j]);
					rr.add(r);
					r = new ArrayList<>();
				}
				i++;
				while(i <= index && num[i] == num[i-1])
					i++;
				j--;
				while(j >= index && num[j] == num[j+1])
					j--;
			}
		}
		return rr;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0, 0, 0, 0};
		//int[] num = {-1,0,1,0};
		//int[] num = {-4,-1,-1,-1,0,1,2,5};
		//int[] num = {1, 1, -2};
		List<List<Integer>> r = new ThreeSum().threeSum(num);
		for(List<Integer> i : r)
		{
			for(Integer j : i)
				System.out.print(j + " ");
			System.out.println();
		}
	}

}
