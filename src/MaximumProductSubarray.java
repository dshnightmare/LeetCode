public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		int length = A.length;
		int max;
		int[] pos = new int[length], neg = new int[length];
		if(A[0] >= 0){
			max = pos[0] = A[0];
		}
		else{
			max = neg[0] = A[0];
		}
		for(int i = 1; i < length; i++){
			if(A[i] > 0){
				if(pos[i - 1] > 0)
					pos[i] = A[i] * pos[i - 1];
				else
					pos[i] = A[i];
				if(neg[i - 1] < 0)
					neg[i] = A[i] * neg[i - 1];
			}
			else if(A[i] < 0){
				if(neg[i - 1] < 0){
					pos[i] = A[i] * neg[i - 1];
				}
				if(pos[i - 1] > 0)
					neg[i] = A[i] * pos[i - 1];
				else
					neg[i] = A[i];
			}
			if(pos[i] > max)
				max = pos[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {-2, 3, -4};
		System.out.println(new MaximumProductSubarray().maxProduct(a));
	}
}