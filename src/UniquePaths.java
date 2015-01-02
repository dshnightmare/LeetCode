public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] status = new int[m][n];
		for(int i = 0; i < m; i++)
			status[i][0] = 1;
		for(int j = 1; j < n; j++)
			status[0][j] = 1;
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				status[i][j] = status[i - 1][j] + status[i][j - 1];
			}
		}
		return status[m - 1][n - 1];
	}
	
	public static void main(String[] args){
		
	}
}