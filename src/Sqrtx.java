/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class Sqrtx {
	public int sqrt(int x) {
		if(x == 0 || x == 1)
			return x;
		return bsearch(0, x, x);
	}

	private int bsearch(int begin, int end, int x){
		if(begin >= end)
			return end;
		int mid = end - (end -begin - 1) / 2;
		System.out.println(mid);
		if(x / mid == mid)
			return mid;
		else if(mid < x / mid)
			return bsearch(mid, end, x);
		else
			return bsearch(begin, mid - 1, x);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Sqrtx().sqrt(5));
	}

}
