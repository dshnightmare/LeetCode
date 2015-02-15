import java.util.Arrays;

public class MultiplyStrings {
	public String multiply(String num1, String num2){
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		char[] cnum1 = num1.toCharArray(), cnum2 = num2.toCharArray();
		char[] result = new char[cnum1.length + cnum2.length];
		Arrays.fill(result, '0');
		for(int i = 0; i < cnum1.length; i++){
			// chengshu
			int cin = 0;
			for(int j = cnum2.length - 1; j >= 0; j--){
				int index = cnum1.length + j - i;
				int num = (cnum1[cnum1.length - 1 - i] - '0') * (cnum2[j] - '0') + (cin + result[index] - '0');
				cin = num / 10;
				num = num % 10;
				result[index] = (char)(num + '0');
			}
			if(cin != 0){
				result[cnum1.length - 1 - i] = (char)(cin + '0');
			}
		}
		StringBuilder sb = new StringBuilder();
		if(result[0] != '0')
			sb.append(result[0]);
		for(int i = 1; i < result.length; i++)
			sb.append(result[i]);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("408", "5"));
	}
}