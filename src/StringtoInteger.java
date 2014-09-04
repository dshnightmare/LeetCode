
/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class StringtoInteger {
	private static int INT_MAX = 2147483647;
	public int atoi(String str) {
		if(str == null)
			return 0;
		char[] c = str.toCharArray();
		int i = 0, mul = 1;
		long sum = 0;
		while(i < str.length() && c[i] == ' ')
			i++;
		if(i == str.length())
			return 0;
		if(c[i] == '+')
			i++;
		else if(c[i] == '-')
		{
			i++;
			mul = -1;
		}
		
		while(i < str.length() && c[i] != ' ')
		{
			if(c[i] >= '0' && c[i] <= '9')
			{
				sum = sum * 10 + c[i] - '0';
				if(mul > 0)
				{
					if(sum >= INT_MAX)
					{
						sum = INT_MAX;
						break;
					}
				}
				else {
					if(sum > INT_MAX)
					{
						sum = INT_MAX + 1;
						break;
					}
				}
			}
			else
				break;
			i++;
		}
		return (int)sum * mul;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringtoInteger().atoi("-2147483648"));
	}

}
