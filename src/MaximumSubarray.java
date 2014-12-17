import javax.sound.midi.MidiChannel;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		return maxSum(A, 0, A.length - 1);
	}

	private int maxSum(int[] A, int left, int right){
		if(left == right)
			return A[left];
		if(right - left == 1){
			if(A[left] > 0 && A[right] > 0)
				return A[left] + A[right];
			else
				return A[left] > A[right] ? A[left] : A[right];
		}
		int mid = (left + right) / 2;
		int sum1 = maxSum(A, left, mid - 1);
		int sum2 = maxSum(A, mid + 1, right);
		int sum = 0, max1 = 0, max2 = 0;
		for(int i = mid - 1; i >= left; i--){
			sum += A[i];
			if(sum > max1)
				max1 = sum;
		}
		sum = 0;
		for(int i = mid + 1; i <= right; i++){
			sum += A[i];
			if(sum > max2)
				max2 = sum;
		}
		sum = max1 + max2 + A[mid];
		return (sum1 > sum2 ? sum1 : sum2) > sum ? (sum1 > sum2 ? sum1 : sum2) : sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5,4};
		System.out.println(new MaximumSubarray().maxSubArray(A));
	}

}
