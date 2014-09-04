import java.util.ArrayList;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		ArrayList<CH> ch = new ArrayList<CH>();
		int left = 0;;
		for (int i = 0, j = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*')
			{
				ch.get(ch.size() - 1).setInf(true);
				left--;
			}
			else
			{
				ch.add(new CH(p.charAt(i)));
				left++;
			}
		}
		int a = 1;
		return match(s, ch, 0, 0, s.length() - left);
	}

	private boolean match(String s, ArrayList<CH> ch, int i, int j, int left) {
		boolean r = false;
		//System.out.println(i + " " + j + " " + left);
		if(i == s.length() && left == 0)
			return true;
		if(j >= ch.size())
			return r;
		if(left < 0)
			return r;
		if (ch.get(j).isInf()) {
			
			for (int m = 0; m <= left; m++) {
				boolean flag = true;
				//System.out.println("       "+m);
				int n;
				for (n = 0; n < m; n++) {
					if (ch.get(j).getCh() != '.'
							&& ch.get(j).getCh() != s.charAt(i + n)) {
						flag = false;
						break;
					}
				}
				if(flag)
				{
					boolean tmp = match(s, ch, i+n, j+1, left-n);
					r = r == true ? true : tmp;
				}
			}
		} else if (ch.get(j).getCh() == '.') {
			r = match(s, ch, i+1, j+1, left);
		} else if (ch.get(j).getCh() == s.charAt(i)) {
			r = match(s, ch, i+1, j+1, left);
		} else {

		}
		return r;
	}

	private class CH {
		private char ch;
		private boolean inf;

		public CH(char _ch) {
			ch = _ch;
			inf = false;
		}

		public boolean isInf() {
			return inf;
		}

		public void setInf(boolean inf) {
			this.inf = inf;
		}

		public char getCh() {
			return ch;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new RegularExpressionMatching().isMatch("aa","a"));
//		System.out.println(new RegularExpressionMatching().isMatch("aa","aa"));
//		System.out.println(new RegularExpressionMatching().isMatch("aaa","aa"));
//		System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
//		System.out.println(new RegularExpressionMatching().isMatch("aa", ".*"));
//		System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
		System.out.println(new RegularExpressionMatching().isMatch("aaa", "aaaa"));
	}

}
