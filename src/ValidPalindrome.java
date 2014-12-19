public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while(left < right){
			while(left <= right && Character.isLetterOrDigit(s.charAt(left)) != true)
				left++;
			while(left <= right && Character.isLetterOrDigit(s.charAt(right)) != true)
				right--;
			if(left >= right || Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				break;
			else {
				left++;
				right--;
			}
		}
		if(left >= right)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidPalindrome().isPalindrome("1a2"));
	}

}
