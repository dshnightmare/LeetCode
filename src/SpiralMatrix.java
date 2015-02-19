import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
	private List<Integer> result;
	public List<Integer> spiralOrder(int[][] matrix) {
		result = new ArrayList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		fill(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
		return result;
	}
	
	private void fill(int[][] matrix, int top, int bottom, int left, int right) {
		if(top > bottom || left > right){
		}
		else if(top == bottom){
			for(int i = left; i <= right; i++)
				result.add(matrix[top][i]);
		}
		else if(left == right){
			for(int i = top; i <= bottom; i++)
				result.add(matrix[i][left]);
		}
		else{
			// top
			for(int i = left; i < right; i++)
				result.add(matrix[top][i]);
			// right
			for(int i = top; i < bottom; i++)
				result.add(matrix[i][right]);
			// bottom
			for(int i = right; i > left; i--)
				result.add(matrix[bottom][i]);
			// left
			for(int i = bottom; i > top; i--)
				result.add(matrix[i][left]);
			fill(matrix, top + 1, bottom - 1, left + 1, right - 1);
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 2}, {3, 4}};
		List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
		for(Integer i : result)
			System.out.print(i + " ");
	}
}