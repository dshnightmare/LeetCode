import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class NQueens {
	// iteration for row difference, need flag for col and cross
	private List<String[]> result;
	private String[] cur;
	private StringBuilder boardRow;
	private boolean[] col, crossL, crossR;
	
	public List<String[]> solveNQueens(int n) {
		result = new ArrayList<>();
		cur = new String[n];
		char[] tmp = new char[n];
		Arrays.fill(tmp, '.');
		boardRow = new StringBuilder();
		boardRow.append(tmp);
		col = new boolean[n];
		crossL = new boolean[2 * n - 1];
		crossR = new boolean[2 * n - 1];
		generate(0, n);
		return result;
	}
	
	private void generate(int row, int n) {
		if(row == n){
			result.add(Arrays.copyOf(cur, cur.length));
		}
		for(int i = 0; i < n; i++) {
			if(!col[i] && !crossL[i + row] && !crossR[n - 1 - i + row]) {
				boardRow.setCharAt(i, 'Q');
				cur[row] = boardRow.toString();
				boardRow.setCharAt(i, '.');
				col[i] = true;
				crossL[i + row] = true;
				crossR[n - 1 - i + row] = true;
				generate(row + 1, n);
				col[i] = false;
				crossL[i + row] = false;
				crossR[n - 1 - i + row] = false;
			}
		}
	} 
	
	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(4).size());
	}
}