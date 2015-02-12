import java.util.HashMap;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		boolean flag = true;
		long lnumerator = numerator, ldenominator = denominator;
		if(numerator == 0)
			return "0";
		if(numerator < 0){
			lnumerator = -lnumerator;
			flag = !flag;
		}
		if(denominator < 0){
			ldenominator = -ldenominator;
			flag = !flag;
		}
		String result = help(lnumerator, ldenominator);
		if(flag)
			return result;
		else
			return "-" + result;
	}
	
	private String help(long numerator, long denominator) {
		System.out.println(numerator + " " + denominator);
		HashMap<Long, Integer> map = new HashMap<>();
		long before, remainder;
		StringBuilder after = new StringBuilder();
		before = numerator / denominator;
		remainder = numerator % denominator;
		while(remainder != 0){
			remainder *= 10;
			if(map.containsKey(remainder)){
				break;
			}
			map.put(remainder, after.length());
			after.append(remainder / denominator);
			remainder = remainder % denominator;
		}
		if(remainder == 0){
			if(after.length() == 0)
				return before + "";
			else
				return before + "." + after.toString();
		}
		else
			return before + "." + after.substring(0, map.get(remainder))+ "(" + after.substring(map.get(remainder))+ ")";
	}
	
	public static void main(String[] args) {
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
	}
}