public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int sign = 1;
		if (dividend < 0)
			sign *= -1;
		if (divisor < 0)
			sign *= -1;

		long big = Math.abs((long) dividend);
		long small = Math.abs((long) divisor);
		long temp = small;
		long midres = 1;
		while (temp < big) {
			temp <<= 1;
			midres <<= 1;
		}

		int ret = 0;
		while (temp >= small) {
			while (big >= temp) {
				big -= temp;
				ret += midres;
			}
			temp >>= 1;
			midres >>= 1;
		}
		if(ret < 0){
			if(sign > 0)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
		return ret * sign;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
	}

}
