public class CountandSay {
	public String countAndSay(int n) {
		String num = 1 + "";
		for(int i = 1; i < n; i++){
			StringBuilder a = new StringBuilder();
			char[] all = num.toCharArray();
			int count = 1;
			for(int j = 1; j < num.length(); j++){
				if(all[j] != all[j - 1]){
					a.append(count);
					a.append(all[j - 1]);
					count = 1;
				}
				else
					count++;
			}
			a.append(count);
			a.append(all[all.length - 1]);
			num = a.toString();
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CountandSay().countAndSay(3));
	}

}
