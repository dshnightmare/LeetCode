/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class MaximumGap {
	public int maximumGap(int[] num) {
		int[] a, b, c, cpy;
		int max = 0;
		for(int i = 0; i < 8; i++){
			a = new int[32];
			b = new int[32];
			c = new int[32];
			cpy = new int[num.length];
			for(int j = 0; j < num.length; j++){
				a[(num[j] >> (i*4)) & 31]++;
			}
			for(int j = 1; j < 32; j++){
				b[j] = b[j - 1] + a[j - 1];
			}
			for(int j = 0; j < num.length; j++){
				int index = (num[j] >> (i*4)) & 31;
				cpy[b[index]+c[index]] = num[j];
				c[index]++;
			}
			num = cpy.clone();
		}
		for(int i = 1; i < num.length; i++)
		{
			if(num[i] - num[i - 1] > max)
				max = num[i] - num[i - 1];
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3, 7, 89, 54, 65, 32, 45, 7};
		System.out.println(new MaximumGap().maximumGap(num));
	}

}
