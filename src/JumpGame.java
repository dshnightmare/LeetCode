public class JumpGame {
	public boolean canJump(int[] A) {
		int max = A[0], i = 1;
		while(max < A.length && i <= max) {
			if(i + A[i] > max)
				max = i + A[i];
			i++;
		}
		if(max >= A.length - 1)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		int[] A = {2, 3, 1, 1, 0};
		System.out.println(new JumpGame().canJump(A));
	}
}