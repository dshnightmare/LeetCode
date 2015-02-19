public class SingleNumber2 {
	// mod 3
	// state machine
	public int singleNumber(int[] A) {
		int b1 = 0, b0 = 0, reset = 0;
		for(int i = 0; i < A.length; i++){
			b1 |= (b0 & A[i]);
			b0 ^= A[i];
			reset = b1 & b0;
			b1 = b1 ^reset;
			b0 = b0 ^reset;
		}
		return b0;
	}
	
	public static void main(String[] args) {
		
	}
}