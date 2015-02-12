public class SingleNumber {
	public int singleNumber(int[] A) {
		int result = 0;
		for(int i = 0; i < A.length; i++) {
			result ^= A[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {2,2,4,4,1};
		System.out.println(new SingleNumber().singleNumber(A));
	}
}