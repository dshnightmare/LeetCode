public class SpiralMatrix2 {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		fill(result, 0, n - 1, 0, n - 1, 1);
		return result;
	}
	
	private void fill(int[][] matrix, int top, int bottom, int left, int right, int cur) {
		if(top > bottom || left > right){
		}
		else if(top == bottom){
			for(int i = left; i <= right; i++)
				matrix[top][i] = cur++;
		}
		else if(left == right){
			for(int i = top; i <= bottom; i++)
				matrix[i][left] = cur++;
		}
		else{
			// top
			for(int i = left; i < right; i++)
				matrix[top][i] = cur++;
			// right
			for(int i = top; i < bottom; i++)
				matrix[i][right] = cur++;
			// bottom
			for(int i = right; i > left; i--)
				matrix[bottom][i] = cur++;
			// left
			for(int i = bottom; i > top; i--)
				matrix[i][left] = cur++;
			fill(matrix, top + 1, bottom - 1, left + 1, right - 1, cur);
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new SpiralMatrix2().generateMatrix(3);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}