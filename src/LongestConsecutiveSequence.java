import java.util.HashMap;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i = 0; i < num.length; i++)
			map.put(num[i], true);
		int max = 1;
		for(int i = 0; i < num.length; i++)
		{
			int tmp = num[i], length = 1;
			if(map.get(tmp) == true)
			{
				//forward
				int forward= tmp + 1;
				while(map.containsKey(forward))
				{
					map.put(forward, false);
					forward++;
					length++;
				}
				//backward
				int backward= tmp - 1;
				while(map.containsKey(backward))
				{
					map.put(backward, false);
					backward--;
					length++;
				}
				if(length > max)
					max = length;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(num));
	}

}
