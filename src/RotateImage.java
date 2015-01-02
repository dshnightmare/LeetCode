public class RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix == null)
			return;
		int mid = (matrix.length + 1) / 2;
		int l = matrix.length - 1;
		if(l < 0)
			return;
		for(int i = 0; i < mid; i++){
			for(int j = 0; j < mid; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[l - j][i];
				matrix[l - j][i] = matrix[l - i][l - j];
				matrix[l - i][l - j] = matrix[j][l - i];
				matrix[j][l - i] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}