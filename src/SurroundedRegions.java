import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board == null)
			return;
		int row = board.length;
		if(row == 0)
			return;
		int col = board[0].length;
		boolean flag;
		List<Grid> region = new ArrayList<>();
		Queue<Grid> bfs = new LinkedList<>();
		int[][] check = new int[row][col];
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(board[i][j] == 'O' && check[i][j] == 0){
					flag = true;
					region.clear();
					bfs.add(new Grid(i, j));
					check[i][j] = 1;
					while(!bfs.isEmpty()){
						Grid cur = bfs.poll();
						region.add(cur);
						int x = cur.x, y = cur.y;
						check[x][y] = 1;
						if(x == 0 || x == row - 1 || y == 0 || y == col - 1)
							flag = false;
						//up
						if(x - 1 >= 0 && board[x - 1][y] == 'O' && check[x - 1][y] == 0){
							bfs.add(new Grid(x - 1, y));
							check[x - 1][y] = 1;
						}
						//down
						if(x + 1 < row && board[x + 1][y] == 'O' && check[x + 1][y] == 0){
							bfs.add(new Grid(x + 1, y));
							check[x + 1][y] = 1;
						}
						//left
						if(y - 1 >= 0 && board[x][y - 1] == 'O' && check[x][y - 1] == 0){
							bfs.add(new Grid(x, y - 1));
							check[x][y - 1] = 1;
						}
						//right
						if(y + 1 < col && board[x][y + 1] == 'O' && check[x][y + 1] == 0){
							bfs.add(new Grid(x, y + 1));
							check[x][y + 1] = 1;
						}
					}
					if(flag == true){
						for(Grid g : region) {
							board[g.x][g.y] = 'X';
						}
					}
				}
			}
		}
	}
	
	public class Grid {
		int x;
		int y;
		Grid(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}
	
	public static void main(String[] args){
		
	}
}