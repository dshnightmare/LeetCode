public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix == null)
			return;
		int row = matrix.length, col = matrix[0].length;
		boolean rowHasZero = false, colHasZero = false;
		
		// whether first col has zero 
		for(int i = 0; i < row; i++){
			if(matrix[i][0] == 0){
				colHasZero = true;
				break;
			}
		}
		
		// whether first row has zero
		for(int i = 0; i < col; i++) {
			if(matrix[0][i] == 0){
				rowHasZero = true;
				break;
			}
		}
		
		// use first row and first col to store indices
		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// fill row
		for(int i = 1; i < row; i++){
			if(matrix[i][0] == 0){
				for(int j = 1; j < col; j++)
					matrix[i][j] = 0;
			}
		}
		
		// fill col
		for(int i = 1; i < col; i++){
			if(matrix[0][i] == 0){
				for(int j = 1; j < row; j++)
					matrix[j][i] = 0;
			}
		}
		
		if(rowHasZero){
			for(int i = 0; i < col; i++)
				matrix[0][i] = 0;
		}
		
		if(colHasZero){
			for(int i = 0; i < row; i++)
				matrix[i][0] = 0;
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0, 1}};
		new SetMatrixZeroes().setZeroes(matrix);
	}
}