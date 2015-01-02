public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] status = new int[m][n];
		for(int i = 0; i < m; i++){
			if(obstacleGrid[i][0] == 1)
				break;
			status[i][0] = 1;
		}
		for(int j = 0; j < n; j++){
			if(obstacleGrid[0][j] == 1)
				break;
			status[0][j] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(obstacleGrid[i][j] == 1)
					status[i][j] = 0;
				else
					status[i][j] = status[i - 1][j] + status[i][j - 1];
			}
		}
		return status[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		
	}
}