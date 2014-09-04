/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if(s.length() <= 1)
			return s;
		String max = "";
		for(int i = 0; i < s.length() - 1; i++)
		{
			String tmp = find(s, i, i);
			if(tmp.length() > max.length())
				max = tmp;
			tmp = find(s, i, i + 1);
			if(tmp.length() > max.length())
				max = tmp;
		}
		return max;
	}
	
	private String find(String s, int i, int j)
	{
		int length = j - i;
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
		{
			length++;
			i--;
			j++;
		}
		return s.substring(i + 1, j);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindromicSubstring().longestPalindrome(""));
	}

}
