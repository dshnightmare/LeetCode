public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if(s == null)
			return p == null;
		if(p == null)
			return s == null;
		int sLen = s.length(), pLen = p.length();
		int count = 0;
        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) != '*')
                count++;
        }
        if (count > sLen)
            return false;
		boolean[][] status = new boolean[sLen + 1][pLen + 1];
		status[0][0] = true;
		for(int j = 1; j <= pLen; j++){
			if(p.charAt(j - 1) == '*'){
				int i = sLen + 1;
				for(int k = 0; k <= sLen; k++){
					if(status[k][j - 1]){
						i = k;
						break;
					}
				}
				for(; i <= sLen; i++)
					status[i][j] = true;
			}
			else {
				for(int i = 1; i <= sLen; i++){
					if(status[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'))
						status[i][j] = true;
				}
			}
			status[0][j] = status[0][j - 1] && (p.charAt(j - 1) == '*');
		}
		return status[sLen][pLen];
	}
	
	public static void main(String[] args){
		System.out.println(new WildcardMatching().isMatch("ab", "*?*?*"));
	}
}