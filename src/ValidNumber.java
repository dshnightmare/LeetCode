import java.util.regex.*;
	
public class ValidNumber {
	public boolean isNumber(String s) {
		String regex = "^ *(\\+|-)?((\\d+)|(\\.\\d+)|(\\d+\\.)|(\\d+\\.\\d+))(e((\\+|-)?)\\d+)? *$";
		java.util.regex.Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(s);
		return matcher.find();
	}
	
	public static void main(String[] args) {
		System.out.println(new ValidNumber().isNumber("1e+12  "));
	}
}