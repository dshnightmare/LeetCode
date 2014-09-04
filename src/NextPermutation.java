/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class NextPermutation {

	public void nextPermutation(int[] num) {
		int length = num.length, i;
		for(i = length - 1; i > 0; i--)
		{
			if(num[i] > num[i - 1])
			{
				int k = length - 1;
				while(num[k] <= num[i-1])
					k--;
				exch(num, k, i - 1);
				int jl = (length - 1 - i) / 2;
				for(int j = 0; j <= jl; j++)
				{
					exch(num, j+i, length - 1 - j);
				}
				break;
			}
		}
		if(i == 0)
		{
			int jl = (length - 1 - i) / 2;
			for(int j = 0; j <= jl; j++)
			{
				exch(num, j+i, length - 1 - j);
			}
		}
		for(int nums : num)
			System.out.println(nums);
	}
	
	private void exch(int[] num, int i, int j)
	{
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int num[] = {1,2,3};
		int num[] = {1,5,1};
		new NextPermutation().nextPermutation(num);
	}

}
