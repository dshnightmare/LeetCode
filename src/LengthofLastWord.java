/**
 * 
 */

/**
 * @author dengshihong
 *
 */
public class LengthofLastWord {
	
	public int lengthOfLastWord(String s) {
        int r = 0, rr = 0;
        for(int i = 0; i < s.length(); i++)
        {
        	if(s.charAt(i) == ' ')
        	{
        		if(r != 0)
        			rr = r;
        		r = 0;
        	}
        	else
				r++;
        }
        return r == 0 ? rr:r;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LengthofLastWord().lengthOfLastWord("a "));
	}

}
