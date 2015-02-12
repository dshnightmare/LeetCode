public class FactorialTrailingZeroes {
	///如果fact *= 5的话会溢出
	public int trailingZeroes(int n) {
		int num = 0, fact = 5;
		while(fact <= n){
			num += n / fact;
			n /= 5;
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(30));
	}
}