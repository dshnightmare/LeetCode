public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int row = dungeon.length, col = dungeon[0].length;
		int[][] count = new int[row][col];
		if(dungeon[row - 1][col - 1] >= 0)
			count[row - 1][col - 1] = 0;
		else
			count[row - 1][col - 1] = -dungeon[row - 1][col - 1];
		for(int i = row - 2; i >= 0; i--){
			count[i][col - 1] = count[i + 1][col - 1] - dungeon[i][col - 1];
			if(count[i][col - 1] < 0)
				count[i][col - 1] = 0;
		}
		for(int i = col - 2; i >= 0; i--){
			count[row - 1][i] = count[row - 1][i + 1] - dungeon[row - 1][i];
			if(count[row - 1][i] < 0)
				count[row - 1][i] = 0;
		}
		for(int i = row - 2; i >= 0; i--){
			for(int j = col - 2; j >= 0; j--){
				int min = Math.min(count[i + 1][j], count[i][j + 1]);
				count[i][j] = min - dungeon[i][j];
				if(count[i][j] < 0)
					count[i][j] = 0;
			}
		}
		return count[0][0] + 1;
	}
	
	public static void main(String[] args) {
		
	}
}