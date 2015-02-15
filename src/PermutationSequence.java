import java.util.ArrayList;

public class PermutationSequence {
	private int[] permutation;
	
	public String getPermutation(int n, int k) {
		permutation = new int[n + 1];
		ArrayList<Integer> left = new ArrayList<>();
		int cal = 1;
		permutation[0] = 1;
		for(int i = 1; i <= n; i++) {
			cal *= i;
			permutation[i] = cal;
			left.add(i);
		}
		k--;
		return myGet(n, k, left);
	}
	
	private String myGet(int n, int k, ArrayList<Integer> left) {
		if(n == 0 || k >= permutation[n])
			return "";
		int index = k / permutation[n - 1];
		int cur = left.get(index);
		left.remove(index);
		return cur + myGet(n - 1, k % permutation[n - 1], left);
	}
	
	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(3, 1));
	}
}