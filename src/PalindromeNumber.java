/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x == 0)
			return true;
		else if(x < 0)
			return false;
		int rx = 0;
		if(x % 10 == 0)
			return false;
		while(rx < x)
		{
			int tmp = x % 10;
			x = x /10;
			if(rx == x)
				return true;
			rx = rx * 10 + tmp;
			if(rx == x)
				return true;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromeNumber().isPalindrome(1001));
	}

}
