public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int[][] col = new int[9][9], row = new int[9][9], grid = new int[9][9];
		int i = 0, j = 0;
		for(i = 0; i < 9; i++){
			for(j = 0; j < 9; j++){
				char c = board[i][j];
				if(c == '.')
					continue;
				else if(col[i][c - '1'] == 0 && row[j][c - '1'] == 0 && grid[i / 3 * 3 + j / 3][c - '1'] == 0){
					col[i][c - '1'] = 1;
					row[j][c - '1'] = 1;
					grid[i / 3 * 3 + j / 3][c - '1'] = 1;
				}
				else
					break;
			}
			if(j != 9)
				break;
		}
		if(i == 9 && j == 9)
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
