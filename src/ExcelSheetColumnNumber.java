public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
		int result = 0;
        for(int i = 0; i < s.length(); i++){
        	result *= 26;
			result += s.charAt(i) - 'A' + 1;
        }
		return result;
    }
	
	public static void main(String[] args){
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("AA"));
	}
}