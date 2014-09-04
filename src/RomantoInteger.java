
/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class RomantoInteger {
	public int romanToInt(String s) {
		int[] va = {1, 10, 100, 1000};
		int[] vb = {5, 50, 500, 0};
		String sa = "IXCM ";
		String sb = "VLD ";
		int sum = 0;
		s += 0;
		char[] cc = s.toCharArray();
		for(int i = 0; i < s.length() - 1; i++)
		{
			int index = sa.indexOf(cc[i]);
			if(index != -1)
			{
				if(cc[i + 1] == sa.charAt(index + 1) ||
						cc[i + 1] == sb.charAt(index))
					sum -= va[index];
				else
					sum += va[index];
			}
			else {
				index = sb.indexOf(cc[i]);
				sum += vb[index];
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RomantoInteger().romanToInt("MCM"));
	}

}
