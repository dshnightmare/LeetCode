import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 */

/**
 * @author dengshihong
 *
 */
public class WordBreak2 {
    private ArrayList<String>[] matchindex;
    private ArrayList<Boolean>[] canmatch;
    private int end;
    public List<String> wordBreak(String s, Set<String> dict) {
        matchindex = new ArrayList[s.length()];
        canmatch = new ArrayList[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
        	matchindex[i] = new ArrayList<String>();
        	canmatch[i] = new ArrayList<Boolean>();
        }
        end = s.length();
        //System.out.println(end);
        List<String> result = new ArrayList<String>();
        for(String sub : dict)
            sundaySearch(s, sub, setCharstep(sub));
        System.out.println("begin to search");
        match(0, "", result);
        return result;
    }
    
    private boolean match(int begin, String before, List<String> result){
    	//System.out.println(begin);
    	boolean r = false;
    	for(int i = 0; i < matchindex[begin].size(); i++ )
    	{
    		if(canmatch[begin].get(i) == false)
    			continue;
    		if(begin + matchindex[begin].get(i).length() == end)
    		{
    			result.add(before + matchindex[begin].get(i));
    			r = true;
    		}
    		else
    		{
    			//System.out.println(before + matchindex[begin].get(i) + " ");
    			boolean tmp = match(begin + matchindex[begin].get(i).length(), before + matchindex[begin].get(i) + " ", result);
    			canmatch[begin].set(i, tmp);
    			r = r == true? true:tmp;
    		}
    	}
    	return r;
    }
    
    private int[] setCharstep(String sub){
        int[] charStep = new int[26];
        for(int i = 0; i < 26; i++)
            charStep[i] = sub.length() + 1;
        for(int i = 0; i < sub.length(); i++)
            charStep[sub.charAt(i) - 'a'] = sub.length() - i;
        return charStep;
    }
    
    private void sundaySearch(String s, String sub, int[] charStep)
	{
    	//System.out.println(sub);
		int mainlength = s.length(), sublength = sub.length();
		if(sublength > mainlength)
			return;
		int i = 0, j = 0;
		while(i < mainlength)
		{
			int tmp = i;
			if(i + sublength > mainlength)
				break;
			while(j < sublength)
			{
				if(s.charAt(i) == sub.charAt(j))
				{
					i++;
					j++;
					continue;
				}
				else{
					//不会再有匹配子串了
					if(tmp + sublength >= mainlength)
						return;
					char firstRightChar = s.charAt(tmp + sublength);
					i = tmp + charStep[firstRightChar - 'a'];
					j = 0;
					break;
				}
			}
			if(j == sublength)
			{
				//System.out.println(i - sublength);
				matchindex[i - sublength].add(sub);
				canmatch[i - sublength].add(true);
				if(tmp + sublength >= mainlength)
					return;
				char firstRightChar = s.charAt(tmp + sublength);
				i = tmp + charStep[firstRightChar - 'a'];
				j = 0;
			}
		}
		return;
	}
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	//String[] a = {"a","aa","aaaa"};
    	String[] a = {"aaaa","aa","a"};
    	Set<String> dict = new HashSet<String>(Arrays.asList(a));
    	List<String> resultList = new WordBreak2().wordBreak("aaaaaaa", dict);
    	System.out.println(resultList.size());
    	for(String string : resultList)
    		System.out.println(string);
    }
}