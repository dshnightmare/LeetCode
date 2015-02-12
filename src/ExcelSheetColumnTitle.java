public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		n--;
		StringBuilder result = new StringBuilder();
		while(n >= 0) {
			result.append((char)('A' + n % 26));
			n /= 26;
			n--;
		}
		result.reverse();
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.print(new ExcelSheetColumnTitle().convertToTitle(27));
	}
}