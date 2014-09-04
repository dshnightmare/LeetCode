import java.util.Stack;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int len = height.length, low = 0, high = len - 1;
		int maxArea = 0;
		while (low < high) {
			maxArea = Math.max(maxArea,
					(high - low) * Math.min(height[low], height[high]));
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}
		return maxArea;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 4, 3, 2, 1, 2, 3, 4 };
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}

}
