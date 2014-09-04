/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0)
			return 0;
		int[][] has = new int[s.length()][128];
		int[] length = new int[s.length()];
		has[0][s.charAt(0)] = 1;
		int max = length[0] = 1;
		for(int i = 1; i < s.length(); i++)
		{
			int tmp = has[i - 1][s.charAt(i)];
			if(tmp == 0)
			{
				System.arraycopy(has[i-1], 0, has[i], 0, 128);
				has[i][s.charAt(i)] = i + 1;
				length[i] = length[i - 1] + 1;
			}
			else{
				for(int j = tmp; j <= i; j++)
					has[i][s.charAt(j)] = j + 1;
				length[i] = i - tmp  + 1;
			}
			if(length[i] > max)
				max = length[i];
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
	}

}
