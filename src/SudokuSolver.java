import java.util.ArrayList;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		int[][] col = new int[9][9], row = new int[9][9], grid = new int[9][9];
		ArrayList<Pos> list = new ArrayList<>();
		int i = 0, j = 0, toFill = 0;
		for(i = 0; i < 9; i++){
			for(j = 0; j < 9; j++){
				char c = board[i][j];
				if(c == '.'){
					toFill++;
					list.add(new Pos(i, j));
				}
				else{
					col[i][c - '1'] = 1;
					row[j][c - '1'] = 1;
					grid[i / 3 * 3 + j / 3][c - '1'] = 1;
				}
			}
		}
		fill(board, col, row, grid, list, toFill);
	}
	boolean fill(char[][] board, int[][] col, int[][] row, int[][] grid, ArrayList<Pos> list, int toFill){
		if(toFill == 0)
			return true;
		Pos pos = list.get(list.size() - toFill);
		int i = pos.x, j = pos.y;
		for(int k = 0; k < 9; k++){
			if(col[i][k] == 0 && row[j][k] == 0 && grid[i / 3 * 3 + j / 3][k] == 0)
			{
				board[i][j] = (char)(k + '1');
				col[i][k] = 1;
				row[j][k] = 1;
				grid[i / 3 * 3 + j / 3][k] = 1;
				if(fill(board, col, row, grid, list, toFill - 1) == true)
					return true;
				board[i][j] = '.';
				col[i][k] = 0;
				row[j][k] = 0;
				grid[i / 3 * 3 + j / 3][k] = 0;
			}
		}
		return false;
	}
	public class Pos{
		public int x, y;
		public Pos(int _x, int _y){
			x = _x;
			y = _y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[9][];
		String[] sb = {"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
		for(int i = 0; i < 9; i++)
			board[i] = sb[i].toCharArray();
		new SudokuSolver().solveSudoku(board);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
