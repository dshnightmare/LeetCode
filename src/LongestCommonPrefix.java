/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		String r = "";
		if(strs.length == 0)
			return r;
		
		int min = strs[0].length();
		for(int i = 1; i < strs.length; i++)
			if(strs[i].length() < min)
				min = strs[i].length();
		
		for(int i = 0; i < min; i++)
		{
			char t = strs[0].charAt(i);
			int j;
			for(j = 1; j < strs.length; j++)
			{
				if(strs[j].charAt(i) != t)
					break;
			}
			if(j == strs.length)
				r += t;
			else
				break;
		}
		return r;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"ab", "ab", ""};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}

}
