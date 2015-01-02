public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		int length = s1.length();
		boolean[][][] status = new boolean[length][length][length];
		String s11, s22;
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				if(s1.charAt(i) == s2.charAt(j))
					status[0][i][j] = true;
			}
		}
		for(int i = 2; i <= length; i++){
			for(int j = 0; j <= length - i; j++){
				for(int k = 0; k <= length - i; k++){
					s11 = s1.substring(j, j + i);
					s22 = s2.substring(k, k + i);
					if(s11.equals(s22))
						status[i - 1][j][k] = true;
					else{
						for(int l = 1; l <= i - 1; l++){
							if(status[l - 1][j][k + l] && status[i - l - 1][j + l][k]){
								status[i - 1][j][k] = true;
								break;
							}
						}
					}
				}
			}
		}
		return status[length - 1][0][0];
	}
	
	public static void main(String[] args){
		System.out.println(new ScrambleString().isScramble("great", "rgeat"));
	}
}