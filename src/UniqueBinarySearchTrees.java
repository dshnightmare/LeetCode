public class UniqueBinarySearchTrees {
	private int[] num;
	public int numTrees(int n){
		num = new int[n + 1];
		num[0] = 1;
		num[1] = 1;
		return count(n);
	}
	
	public int count(int n) {
		int result = 0, ll, rr;
		for(int i = 0; i < n; i++){
			if(num[i] != 0)
				ll = num[i];
			else
				num[i] = ll = count(i);
			if(num[n - 1 - i] != 0)
				rr = num[n - 1 - i];
			else
				num[n - 1 - i] = rr = count(n - 1 - i);
			result += ll * rr;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().numTrees(3));
	}
}