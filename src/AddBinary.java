public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int cin = 0;
		int length = Math.max(a.length(), b.length());
		for(int i = 0; i < length; i++){
			int sum = 0;
			if(i < a.length())
				sum += (a.charAt(a.length() - 1 - i) - '0');
			if(i < b.length())
				sum += (b.charAt(b.length() - 1 - i) - '0');
			sum += cin;
			if(sum > 1){
				sum -= 2;
				cin = 1;
			}else
				cin = 0;
			result.append((char)('0' + sum));
		}
		if(cin > 0)
			result.append((char)('0' + cin));
		return result.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("1010", "1011"));
	}
}