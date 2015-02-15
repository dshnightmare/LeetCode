public class DecodeWays {
	// 数量可以用动态规划，每个实例就要用递归？
	public int numDecodings(String s) {
		int length = s.length();
		if(length == 0)
			return 0;
		if(s.charAt(0) == '0')
			return 0;
		if(length == 1)
			return 1;
		int[] num = new int[length];
		num[0] = 1;
		for(int i = 1; i < length; i++) {
			int tt = Integer.parseInt(s.substring(i - 1, i + 1));
			if(s.charAt(i) == '0'){
				if(tt != 0 && tt <= 26){
					if(i < 2)
						num[i] = 1;
					else
						num[i] = num[i - 2];
					num[i - 1] = 0;
				}
				else
					return 0;
			}
			else{
				if(Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
					if(i < 2)
						num[i] = num[i - 1] + 1;
					else
						num[i] = num[i - 1] + num[i - 2];
				}
				else
					num[i] = num[i - 1];
			}
		}
		return num[length - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("11"));
	}
}