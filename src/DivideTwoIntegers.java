public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int flag = 1;
		long ldividend = dividend;
		if(ldividend < 0){
			if(dividend == Integer.MIN_VALUE){
			}
			ldividend = -ldividend;
			dividend = -dividend;
			flag *= -1;
		}
		if(divisor < 0){
			if(divisor == Integer.MIN_VALUE)
			{
				if(dividend == Integer.MIN_VALUE)
					return 1;
				else
					return 0;
			}
			divisor = -divisor;
			flag *= -1;
		}
		else if(divisor == 0)
			return 0;
		if(ldividend < divisor)
			return 0;
		int bit_num1 = 0, bit_num2 = 0;
		int ele1 = dividend, ele2 = divisor;
		if(dividend == Integer.MIN_VALUE)
		{
			ele1 >>= 1;
			bit_num1++;
			ele1 = -ele1;
		}
		while(ele1 != 0)
		{
 			bit_num1++;
			ele1 >>= 1;
		}
		while(ele2 != 0)
		{
			bit_num2++;
			ele2 >>= 1;
		}
		int result = 0, i = bit_num1 - bit_num2;
		while(i >= 0){
			long num = divisor << i;
			if(num == Integer.MIN_VALUE)
				num = -num;
			else if(num < 0)
				num = ~num + 1;
			result <<= 1;
			if(ldividend >= num)
			{
				ldividend -= num;
				result += 1;
			}
			i--;
		}
		return result * flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DivideTwoIntegers().divide(-2147483648, 3));
	}

}
