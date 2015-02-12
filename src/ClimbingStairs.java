public class ClimbingStairs {
	public int climbStairs(int n) {
		int[] steps = new int[n + 1];
		steps[0] = 1;
		steps[1] = 1;
		for(int i = 2; i <= n; i++){
			steps[i] = steps[i - 1] + steps[i - 2];
		}
		return steps[n];
	}
	
	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(2));
	}
}