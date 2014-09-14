import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNumber {
	public List<String> letterCombinations(String digits) {
		char a[][] = {{' '}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, 
						{'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
						{'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
		List<String> r = new ArrayList<>();
		trans(a, digits.toCharArray(), digits.toCharArray(), 0, r);
		return r;
	}
	
	private void trans(char a[][], char cd[], char r[], int length, List<String> result)
	{
		if(length == cd.length)
		{
			result.add(new String(r));
			return;
		}
		int num = cd[length] - '0';
		for(int i = 0; i < a[num].length; i++){
			r[length] = a[num][i];
			trans(a, cd, r, length + 1, result);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> r = new ArrayList<>();
		r = new LetterCombinationPhoneNumber().letterCombinations("23");
		for (String string : r) {
			System.out.println(string);
		}
	}

}
