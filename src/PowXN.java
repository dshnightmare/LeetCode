public class PowXN {
	public double pow(double x, int n) {
		if(n == 0)
			return 1;
		else if(n < 0)
		{
			if(n == Integer.MIN_VALUE)
				return 1 / (pow(x, Integer.MAX_VALUE) * x);
			else
				return 1 / pow(x, -n);
		}
		else if(n == 1)
			return x;
		else if(n % 2 == 0){
			double t = pow(x, n / 2);
			return t * t;
		}
		else {
			double t = pow(x, n / 2);
			return t * t * x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PowXN().pow(1.00000, -2147483648));
		int a = Integer.MIN_VALUE;
		System.out.println(-a);
	}

}
