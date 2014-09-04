import java.util.ArrayList;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class ReverseInteger {
	public int reverse(int x) {
		ArrayList<Integer> a = new ArrayList<>();
		int mul = 1;
		if(x == 0)
			return x;
		else if(x < 0)
		{
			x = -x;
			mul = -1;
		}
		
		while(x != 0)
		{
			a.add(x % 10);
			x /= 10;
		}
		
		int r = 0;
		for(int i = 0; i < a.size(); i++)
		{
			r = r * 10 + a.get(i);
		}
		return r * mul;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseInteger().reverse(0));
	}

}
