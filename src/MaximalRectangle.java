import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0)
			return 0;
		int[] num = new int[matrix[0].length];
		int max = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == '0')
					num[j] = 0;
				else
					num[j]++;
			}
			max = Math.max(max, cal(num));
		}
		return max;
	}
	
	private int cal(int[] num){
		Stack<Integer> stack = new Stack<>();
		int max = 0, i = 0, tp, area;
		while(i < num.length){
			if(stack.isEmpty() || num[stack.peek()] <= num[i])
				stack.push(i++);
			else{
				tp = stack.pop();
				area = num[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if(max < area)
					max = area;
			}
		}
		
		while(!stack.isEmpty()){
			tp = stack.pop();
			area = num[tp] * (stack.isEmpty () ? i : i - stack.peek() - 1);
			if(max < area)
				max = area;
		}
		return max;
	}
	
	public static void main(String[] args){
		char[][] matrix = {{'1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '0'},
							{'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '0', '0', '0'},
							{'0', '1', '1', '1', '1', '0', '0', '0'}};
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}
}