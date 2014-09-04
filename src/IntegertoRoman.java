/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class IntegertoRoman {
	public String intToRoman(int num) {
		char[] a = {'I', 'X', 'C', 'M', 0};
		char[] b = {'V', 'L', 'D', 0};
		String r = "";
		int loop = 0;
		while(num != 0){
			int t = num % 10;
			r = digit(t, a[loop], b[loop], a[loop + 1]) + r;
			num /= 10;
			loop++;
		}
		return r;
	}

	private String digit(int digit, char a, char b, char c) {
		String r = "";
		switch (digit) {
		case 3:
			r += a;
		case 2:
			r += a;
		case 1:
			r += a;
			break;
		case 4:
			r = a + "" + b;
			break;
		case 8:
			r += a;
		case 7:
			r += a;
		case 6:
			r += a;
		case 5:
			r = b + r;
			break;
		case 9:
			r = a + "" + c;
		default:
		}
		return r;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IntegertoRoman().intToRoman(1976));
	}

}
