public class EditDistance {
	public int minDistance(String word1, String word2) {
		int[][] min = new int[word1.length() + 1][word2.length() + 1];
		// init
		for(int i = 1; i <= word1.length(); i++)
			min[i][0] = i;
		for(int i = 1; i <= word2.length(); i++)
			min[0][i] = i;
		for(int i = 0; i < word1.length(); i++){
			for(int j = 0; j < word2.length(); j++){
				if(word1.charAt(i) == word2.charAt(j))
					min[i + 1][j + 1] = min[i][j];
				else
					min[i + 1][j + 1] = Math.min(Math.min(min[i][j + 1], min[i + 1][j]), min[i][j]) + 1;
			}
		}
		return min[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		
	}
}