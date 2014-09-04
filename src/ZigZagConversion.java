import java.util.ArrayList;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(nRows == 1)
			return s;
		ArrayList<Character>[] lines = new ArrayList[nRows];
		for(int i = 0; i < nRows; i++)
			lines[i] = new ArrayList<>();
		int count = 0;
		int add = 1;
		for(char c : s.toCharArray())
		{
			lines[count].add(c);
			count += add;
			if(count == nRows - 1 || count == 0)
				add *= -1;
		}
		String r = "";
		for(int i = 0; i < nRows; i++)
		{
			for(Character c : lines[i])
				r += c;
		}
		return r;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagConversion().convert("", 1));
	}

}
