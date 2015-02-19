import java.util.Arrays;

public class Candy {
	// 单调区间, 寻找极点
	public int candy(int[] ratings) {
		int[] has = new int[ratings.length];
		Arrays.fill(has, 1);
		int total = 0;
		for(int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i - 1])
				has[i] = has[i - 1] + 1;
		}
		for(int i = ratings.length - 1; i > 0; i--) {
			if(ratings[i - 1] > ratings[i])
				has[i - 1] = Math.max(has[i] + 1, has[i - 1]);
		}
		for(int i = 0; i < ratings.length; i++)
			total += has[i];
		return total;
	}
	
	public static void main(String[] args) {
		int[] num = {2, 1};
		System.out.println(new Candy().candy(num));
	}
}