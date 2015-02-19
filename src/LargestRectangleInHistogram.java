import java.util.Stack;

public class LargestRectangleInHistogram {
	// 大的进栈，小的出栈，再入栈
	public int largestRectangleArea(int[] height) {
		if(height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		int max = 0, i = 1;
		stack.push(-1);
		index.push(-1);
		stack.push(height[0]);
		index.push(0);
		while(stack.peek() != -1 && i < height.length){
			int top = stack.peek();
			if(height[i] >= top) {
				stack.push(height[i]);
				index.push(i);
			}
			else{
				int w = 0, h;
				while(stack.peek() > height[i]){
					h = stack.pop();
					w = index.pop();
					if(h * (i - w) > max)
						max = h * (i - w);
				}
				stack.push(height[i]);
				index.push(w);
			}
			i++;
		}
		while(stack.peek() != -1){
			int h = stack.pop();
			int w = index.pop();
			if(h * (i - w) > max)
				max = h * (i - w);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] num = {2,1,2};
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea(num));
	}
}