public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int row = board.length, col = board[0].length;
		boolean[][] status = new boolean[row][col];
		boolean result = false;
		char[] cword = word.toCharArray();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == cword[0]){
					status[i][j] = true;
					result = search(i, j, board, status, cword, 1);
					status[i][j] = false;
					if(result)
						return result;
				}
			}
		}
		return result;
	}
	
	private boolean search(int row, int col, char[][] board, boolean[][] status, char[] word, int index) {
		if(index == word.length)
			return true;
		boolean result = false;
		// four direction
		// up
		if(row - 1 >= 0 && !status[row - 1][col] && board[row - 1][col] == word[index]){
			status[row - 1][col] = true;
			result = search(row - 1, col, board, status, word, index + 1);
			status[row - 1][col] = false;
			if(result)
				return result;
		}
		// down
		if(row + 1 < board.length && !status[row + 1][col] && board[row + 1][col] == word[index]){
			status[row + 1][col] = true;
			result = search(row + 1, col, board, status, word, index + 1);
			status[row + 1][col] = false;
			if(result)
				return result;
		}
		// left
		if(col - 1 >= 0 && !status[row][col - 1] && board[row][col - 1] == word[index]){
			status[row][col - 1] = true;
			result = search(row, col - 1, board, status, word, index + 1);
			status[row][col - 1] = false;
			if(result)
				return result;
		}
		// right
		if(col + 1 < board[0].length && !status[row][col + 1] && board[row][col + 1] == word[index]){
			status[row][col + 1] = true;
			result = search(row, col + 1, board, status, word, index + 1);
			status[row][col + 1] = false;
			if(result)
				return result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		System.out.println(new WordSearch().exist(board, "ABCCED"));
	}
}