
public class Implement_strStr {
	public String strStr(String haystack, String needle) {
		//kmp or sunday
		if(haystack == null || needle == null)
			return null;
		if(needle.length() == 0)
			return haystack; 
		int next[] = new int[needle.length()];
		kmp_next(needle.toCharArray(), next);
		if(haystack.length() < needle.length())
			return null;
		int index = 0, i = 0, j = 0;
		while(i < haystack.length() && j < needle.length()){
			if(haystack.charAt(i) == needle.charAt(j)){
				i++;
				j++;
			}
			else {
				index += (j - next[j]);
				if(next[j] != -1)
					j = next[j];
				else {
					j = 0;
					i++;
				}
			}
		}
		
		if(j == needle.length())
			return haystack.substring(index);
		else
			return null;
	}

	public void kmp_next(char s[], int next[]){
		next[0] = -1;
		int k = -1, j = 0;
		while(j < s.length - 1){
			if(k != -1 && s[k] != s[j])
				k = next[k];
			++j;
			++k;
			if(s[k] == s[j])
				next[j] = next[k];
			else
				next[j] = k;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Implement_strStr().strStr("mississippi", "a"));
	}

}
