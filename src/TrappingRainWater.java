import java.util.Stack;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class TrappingRainWater {
	public int trap(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int all = 0, max = 0, index = 0;
		for(int i = 0; i < A.length; i++){
			if(A[i] >= max)
			{
				int sum = 0, count = 0;
				while(!stack.empty()){
					sum += stack.pop();
					count++;
				}
				all += (max * count - sum);
				System.out.printf("%d, %d\n", all, i);
				max = A[i];
				index = i;
			}
			stack.push(A[i]);
		}
		stack = new Stack<>();
		max = 0;
		for(int i = A.length - 1; i >= index; i--){
			if(A[i] >= max)
			{
				int sum = 0, count = 0;
				while(!stack.empty()){
					sum += stack.pop();
					count++;
				}
				all += (max * count - sum);
				System.out.printf("%d, %d\n", all, i);
				max = A[i];
			}
			stack.push(A[i]);
		}
		return all;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(A));
	}

}
